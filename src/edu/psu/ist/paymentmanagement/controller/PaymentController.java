package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.view.PaymentView;

public class PaymentController {
    private Payment paymentModel;
    private PaymentView paymentView;

    public PaymentController() {
        this.paymentView = new PaymentView();
    }


    /** 
     *  Method to show payment details
     */
    public void showPaymentDetails() {
        System.out.println("showPaymentDetails called.");

        if (paymentView != null) {
            paymentView.printReceipt(paymentModel.generatesReceipt());
        } else {
            System.out.println("Payment view not available.");
        }
    }

    public Payment getPaymentModel() {
        return paymentModel;
    }
}

