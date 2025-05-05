package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.productmanagement.model.Product;

import java.time.LocalDate;
import java.util.Date;

public class Order {
    private String orderID;
    private String paymentID;
    private double orderTotal;
    private LocalDate orderDate;
    private CartSnapshot cartSnapshot;
    private OrderStatusManager orderStatusManager;
    private Shipping shippingDetails;

    public Order(String paymentID, LocalDate orderDate, CartSnapshot cartSnapshot, String address, Shipping.DeliveryOption deliveryOption) {
        this.orderID = OrderIDGenerator.createID();
        this.paymentID = paymentID;
        this.cartSnapshot = cartSnapshot;
        this.orderTotal = cartSnapshot.getTotal();
        this.orderDate = orderDate;
        this.orderStatusManager = new OrderStatusManager();
        this.shippingDetails = new Shipping(ShippingIDGenerator.createID(), orderID, address, deliveryOption, orderDate);
    }

    public Order(String id, String paymentID, LocalDate orderDate, CartSnapshot cartSnapshot, Shipping shipping, OrderStatusManager orderStatusManager) {
        this.orderID = id;
        this.paymentID = paymentID;
        this.cartSnapshot = cartSnapshot;
        this.orderTotal = cartSnapshot.getTotal();
        this.orderDate = orderDate;
        this.orderStatusManager = orderStatusManager;
        this.shippingDetails = shipping;
    }


    public String generateOrderSummary() {
        StringBuilder sb = new StringBuilder();
        sb.append("Order ID: ").append(orderID).append("\n");
        sb.append("Order Total: $").append(orderTotal).append("\n");
        sb.append("Status: ").append(orderStatusManager.getOrderStatus()).append("\n");
        sb.append("Delivery: ").append(shippingDetails.getDeliveryOption()).append(" to ").append(shippingDetails.getAddress()).append("\n");
        sb.append("Estimated Delivery: ").append(shippingDetails.estimateDeliveryDate()).append("\n").append("\n");
        sb.append("Order Summary:").append("\n");
        sb.append(getOrderItems());
        sb.append("\n").append("\n").append("-------------------------------------------------------------------------------").append("\n");

        return sb.toString();
    }

    public String getOrderItems() {
        StringBuilder sb = new StringBuilder();
        for (Product p : cartSnapshot.getItems().keySet()) {
            sb.append(String.format("%-40s     x%-2d\n", p, cartSnapshot.getItems().get(p)));
        }
        return sb.toString();
    }


    public String getOrderID() {
        return orderID;
    }

    public String getPaymentID() {
        return paymentID;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public OrderStatusManager getOrderStatusManager() {
        return orderStatusManager;
    }

    public Shipping getShippingDetails() {
        return shippingDetails;
    }

    public CartSnapshot getCartSnapshot() {
        return cartSnapshot;
    }
}

