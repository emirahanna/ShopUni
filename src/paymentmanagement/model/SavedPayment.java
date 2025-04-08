package paymentmanagement.model;

public class SavedPayment {
    private String userID;
    private Payment.PaymentOption paymentOption;
    private String billingAddress;

    public SavedPayment(String userID, Payment.PaymentOption paymentOption, String billingAddress) {
        this.userID = userID;
        this.paymentOption = paymentOption;
        this.billingAddress = billingAddress;
    }


    public void savePaymentMethod() {
        System.out.println("savePaymentMethod called for user: " + userID);
    }


    public void updatePaymentMethod(Payment.PaymentOption newPaymentOption, String newBillingAddress) {
        System.out.println("updatePaymentMethod for user: " + userID);
        this.paymentOption = newPaymentOption;
        this.billingAddress = newBillingAddress;
    }


    public Payment.PaymentOption getPaymentMethod() {
        System.out.println("getPaymentMethod called for user: " + userID);
        return paymentOption;
    }


}
