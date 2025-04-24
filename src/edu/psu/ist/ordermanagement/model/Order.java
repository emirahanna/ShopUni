package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.paymentmanagement.model.Payment;

import java.util.Date;

public class Order {
    private String orderID;
    private Payment payment;
    private double orderTotal;
    private Date orderDate;
    private OrderStatusManager orderStatusManager;
    private Shipping shippingDetails;

    public Order(String orderID, Payment payment, double orderTotal, Date orderDate, String address, Shipping.DeliveryOption deliveryOption) {
        this.orderID = orderID;
        this.payment = payment;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.orderStatusManager = new OrderStatusManager();
        this.shippingDetails = new Shipping(address, deliveryOption, orderDate);
    }

    public String generateOrderSummary() {
        return "Order ID: " + orderID + "\n" +
                "Order Total: $" + orderTotal + "\n" +
                "Status: " + orderStatusManager.getOrderStatus() + "\n" +
                "Delivery: " + shippingDetails.getDeliveryOption() + " to " + shippingDetails.getAddress() + "\n" +
                "Estimated Delivery: " + shippingDetails.estimateDeliveryDate();
    }


    public String getOrderID() {
        return orderID;
    }

    public Payment getPayment() {
        return payment;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public Date getOrderDate() {
        return orderDate;
    }


    public OrderStatusManager getOrderStatusManager() { return orderStatusManager;}

    public Shipping getShippingDetails() { return shippingDetails; }
}

