package PaymentManagement.model;

import java.util.Date;

public class Payment {
    //don't mind this, I am testing out using sealed interfaces and records
    public sealed interface PaymentOption {
    }
    record Card(int cardNumber, int CVV, int expirationDate, String name) implements PaymentOption {}
    record GiftCard(int giftCardCode) implements PaymentOption {}
    record Cash(String currency) implements PaymentOption {}

    private String paymentID;
    private PaymentOption paymentOption;
    private double amountPaid;
    private Date transactionDate;

    public void refundPayment() {
    }

    public boolean isRefundable() {
        return false;
    }

    public String generatesReceipt() {
        return "";
    }
}
