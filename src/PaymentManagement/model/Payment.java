package PaymentManagement.model;

public class Payment {
    private String paymentID;
    private PaymentOption paymentOption;
    private boolean successfulPayment;

    public void setSuccessfulPayment(boolean successfulPayment) {
        this.successfulPayment = successfulPayment;
    }


}
