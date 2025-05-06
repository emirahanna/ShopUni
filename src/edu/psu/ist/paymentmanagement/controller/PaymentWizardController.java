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
    private PaymentFacade paymentFacade;
    private CartSnapshot cart;
    private Payment payment;
    private Order order;

    public PaymentWizardController(CartSnapshot cart) {
        this.currentStep = 0;
        this.cart = cart;
        this.view = new PaymentWizardFrame();
        this.paymentFacade = new PaymentFacade();
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

    private void attachHomeButtonListener() {
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);

        step3Panel.getHomeButton().addActionListener(e -> {
            view.dispose();
            new MenuController();
        });
    }

    private void attachTrackOrderButtonListener() {
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);

        step3Panel.getTrackOrderButton().addActionListener(e -> {
            view.dispose();
            new OrderTableController();
        });
    }

    private void handleStep1Next(Step1Panel panel) {
        if (panel.getCreditCardRadioButton().isSelected() || panel.getDebitCardRadioButton().isSelected()) {
            if (InputValidator.areFieldsFilled(panel, panel.getCardNumberTextField(), panel.getExpirationDateTextField(), panel.getNameTextField())) {
                Integer expDate = InputValidator.parseInteger(panel, panel.getExpirationDateTextField().getText(), "Expiration Date");
                Long cardNum = InputValidator.parseLong(panel, panel.getCardNumberTextField().getText(), "Card Number");

                if (expDate == null || cardNum == null) return;

                if (!paymentFacade.isValidExpirationDate(expDate)) {
                    JOptionPane.showMessageDialog(panel, "The expiration date cannot be in the past.");
                    return;
                }

                Payment.Card card = new Payment.Card(cardNum, expDate, panel.getNameTextField().getText().trim());
                payment = paymentFacade.processPayment(card, cart.getTotal());
                nextStep();
            }
        } else if (panel.getGiftCardRadioButton().isSelected()) {
            if (InputValidator.areFieldsFilled(panel, panel.getGiftCardNumberTextField())) {
                Payment.GiftCard giftCard = new Payment.GiftCard(panel.getGiftCardNumberTextField().getText().trim());
                payment = paymentFacade.processPayment(giftCard, cart.getTotal());
                nextStep();
            }
        } else {
            JOptionPane.showMessageDialog(panel, "Please select a payment method.");
        }
    }

    private void handleStep2Next(Step2Panel panel) {
        if (InputValidator.areFieldsFilled(panel, panel.getNameTextField(), panel.getAddressTextField())) {
            Shipping.DeliveryOption option = panel.getPickupRadioButton().isSelected() ? Shipping.DeliveryOption.PICKUP : Shipping.DeliveryOption.DELIVERY;

            order = paymentFacade.placeOrder(payment, panel.getNameTextField().getText().trim(), panel.getAddressTextField().getText().trim(), cart, option);
            nextStep();
            handleStep3Panel();
        }
    }

    private void handleStep3Panel() {
        Step3Panel step3Panel = (Step3Panel) view.getStepPanels().get(2);
        step3Panel.getOrderLabel().setText(generateOrderLabel());
        CartDAO.deleteCartItemsForUser(UserSession.getInstance().getUserID());
        CartManager.getInstance().emptyCart();
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
            view.setVisible(false);
        }
    }
    private String generateOrderLabel() {
        String summary = order.generateOrderSummary() + "\n" + payment.generatesReceipt();
        return "<html>" + summary.replaceAll("\n", "<br>") + "</html>";
    }
}
