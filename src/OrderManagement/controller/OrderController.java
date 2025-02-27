package OrderManagement.controller;

import OrderManagement.model.Order;
import OrderManagement.view.OrderConfirmedView;
import OrderManagement.view.OrderDetailView;

public class OrderController {
    Order orderModel = new Order();
    OrderDetailView orderDetailView = new OrderDetailView();
    OrderConfirmedView orderConfirmedView = new OrderConfirmedView();
}
