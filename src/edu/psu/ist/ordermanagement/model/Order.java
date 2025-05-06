package edu.psu.ist.ordermanagement.model;

import edu.psu.ist.cartmanagement.model.CartSnapshot;
import edu.psu.ist.cartmanagement.util.User;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.usermanagement.model.UserSession;

import java.time.LocalDate;

public class Order {
    private String orderID;
    private String paymentID;
    private String userID;
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
        this.userID = UserSession.getInstance().getUserID();
    }

    public Order(String id, String paymentID, LocalDate orderDate, CartSnapshot cartSnapshot, Shipping shipping, OrderStatusManager orderStatusManager) {
        this.orderID = id;
        this.paymentID = paymentID;
        this.cartSnapshot = cartSnapshot;
        this.orderTotal = cartSnapshot.getTotal();
        this.orderDate = orderDate;
        this.orderStatusManager = orderStatusManager;
        this.shippingDetails = shipping;
        this.userID = UserSession.getInstance().getUserID();
    }


    public String generateOrderSummary() {
        StringBuilder sb = new StringBuilder();

        sb.append("========================================\n");
        sb.append("                ORDER RECEIPT\n");
        sb.append("========================================\n\n");

        sb.append(String.format("Order ID:          %s\n", orderID));
        sb.append(String.format("Order Total:       $%.2f\n", orderTotal));
        sb.append(String.format("Status:            %s\n", orderStatusManager.getOrderStatus()));
        sb.append(String.format("Delivery Option:   %s\n", shippingDetails.getDeliveryOption()));
        sb.append(String.format("Shipping Address:  %s\n", shippingDetails.getAddress()));
        sb.append(String.format("Est. Delivery:     %s\n", shippingDetails.estimateDeliveryDate()));

        sb.append("\n----------------------------------------\n");
        sb.append("                ORDER ITEMS\n");
        sb.append("----------------------------------------\n");

        sb.append(getOrderItems());

        sb.append("\n========================================\n");
        sb.append("     Thank you for shopping with us!\n");
        sb.append("========================================\n");

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

