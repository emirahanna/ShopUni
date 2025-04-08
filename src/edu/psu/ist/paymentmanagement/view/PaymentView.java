package edu.psu.ist.paymentmanagement.view;

import java.util.Scanner;

public class PaymentView {
    private Scanner scnr;
    public PaymentView() {
        scnr = new Scanner(System.in);
    }

    public int promptPaymentOption() {
        System.out.println("""
        Select Payment Option:
        1. Cash
        2. Card
        3. Gift Card
        """);
        return scnr.nextInt();
    }

    public String promptCurrency() {
        System.out.print("Enter currency (e.g., USD, EUR): ");
        return scnr.next();
    }

    public int promptCardNumber() {
        System.out.print("Enter card number: ");
        return scnr.nextInt();
    }

    public int promptCVV() {
        System.out.print("Enter CVV: ");
        return scnr.nextInt();
    }

    public int promptExpirationDate() {
        System.out.print("Enter expiration date (YYYYMM format): ");
        return scnr.nextInt();
    }

    public String promptCardHolderName() {
        System.out.print("Enter cardholder name: ");
        return scnr.next();
    }

    public int promptGiftCardCode() {
        System.out.print("Enter gift card code: ");
        return scnr.nextInt();
    }

    public double promptAmount() {
        System.out.print("Enter amount to pay: ");
        return scnr.nextDouble();
    }

    public void invalidInput() {
        System.out.println("Invalid input. Please try again.");
    }
    public void refundProcessed() {
        System.out.println("Refund processed.");

    }

    public void printReceipt(String s){
        System.out.println(s);
    }

    public void paymentSuccessful(){
        System.out.println("Payment processed successfully.");
        System.out.println("----------------------------------\n");
    }

    public void denyRefund() {
        System.out.println("Payment is not refundable.");
    }
}
