package PaymentManagement.model;

import java.util.Date;

public class Payment {
    //don't mind this, I am testing out using sealed interfaces and records
    public sealed interface PaymentOption {
    }
    record Card(int cardNumber, int CVV, int expirationDate, String name) implements PaymentOption {}
    record GiftCard(int giftCardCode) implements PaymentOption {}
    record Cash(String currency) implements PaymentOption {}

    public static String paymentID;
    public static PaymentOption paymentOption;
    public static double amountPaid;
    public static Date transactionDate;

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
        // return transactionDate.after(new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000)); // Refundable within 7 days
    }

    public String generatesReceipt() {
        System.out.println("generatesReceipt method called.");

        return "Receipt:\nPayment ID: " + paymentID +
                "\nAmount Paid: $" + amountPaid +
                "\nDate: " + transactionDate +
                "\nPayment Method: " + paymentOption;
    }
}
