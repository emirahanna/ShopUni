package OrderManagement.model;
import CartManagement.model.Cart;
import PaymentManagement.model.Payment;

import java.util.Date;

enum DeliveryOption {PICKUP, DELIVERY}
enum DeliveryStatus {PENDING, SHIPPED, DELIVERED}

public class Order {
    private Payment payment;
    private double orderTotal;

    private String orderID;

    private String userID;
    private Cart cart;
    private String address;
    private DeliveryStatus status;
    private DeliveryOption deliveryOption;
    private Date orderDate;
    public void updateStatus(DeliveryStatus newStatus) { this.status = newStatus; }

    public String getOrderID() {
        return orderID;
    }
    public Cart getItems(){return this.cart;}
    public double getOrderTotal(){return orderTotal;}

}
