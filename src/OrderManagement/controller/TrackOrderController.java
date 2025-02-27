package OrderManagement.controller;

import OrderManagement.model.Order;
import OrderManagement.view.TrackOrderView;

/**
 * This class represents the controller for tracking the customer's product order.
 */
public class TrackOrderController {
    Order orderModel;
    TrackOrderView trackOrderView;

    public TrackOrderController(Order orderModel, TrackOrderView trackOrderView) {
        this.orderModel = orderModel;
        this.trackOrderView = trackOrderView;
    }
}


