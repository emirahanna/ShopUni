package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.OrderIDGenerator;
import edu.psu.ist.ordermanagement.model.Shipping;
import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.model.PaymentIDGenerator;
import edu.psu.ist.paymentmanagement.view.PaymentWizardFrame;
import edu.psu.ist.paymentmanagement.view.Step1Panel;
import edu.psu.ist.paymentmanagement.view.Step2Panel;
import edu.psu.ist.paymentmanagement.view.WizardStepPanel;

import javax.swing.*;
import java.util.Date;

public class PaymentWizardController {
    private int currentStep;
    private PaymentWizardFrame view;
    private CartController cart;
    private Payment payment;
    private Order order;


    public PaymentWizardController(CartController cart) {
        currentStep = 0;
        this.cart = cart;
        view = new PaymentWizardFrame();
        attachActionListeners();
    }

    private void attachActionListeners() {
        attachNextButtonListeners();
        attachBackButtonListeners();
        attachRadioButtonListeners();
    }

    private void attachBackButtonListeners() {
        for (WizardStepPanel panel : view.getStepPanels()) {
            if (panel.getBackButton() != null) {
                panel.getBackButton().addActionListener(e -> previousStep());
            }
        }
    }

    private void attachNextButtonListeners() {
        try {
            view.getStepPanels().get(0).getNextButton().addActionListener(e -> {
                Step1Panel panel = (Step1Panel) view.getStepPanels().get(0);
                if (validateForm(panel.getNameTextField()) && validateForm(panel.getCardNumberTextField()) && validateForm(panel.getExpirationDateTextField())) {
                    if (panel.getDebitCardRadioButton().isSelected() || panel.getDebitCardRadioButton().isSelected()) {
                        createPayment(new Payment.Card(panel.getCardNumberTextField().getText(), Integer.parseInt(panel.getExpirationDateTextField().toString()), panel.getNameTextField().toString()));
                    } else {
                        createPayment(new Payment.GiftCard(panel.getCardNumberTextField().getText()));
                    }
                    nextStep();
                }
                else {
                    JOptionPane.showMessageDialog(view, "Fill in all text fields");
                }
            });
            view.getStepPanels().get(1).getNextButton().addActionListener(e -> {
                Step2Panel panel = (Step2Panel) view.getStepPanels().get(1);
                if (validateForm(panel.getNameTextField()) && validateForm(panel.getAddressTextField())) {
                    nextStep();
                    if (panel.getPickupRadioButton().isSelected()) {
                        createOrder(panel.getNameTextField().toString(), panel.getAddressTextField().toString(), Shipping.DeliveryOption.PICKUP);
                    } else {
                        createOrder(panel.getNameTextField().toString(), panel.getAddressTextField().toString(), Shipping.DeliveryOption.DELIVERY);
                    }
                } else {
                    JOptionPane.showMessageDialog(view, "Fill in all text fields");
                }
            });
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Please ensure the details are correct");
        }
    }

    private void attachRadioButtonListeners() {
        Step1Panel step1Panel = (Step1Panel) view.getStepPanels().get(0);
        step1Panel.getGiftCardRadioButton().addActionListener(e -> {
            step1Panel.toggleCardDisplay(false);
            step1Panel.toggleGiftCardDisplay(true);
        });
        step1Panel.getCreditCardRadioButton().addActionListener(e -> {
            step1Panel.toggleCardDisplay(true);
            step1Panel.toggleGiftCardDisplay(false);
        });
        step1Panel.getDebitCardRadioButton().addActionListener(e -> {
            step1Panel.toggleCardDisplay(true);
            step1Panel.toggleGiftCardDisplay(false);
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
            new CartController();
        }
    }

    private void createPayment(Payment.PaymentOption paymentOption) {
        payment = new Payment(PaymentIDGenerator.createID(), paymentOption, cart.getPrice(), new Date());
    }

    private void createOrder(String name, String address, Shipping.DeliveryOption deliveryOption) {
        order = new Order(OrderIDGenerator.createID() , payment, cart.getPrice(), new Date(), address, deliveryOption);
    }

    private boolean validateForm(JTextField textField) {
        return !textField.getText().isEmpty();
    }
}
