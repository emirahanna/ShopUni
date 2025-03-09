package PaymentManagement.controller;

import PaymentManagement.model.Payment;
import PaymentManagement.view.PaymentView;

import java.lang.reflect.Constructor;
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
    }

    /** Method to refund a payment
     *
     */
    public void refundPayment() {
        if (paymentModel.isRefundable()) {
            paymentModel.refundPayment();
            paymentView.refundProcessed();
        } else {
            paymentView.denyRefund();
        }
    }

    /** Method to show payment details
     *
     */
    public void showPaymentDetails() {
        paymentView.displayPaymentDetails();
    }
}

