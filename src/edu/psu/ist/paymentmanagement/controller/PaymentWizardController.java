package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.view.PaymentWizardFrame;
import edu.psu.ist.paymentmanagement.view.Step2Panel;
import edu.psu.ist.paymentmanagement.view.WizardStepPanel;

import javax.swing.*;
import java.util.Date;

public class PaymentWizardController {
    private int currentStep;
    private PaymentWizardFrame view;
    private CartController cart;
    private Payment payment;



    public PaymentWizardController(CartController cart) {
        currentStep = 0;
        this.cart = cart;
        view = new PaymentWizardFrame();
        attachActionListeners();
    }

    private void attachActionListeners() {
        for (WizardStepPanel panel : view.getStepPanels()) {
            //should we make it individual?
            if (panel.getNextButton() != null) {
                panel.getNextButton().addActionListener(e -> {
                    if (panel instanceof Step2Panel) {
                        if (validateForm(((Step2Panel) panel).getNameTextField()) && validateForm(((Step2Panel) panel).getAddressTextField())) {
                            nextStep();
                        } else {
                            JOptionPane.showMessageDialog(view, "Fill in all text fields");
                        }
                    }
                    else{
                        nextStep();
                    }
                });
            }
            if (panel.getBackButton() != null) {
                panel.getBackButton().addActionListener(e -> previousStep());

            }
        }
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

    private void createPayment( Payment.PaymentOption paymentOption){
        payment = new Payment("Generate random string here",paymentOption, cart.getPrice(), new Date());
    }

    private boolean validateForm(JTextField textField) {
        return !textField.getText().isEmpty();
    }
}
