package edu.psu.ist.trackingmanagement.model;

import java.time.LocalDate;
import java.util.Date;

public class Tracking {
    final String orderID;
    private LocalDate arrivalDate;
    private String location;
    final String status;


    public Tracking(String orderID, LocalDate arrivalDate, String location, String status) {
        this.orderID = orderID;
        this.arrivalDate = arrivalDate;
        this.location = location;
        this.status = status;
    }

    public String estimateDeliveryTime() {
        if (arrivalDate == null || arrivalDate == null) {
            return "Arrival date not available.";
        }
        return "Estimated delivery in X days (based on " + arrivalDate + ")";
    }

    public boolean validateTracking() {
        return orderID != null && location != null && !location.isEmpty();
    }

    public void updateLocation(String location) {
        this.location = location;
    }

    public void updateDate(LocalDate arrivalDate) {
        this.arrivalDate = arrivalDate;
    }

    public String getOrderID() {
        return orderID;
    }

    public LocalDate getArrivalDate() {
        return arrivalDate;
    }

    public String getLocation() {
        return location;
    }

    public String getStatus(String orderID) {
        return status;
    }
}
