package PaymentManagement.controller;

import PaymentManagement.model.Payment;
import PaymentManagement.view.PaymentView;

import java.util.Date;

public class PaymentController {
    private Payment paymentModel;
    private PaymentView paymentView;

    /**Constructor to initialize with an existing Payment model
     */
    public PaymentController(Payment paymentModel, PaymentView paymentView) {
        this.paymentModel = paymentModel;
        this.paymentView = paymentView;
    }

    /** Method to process a payment
     *
     * @param paymentID
     * @param paymentOption
     * @param amountPaid
     */
    public void processPayment(String paymentID, Payment.PaymentOption paymentOption, double amountPaid) {
        paymentModel = new Payment();
        // Set attributes
        paymentModel.paymentID = paymentID;
        paymentModel.paymentOption = paymentOption;
        paymentModel.amountPaid = amountPaid;
        paymentModel.transactionDate = new Date();

        System.out.println("Payment processed [stub].");
    }

    /**
     * Method to refund a payment
     *
     * @return
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

