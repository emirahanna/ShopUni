package edu.psu.ist.trackingmanagement.controller;

import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.trackingmanagement.model.Tracking;
import edu.psu.ist.trackingmanagement.view.TrackingView;

import java.time.LocalDate;
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

    private LocalDate updateArrivalDate(Order order) {
        return order.getOrderDate().plusDays(15);
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
