package PaymentManagement.model;

import java.util.Date;

public class Payment {
    //don't mind this, I am testing out using sealed interfaces and records
    public sealed interface PaymentOption {
    }
    record Card(int cardNumber, int CVV, int expirationDate, String name) implements PaymentOption {}
    record GiftCard(int giftCardCode) implements PaymentOption {}
    record Cash(String currency) implements PaymentOption {}

    public String paymentID;
    public PaymentOption paymentOption;
    public double amountPaid;
    public Date transactionDate;

    public void refundPayment() {
        if (isRefundable()) {
            System.out.println("Refunding " + amountPaid + " to " + paymentOption);
        } else {
            System.out.println("Payment is not refundable.");
        }
    }

    public boolean isRefundable() {
        return transactionDate.after(new Date(System.currentTimeMillis() - 7L * 24 * 60 * 60 * 1000)); // Refundable within 7 days
    }

    public String generatesReceipt() {
        return "Receipt:\nPayment ID: " + paymentID +
                "\nAmount Paid: $" + amountPaid +
                "\nDate: " + transactionDate +
                "\nPayment Method: " + paymentOption;
    }
}
