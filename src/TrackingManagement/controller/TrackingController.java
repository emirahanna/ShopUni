package TrackingManagement.controller;

import OrderManagement.model.Order;
import TrackingManagement.model.Tracking;
import TrackingManagement.view.TrackingView;

import java.util.Calendar;
import java.util.Date;

public class TrackingController {
    Tracking model;
    TrackingView view;

    public TrackingController(Order order) {
        this.model = new Tracking(order.getOrderID(), updateArrivalDate(order), "LOCATION", "PENDING");
        this.view = new TrackingView();
        showTracking();
    }

    private Date updateArrivalDate(Order order){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(order.getOrderDate());

        // Add 5 days
        calendar.add(Calendar.DAY_OF_MONTH, 15);
        return calendar.getTime();
    }
    public void showTracking() {
        String trackingNumber = view.showTracking();
        String status = model.getStatus(trackingNumber);
        if (status != null) {
            view.showTrackingStatus(status);
        } 
        else {
            view.showTrackingError();
        }
    }
}
