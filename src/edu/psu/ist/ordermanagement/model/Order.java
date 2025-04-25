package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.paymentmanagement.model.Payment;

import java.util.Date;
import java.util.Map;

public class Order {
    private String orderID;
    private String paymentID;
    private double orderTotal;
    private Date orderDate;
    private CartSnapshot cartSnapshot;
    private OrderStatusManager orderStatusManager;
    private Shipping shippingDetails;

    public Order(String paymentID, Date orderDate, CartSnapshot cartSnapshot, String address, Shipping.DeliveryOption deliveryOption) {
        this.orderID = OrderIDGenerator.createID();
        this.paymentID = paymentID;
        this.cartSnapshot = cartSnapshot;
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

    public String getPaymentID() {
        return paymentID;
    }

    public double getOrderTotal() {
        return cartSnapshot.getTotal();
    }
    public Map getCartContents() {
        return cartSnapshot.getItems();
    }

    public Date getOrderDate() {
        return orderDate;
    }


    public OrderStatusManager getOrderStatusManager() { return orderStatusManager;}

    public Shipping getShippingDetails() { return shippingDetails; }
}

