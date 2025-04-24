package edu.psu.ist.paymentmanagement.model;

import java.util.Date;

public class Payment {
    //don't mind this, I am testing out using sealed interfaces and records
    public sealed interface PaymentOption {
    }
    public record Card(String cardNumber, int expirationDate, String name) implements PaymentOption {}
    public record GiftCard(String giftCardCode) implements PaymentOption {}

    public  String paymentID;
    public  PaymentOption paymentOption;
    public  double amountPaid;
    public  Date transactionDate;

    public Payment(String paymentID, PaymentOption paymentOption, double amountPaid, Date transactionDate) {
        this.paymentID = paymentID;
        this.paymentOption = paymentOption;
        this.amountPaid = amountPaid;
        this.transactionDate = transactionDate;
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

        return "Receipt:\nPayment ID: " + paymentID +
                "\nAmount Paid: $" + amountPaid +
                "\nDate: " + transactionDate +
                "\nPayment Method: " + paymentOption;
    }
}
