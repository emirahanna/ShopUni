package edu.psu.ist.ordermanagement.model;

public class OrderStatusManager {
    public enum OrderStatus {PENDING, SHIPPED, DELIVERED, CANCELED}
    private OrderStatus orderStatus;

    public OrderStatusManager() {
        this.orderStatus = OrderStatus.PENDING;
    }

    //can't cancel if the order has already been shipped
    public boolean cancelOrder() {
        if (orderStatus == OrderStatus.PENDING) {
            orderStatus = OrderStatus.CANCELED;
            return true;
        }
        return false;
    }

    public void markAsShipped() {
        if (orderStatus == OrderStatus.PENDING) {
            orderStatus = OrderStatus.SHIPPED;
        }
    }

    public void markAsDelivered() {
        if (orderStatus == OrderStatus.SHIPPED) {
            orderStatus = OrderStatus.DELIVERED;
        }
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
}