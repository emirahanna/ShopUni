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
}
