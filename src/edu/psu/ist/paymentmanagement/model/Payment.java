package edu.psu.ist.paymentmanagement.model;

import edu.psu.ist.usermanagement.model.UserSession;

import java.time.LocalDate;
import java.util.Date;

public class Payment {
    //don't mind this, I am testing out using sealed interfaces and records
    public sealed interface PaymentOption {
    }

    public record Card(String cardNumber, int expirationDate, String name) implements PaymentOption {
        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    public record GiftCard(String giftCardCode) implements PaymentOption {
        @Override
        public String toString() {
            return getClass().getSimpleName();
        }
    }

    private String paymentID;
    private PaymentOption paymentOption;
    private double amountPaid;
    private LocalDate transactionDate;
    private String userID;

    public Payment(String paymentID, PaymentOption paymentOption, double amountPaid, LocalDate transactionDate) {
        this.paymentID = paymentID;
        this.paymentOption = paymentOption;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
        this.userID = UserSession.getInstance().getUserID();
    }

    public void refundPayment() {
        System.out.println("refundPayment method called.");
        if (isRefundable()) {
            System.out.println("Refunding " + amountPaid + " to " + paymentOption);
        } else {
            System.out.println("Payment is not refundable for ID#: " + paymentID);
        }
    }

    public boolean isRefundable() {
        System.out.println("isRefundable method called.");
        return true; // stub for testing
    }

    public String generatesReceipt() {
        System.out.println("generatesReceipt method called.");

        return "Receipt:\nPayment ID: " + paymentID + "\nAmount Paid: $" + amountPaid + "\nDate: " + transactionDate + "\nPayment Method: " + paymentOption;
    }

    public PaymentOption getPaymentOption() {
        return paymentOption;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }

}
