package edu.psu.ist.paymentmanagement.controller;
import java.util.Date;

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
                String currency = paymentView.promptCurrency();
                paymentOption = new Payment.Cash(currency);
            }
            case 2 -> {
                int cardNumber = paymentView.promptCardNumber();
                int CVV = paymentView.promptCVV();
                int expirationDate = paymentView.promptExpirationDate();
                String name = paymentView.promptCardHolderName();
                paymentOption = new Payment.Card(cardNumber, CVV, expirationDate, name);
            }
            case 3 -> {
                int giftCardCode = paymentView.promptGiftCardCode();
                paymentOption = new Payment.GiftCard(giftCardCode);
            }
            default -> {
                paymentView.invalidInput();
                return;
            }
        }

        double amount = paymentView.promptAmount();
        paymentModel = new Payment("PAY-" + System.currentTimeMillis(), paymentOption, amount, new Date());

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
        if (paymentModel != null && paymentModel.paymentOption != null) {
            savedPayment = new SavedPayment(userID, paymentModel.paymentOption, billingAddress);
            savedPayment.savePaymentMethod();
        }
    }

    public void updateSavedPayment(String billingAddress) {
        if (savedPayment != null && paymentModel != null) {
            savedPayment.updatePaymentMethod(paymentModel.paymentOption, billingAddress);
        }
    }
}