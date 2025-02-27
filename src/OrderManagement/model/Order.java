package OrderManagement.model;

import CartManagement.model.Cart;
import PaymentManagement.model.Payment;

import java.util.Date;

public class Order {
    private String customerID;
    private String orderID;
    private Payment payment;
    private double orderTotal;
    private Date orderDate;
    private Cart cartContents;
    private OrderStatusManager orderStatusManager;
    private Shipping shippingDetails;

    public Order(String customerID, String orderID, Payment payment, double orderTotal, Date orderDate,
                 Cart cartContents, String address, Shipping.DeliveryOption deliveryOption) {
        this.customerID = customerID;
        this.orderID = orderID;
        this.payment = payment;
        this.orderTotal = orderTotal;
        this.orderDate = orderDate;
        this.cartContents = cartContents;
        this.orderStatusManager = new OrderStatusManager();
        this.shippingDetails = new Shipping(address, deliveryOption, orderDate);
    }

    public String generateOrderSummary() {
        return "Order ID: " + orderID + "\n" +
                "Customer ID: " + customerID + "\n" +
                "Order Total: $" + orderTotal + "\n" +
                "Status: " + orderStatusManager.getOrderStatus() + "\n" +
                "Delivery: " + shippingDetails.getDeliveryOption() + " to " + shippingDetails.getAddress() + "\n" +
                "Estimated Delivery: " + shippingDetails.estimateDeliveryDate();
    }

    public String getCustomerID() {
        return customerID;
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

    public Cart getCartContents() {
        return cartContents;
    }
}

