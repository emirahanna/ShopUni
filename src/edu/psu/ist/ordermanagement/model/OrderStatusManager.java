package edu.psu.ist.ordermanagement.model;

import java.time.LocalDate;

public class OrderStatusManager {
    public enum OrderStatus {PENDING, SHIPPED, DELIVERED, CANCELED}
    private String id;
    private OrderStatus orderStatus;
    private String location;
    private LocalDate lastUpdatedTime;

    public OrderStatusManager() {
        this.id = OSMIDGenerator.createID();
        this.orderStatus = OrderStatus.PENDING;
        this.location = "Warehouse";
        this.lastUpdatedTime = LocalDate.now();
    }

    public OrderStatusManager(String id, OrderStatus orderStatus, String location, LocalDate lastUpdatedTime) {
        this.id = id;
        this.orderStatus = orderStatus;
        this.location = location;
        this.lastUpdatedTime = lastUpdatedTime;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public String getLocation() {
        return location;
    }

    public LocalDate getLastUpdatedTime() {
        return lastUpdatedTime;
    }

    public String getID() {
        return id;
    }
}