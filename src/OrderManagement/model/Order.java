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
    private String address;
    private DeliveryOption deliveryOption;
    private OrderStatus orderStatus;
    private Cart cartContents;

    enum DeliveryOption{PICKUP, DELIVERY}
    public enum OrderStatus{PENDING, SHIPPED, DELIVERED, CANCELED}

    public boolean cancelOrder() {
        if (orderStatus.equals(OrderStatus.PENDING)){
            return true;
        }
        return false; // Can't cancel if already shipped or delivered
    }

    public void markAsShipped() {
        if (orderStatus.equals(OrderStatus.PENDING)) {
            orderStatus = OrderStatus.SHIPPED;
        }
    }

    public void markAsDelivered() {
        if (orderStatus.equals(OrderStatus.SHIPPED)) {
            orderStatus = OrderStatus.DELIVERED;
        }
    }

    public Date estimateDeliveryDate() {
        return new Date(orderDate.getTime() + 99999999); //random number as placeholder
    }


    public String generateOrderSummary() {
        return "";
    }


}
