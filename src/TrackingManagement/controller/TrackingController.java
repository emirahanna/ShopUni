package TrackingManagement.controller;

import TrackingManagement.model.Tracking;
import TrackingManagement.view.TrackingView;

public class TrackingController {
    Tracking model;
    TrackingView view;

    public TrackingController(Tracking model, TrackingView view) {
        this.model = model;
        this.view = view;
    }
    public void ShowTracking() {
        String trackingNumber = view.ShowTracking();
        String status = model.getStatus(trackingNumber);
        if (status != null) {
            view.ShowTrackingStatus(status);
        } 
        else {
            view.ShowTrackingError();
        }
    }
}
