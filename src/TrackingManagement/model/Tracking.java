package TrackingManagement.model;

public class Tracking {
    private String paymentID;
    private String trackingID;
    private String arrivalDate;
    private String location;


    public Tracking(String paymentID, String trackingID, String arrivalDate, String location) {
        this.paymentID = paymentID;
        this.trackingID = trackingID;
        this.arrivalDate = arrivalDate;
        this.location = location;
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
