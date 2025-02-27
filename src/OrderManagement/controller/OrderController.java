package OrderManagement.controller;

import OrderManagement.model.Order;
import OrderManagement.model.Shipping;
import OrderManagement.view.OrderConfirmedView;
import OrderManagement.view.OrderDetailView;

public class OrderController {
    Order orderModel;
    OrderDetailView orderDetailView;
    OrderConfirmedView orderConfirmedView;

    public OrderController(Order orderModel, OrderDetailView orderDetailView, OrderConfirmedView orderConfirmedView) {
        this.orderModel = orderModel;
        this.orderDetailView = orderDetailView;
        this.orderConfirmedView = orderConfirmedView;
    }
}
