package PaymentManagement.controller;

import PaymentManagement.model.Payment;
import PaymentManagement.view.PaymentView;
import ProductManagement.model.Inventory;

import java.util.Date;

public class PaymentController {
    private Payment paymentModel;
    private PaymentView paymentView;
    private Inventory inventory;

    /**Constructor to initialize with an existing Payment model
     */
    public PaymentController(Payment paymentModel, PaymentView paymentView, Inventory inventory) {
        this.paymentModel = paymentModel;
        this.paymentView = paymentView;
        this.inventory = inventory;
    }

    /**
     * Method to process a payment
     *
     * @param paymentID
     * @param paymentOption
     * @param amountPaid
     * @return
     */
    public boolean processPayment(String paymentID, Payment.PaymentOption paymentOption, double amountPaid) {
        if (inventory == null || !inventory.isAvailable()) {
            System.out.println("Payment failed: Product out of stock.");
            return false; // Block purchase if no stock
        }

        paymentModel = new Payment();
        // Set attributes
        paymentModel.paymentID = paymentID;
        paymentModel.paymentOption = paymentOption;
        paymentModel.amountPaid = amountPaid;
        paymentModel.transactionDate = new Date();

        boolean paymentSuccess = sendToPaymentProcessor(amountPaid);

        if (paymentSuccess) {
            inventory.reduceStock();  // Reduce stock since payment was successful
            System.out.println("Payment successful. Order confirmed.");
            return true;
        } else {
            System.out.println("Payment failed. Please try again.");
            return false;
        }
    }

    private boolean sendToPaymentProcessor(double amountPaid) {
        return amountPaid > 0; // this is to simulate a real payment
    }

    /**
     * Method to refund a payment
     *
     * @return
     */
    public boolean refundPayment() {
        System.out.println("refund process initiated.");

        if (paymentModel != null && paymentModel.isRefundable()) {
            System.out.println("Refund processed.");
            inventory.addStock(); // Restock item on refund
            return true;
        } else {
            System.out.println("Refund denied.");
            return false;
        }
    }

    /** Method to show payment details
     *
     */
    public void showPaymentDetails() {
        System.out.println("showPaymentDetails called.");

        if (paymentView != null) {
            paymentView.displayPaymentDetails();
        } else {
            System.out.println("Payment view not available.");
        }
    }
}

