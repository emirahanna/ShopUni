package PaymentManagement.model;

public class SavedPayment {
    private String userID;
    private Payment.PaymentOption paymentOption;
    private String billingAddress;

    public SavedPayment(String userID, Payment.PaymentOption paymentOption, String billingAddress) {
        this.userID = userID;
        this.paymentOption = paymentOption;
        this.billingAddress = billingAddress;
    }
}
