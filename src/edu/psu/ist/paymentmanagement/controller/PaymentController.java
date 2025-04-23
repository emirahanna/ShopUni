package edu.psu.ist.paymentmanagement.controller;

import java.util.Date;

import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.view.PaymentView;

public class PaymentController {
    private Payment paymentModel;
    final PaymentView paymentView;

    public PaymentController() {
        this.paymentView = new PaymentView();
        processPayment();
    }

    public void processPayment() {
        int choice = paymentView.promptPaymentOption();
        Payment.PaymentOption paymentOption;

        switch (choice) {
            case 1 -> { // Cash Payment
                String currency = paymentView.promptCurrency();
                paymentOption = new Payment.Cash(currency);
            }
            case 2 -> { // Card Payment
                int cardNumber = paymentView.promptCardNumber();
                int CVV = paymentView.promptCVV();
                int expirationDate = paymentView.promptExpirationDate();
                String name = paymentView.promptCardHolderName();
                paymentOption = new Payment.Card(cardNumber, CVV, expirationDate, name);
            }
            case 3 -> { // Gift Card Payment
                int giftCardCode = paymentView.promptGiftCardCode();
                paymentOption = new Payment.GiftCard(giftCardCode);
            }
            default -> {
                paymentView.invalidInput();
                return;
            }
        }
        paymentModel = new Payment("RANDOM ID", paymentOption, paymentView.promptAmount(), new Date());


        paymentView.paymentSuccessful();
    }

    /**
     * Method to refund a payment
     */
    public boolean refundPayment() {
        System.out.println("refundPayment called.");

        if (paymentModel != null && paymentModel.isRefundable()) {
            System.out.println("Refund processed.");
            return true;
        } else {
            System.out.println("Refund denied.");
            return false;
        }
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

