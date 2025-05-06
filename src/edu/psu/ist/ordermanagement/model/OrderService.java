package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.cartmanagement.model.CartSnapshot;

import java.time.LocalDate;

public class OrderService {
    public Order createOrder(String name, String address, CartSnapshot cart, String paymentId, Shipping.DeliveryOption option) {
        Order order = new Order(paymentId, LocalDate.now(), cart, address, option);
        OrderDAO.insertOrder(order);
        return order;
    }
}