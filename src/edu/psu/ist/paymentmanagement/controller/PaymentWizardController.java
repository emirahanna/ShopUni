package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.cartmanagement.model.CartDAO;
import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.ordermanagement.controller.OrderTableController;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.OrderDAO;
import edu.psu.ist.ordermanagement.model.Shipping;
import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.model.PaymentDAO;
import edu.psu.ist.paymentmanagement.model.PaymentIDGenerator;
import edu.psu.ist.paymentmanagement.view.*;
import edu.psu.ist.usermanagement.model.UserSession;

import javax.swing.*;
import java.time.LocalDate;

public class PaymentWizardController {
    private int currentStep;
    private PaymentWizardFrame view;
    private CartSnapshot cart;
    private Payment payment;
    private Order order;

    public PaymentWizardController(CartSnapshot cart) {
        currentStep = 0;
        this.cart = cart;
        view = new PaymentWizardFrame();
        attachActionListeners();
    }

    private void attachActionListeners() {
        attachNextButtonListeners();
        attachBackButtonListeners();
        attachRadioButtonListeners();
        attachHomeButtonListener();
        attachTrackOrderButtonListener();
    }


    private void attachBackButtonListeners() {
        for (WizardStepPanel panel : view.getStepPanels()) {
            if (panel.getBackButton() != null) {
                panel.getBackButton().addActionListener(e -> previousStep());
            }
        }
    }

    private void attachNextButtonListeners() {
        Step1Panel step1 = (Step1Panel) view.getStepPanels().get(0);
        Step2Panel step2 = (Step2Panel) view.getStepPanels().get(1);

        step1.getNextButton().addActionListener(e -> handleStep1Next(step1));
        step2.getNextButton().addActionListener(e -> handleStep2Next(step2));
    }

    private void attachHomeButtonListener(){
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);

        step3Panel.getHomeButton().addActionListener(e -> {
            view.dispose();
            new MenuController();
        });
    }

    private void attachTrackOrderButtonListener(){
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);

        step3Panel.getTrackOrderButton().addActionListener(e -> {
            view.dispose();
            new OrderTableController();
        });
    }

    //this made the attachListener methods too long, so it now gets its own method
    private void handleStep1Next(Step1Panel panel) {
        if (panel.getCreditCardRadioButton().isSelected() || panel.getDebitCardRadioButton().isSelected()) {
            if (validateFields(panel, panel.getCardNumberTextField(), panel.getExpirationDateTextField(), panel.getNameTextField())) {
                Integer expDate = parseInteger(panel, panel.getExpirationDateTextField().getText(), "Expiration Date");
                Long cardNum = parseLong(panel, panel.getCardNumberTextField().getText().trim(), "Card Number");

                if (expDate == null) return;
                if (cardNum == null) return;

                createPayment(new Payment.Card(
                        cardNum,
                        expDate,
                        panel.getNameTextField().getText().trim()
                ));
                nextStep();
            }
        } else if (panel.getGiftCardRadioButton().isSelected()) {
            if (validateFields(panel, panel.getGiftCardNumberTextField())) {
                createPayment(new Payment.GiftCard(
                        panel.getGiftCardNumberTextField().getText().trim()
                ));
                nextStep();
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Please select a payment method.");
        }
    }

    private void handleStep2Next(Step2Panel panel) {
        if (validateFields(panel, panel.getNameTextField(), panel.getAddressTextField())) {
            //ternary operators.. so slick.. so divine
            Shipping.DeliveryOption option = panel.getPickupRadioButton().isSelected()
                    ? Shipping.DeliveryOption.PICKUP
                    : Shipping.DeliveryOption.DELIVERY;

            createOrder(
                    panel.getNameTextField().getText().trim(),
                    panel.getAddressTextField().getText().trim(),
                    option
            );
            nextStep();
            handleStep3Panel();
        }
    }

    private void handleStep3Panel(){
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);
        step3Panel.getOrderLabel().setText(generateOrderLabel());
        CartDAO.deleteCartItemsForUser(UserSession.getInstance().getUserID()); //clear cart items in database
        CartManager.getInstance().emptyCart(); //  clear in-memory cart
    }

    private void attachRadioButtonListeners() {
        Step1Panel panel = (Step1Panel) view.getStepPanels().get(0);
        panel.getGiftCardRadioButton().addActionListener(e -> {
            panel.toggleCardDisplay(false);
            panel.toggleGiftCardDisplay(true);
        });
        panel.getCreditCardRadioButton().addActionListener(e -> {
            panel.toggleCardDisplay(true);
            panel.toggleGiftCardDisplay(false);
        });
        panel.getDebitCardRadioButton().addActionListener(e -> {
            panel.toggleCardDisplay(true);
            panel.toggleGiftCardDisplay(false);
        });
    }

    public void nextStep() {
        currentStep++;
        view.repaintNextStep();
    }

    public void previousStep() {
        if (currentStep > 0) {
            currentStep--;
            view.repaintPreviousStep();
        } else {
            new CartController(); // Go back to cart
        }
    }

    private String generateOrderLabel(){
        String summary = order.generateOrderSummary() + "\n" + payment.generatesReceipt();
        return "<html>" + summary.replaceAll("\n", "<br>") + "</html>";
    }

    private void createPayment(Payment.PaymentOption paymentOption) {
        payment = new Payment(PaymentIDGenerator.createID(), paymentOption, cart.getTotal(),  LocalDate.now());
        PaymentDAO.insertPayment(payment);
    }

    private void createOrder(String name, String address, Shipping.DeliveryOption deliveryOption) {
        order = new Order(payment.getPaymentID(),
                LocalDate.now(),
                cart,
                address,
                deliveryOption);
        OrderDAO.insertOrder(order);

    }

    //  Helpers Please work....please....I need this to work! I will give my first 2 born, 2 childrens, please!
    private boolean validateFields(JComponent parent, JTextField... fields) { //helps to validate n number of fields, yay
        for (JTextField field : fields) {
            if (field.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(parent, "Please fill in all required fields.");
                return false;
            }
        }
        return true;
    }

    private Integer parseInteger(JComponent parent, String input, String fieldName) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, fieldName + " must be a valid number.");
            return null;
        }
    }

    private Long parseLong(JComponent parent, String input, String fieldName) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, fieldName + " must be a valid card number.");
            return null;
        }
    }
}
