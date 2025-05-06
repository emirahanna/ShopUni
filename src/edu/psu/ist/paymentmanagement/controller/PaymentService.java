package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.paymentmanagement.model.Payment;
import edu.psu.ist.paymentmanagement.model.PaymentDAO;
import edu.psu.ist.paymentmanagement.model.PaymentIDGenerator;

import java.time.LocalDate;

public class PaymentService {
    public Payment createPayment(Payment.PaymentOption option, double amount) {
        Payment payment = new Payment(PaymentIDGenerator.createID(), option, amount, LocalDate.now());
        PaymentDAO.insertPayment(payment);
        return payment;
    }

    public boolean validateExpirationDate(int expDate) {
        int expMonth = expDate / 100;
        int expYear = expDate % 100;

        LocalDate now = LocalDate.now();
        int currentMonth = now.getMonthValue();
        int currentYear = now.getYear() % 100;

        return (expYear > currentYear || (expYear == currentYear && expMonth >= currentMonth)) && expMonth <=12 ;
    }
}
