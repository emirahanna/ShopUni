package PaymentManagement.view;

import PaymentManagement.model.Payment;

public class PaymentView {
    public PaymentView() {
    }

    public void displayPaymentDetails() {
        System.out.println("Displaying payment details:");
        System.out.println("Payment ID: " + Payment.paymentID);
        System.out.println("Amount Paid: $" + Payment.amountPaid);
        System.out.println("Payment Method: " + Payment.paymentOption);
        System.out.println("Transaction Date: " + Payment.transactionDate);

    }

    public void refundProcessed() {
        System.out.println("Refund processed.");

    }

    public void denyRefund() {
        System.out.println("Payment is not refundable.");
    }
}
