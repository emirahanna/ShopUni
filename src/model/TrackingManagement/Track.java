package model.TrackingManagement;

public class Track {
    private String paymentID;
    private String trackingID;
    private String productID;
    private String arrivalDate;


    /**
     * Connects payment ID to the tracking ID for customer reference
     */
    public void connectData(String paymentID, String trackingID) {
        this.paymentID = paymentID;
        this.trackingID = trackingID;
    }
    
    /**
     * Updates the arrival date of the product as it reaches the customer
     */
    public void updateDate(String arrivalDate) {
        this.arrivalDate = arrivalDate;
    }
}
