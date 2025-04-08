package trackingmanagement.model;

import java.util.Date;

public class Tracking {
    private String orderID;
    private Date arrivalDate;
    private String location;
    private String status;


    public Tracking(String orderID, Date arrivalDate, String location, String status) {
        this.orderID = orderID;
        this.arrivalDate = arrivalDate;
        this.location = location;
        this.status = status;
    }

    /**
     * Estimates the remaining time for delivery based on the arrival date.
     */
    public String estimateDeliveryTime() {
        if (arrivalDate == null || arrivalDate == null) {
            return "Arrival date not available.";
        }
        return "Estimated delivery in X days (based on " + arrivalDate + ")";
    }

    /**
     * Validates if the tracking information is correctly formatted.
     */
    public boolean validateTracking() {
        return orderID != null && location != null && !location.isEmpty();
    }


    /**
     * Updates the location of the product as its status changes
     */
    public void updateLocation(String location) {
        this.location = location;
    }

    /**
     * Updates the arrival date of the product as it reaches the customer
     */
    public void updateDate(Date arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public Date getArrivalDate() {
        return arrivalDate;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus(String orderID) {
        return status;
    }
}
