package model.ShippingManagement;

public class Shipping {
    private String companyID;
    private String trackingID;
    private String productID;
    private String location;
    private String status;

    /**
     * Connects the company ID to the tracking ID for customer reference
     */
    public void connectData(String companyID, String trackingID) {
        this.companyID = companyID;
        this.trackingID = trackingID;
    }
    
    /**
     * Updates the location of the product as its status changes
     */
    public void updateLocation(String location) {
        this.location = location;
    }
    
    /** 
     * Updates the status of the product as it moves through the shipping process
     */
    public void updateStatus(String status) {
        this.status = status;
    }
}