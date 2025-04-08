package ordermanagement.model;

import java.util.Date;

public class Shipping {
    public enum DeliveryOption {PICKUP, DELIVERY}
    private DeliveryOption deliveryOption;
    private Date orderDate;
    private String address;

    public Shipping(String address, DeliveryOption deliveryOption, Date orderDate) {
        this.address = address;
        this.deliveryOption = deliveryOption;
        this.orderDate = orderDate;
    }

    public Date estimateDeliveryDate() {
        if (deliveryOption == DeliveryOption.DELIVERY) {
            return new Date(orderDate.getTime() + 99999999); // figure out how to add to Date
        }
        //can also estimate delivery based on distance
        return orderDate; // Pickup orders are available immediately
    }

    public String getAddress() {
        return address;
    }

    public DeliveryOption getDeliveryOption() {
        return deliveryOption;
    }

}