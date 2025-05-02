package edu.psu.ist.paymentmanagement.controller;
import java.time.LocalDate;

import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.model.SavedPayment;
import edu.psu.ist.paymentmanagement.view.PaymentView;

public class PaymentFacade {
    final PaymentView paymentView;
    private Payment paymentModel;
    private SavedPayment savedPayment;

    public PaymentFacade() {
        this.paymentView = new PaymentView();
    }

    public void makePayment() {
        int choice = paymentView.promptPaymentOption();
        Payment.PaymentOption paymentOption;

        switch (choice) {
            case 1 -> {
                long cardNumber = Long.parseLong(paymentView.promptCardNumber());
                int expirationDate = paymentView.promptExpirationDate();
                String name = paymentView.promptCardHolderName();
                paymentOption = new Payment.Card(cardNumber, expirationDate, name);
            }
            case 2-> {
                String giftCardCode = paymentView.promptGiftCardCode();
                paymentOption = new Payment.GiftCard(giftCardCode);
            }
            default -> {
                paymentView.invalidInput();
                return;
            }
        }

        double amount = paymentView.promptAmount();
        paymentModel = new Payment("PAY-" + System.currentTimeMillis(), paymentOption, amount, LocalDate.now());

        paymentView.paymentSuccessful();
        paymentView.printReceipt(paymentModel.generatesReceipt());
    }

    public void refundPayment() {
        if (paymentModel != null && paymentModel.isRefundable()) {
            paymentModel.refundPayment();
            paymentView.refundProcessed();
        } else {
            paymentView.denyRefund();
        }
    }

    public void savePaymentMethod(String userID, String billingAddress) {
        if (paymentModel != null && paymentModel.getPaymentOption() != null) {
            savedPayment = new SavedPayment(userID, paymentModel.getPaymentOption(), billingAddress);
            savedPayment.savePaymentMethod();
        }
    }

    public void updateSavedPayment(String billingAddress) {
        if (savedPayment != null && paymentModel != null) {
            savedPayment.updatePaymentMethod(paymentModel.getPaymentOption(), billingAddress);
        }
    }
}