package TrackingManagement.model;

public class Tracking {
    private String orderID;
    private String arrivalDate;
    private String location;


    public Tracking(String orderID, String arrivalDate, String location) {
        this.orderID = orderID;
        this.arrivalDate = arrivalDate;
        this.location = location;
    }

    /**
     * Estimates the remaining time for delivery based on the arrival date.
     */
    public String estimateDeliveryTime() {
        if (arrivalDate == null || arrivalDate.isEmpty()) {
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
    public void updateDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
