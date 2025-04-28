package edu.psu.ist.ordermanagement.model;

import java.time.LocalDate;

public class Shipping {
    public enum DeliveryOption {PICKUP, DELIVERY}
    private DeliveryOption deliveryOption;
    private LocalDate orderDate;
    private String address;
    private String ID;
    private String orderID;

    public Shipping(String ID, String orderID, String address, DeliveryOption deliveryOption, LocalDate orderDate) {
        this.ID = ID;
        this.orderID = orderID;
        this.address = address;
        this.deliveryOption = deliveryOption;
        this.orderDate = orderDate;
    }

    public LocalDate estimateDeliveryDate() {
        if (deliveryOption == DeliveryOption.DELIVERY) {
                return orderDate.plusDays(15);
        }
        //can also estimate delivery based on distance
        return orderDate; // Pickup orders are available immediately
    }

    public String getID() {
        return ID;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public String getAddress() {
        return address;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

}