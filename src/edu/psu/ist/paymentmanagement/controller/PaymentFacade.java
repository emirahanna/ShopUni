package edu.psu.ist.paymentmanagement.controller;

import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.OrderService;
import edu.psu.ist.ordermanagement.model.Shipping;
import edu.psu.ist.paymentmanagement.model.Payment;

public class PaymentFacade {
    private PaymentService paymentService;
    private OrderService orderService;

    public PaymentFacade() {
        this.paymentService = new PaymentService();
        this.orderService = new OrderService();
    }

    public Payment processPayment(Payment.PaymentOption option, double amount) {
        return paymentService.createPayment(option, amount);
    }

    public Order placeOrder(Payment payment, String name, String address, CartSnapshot cart, Shipping.DeliveryOption option) {
        return orderService.createOrder(name, address, cart, payment.getPaymentID(), option);
    }

    public boolean isValidExpirationDate(int expDate) {
        return paymentService.validateExpirationDate(expDate);
    }
}