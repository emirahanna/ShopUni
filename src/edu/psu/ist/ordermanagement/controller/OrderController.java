package edu.psu.ist.ordermanagement.controller;

import edu.psu.ist.cartmanagement.model.Cart;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.Shipping;
import edu.psu.ist.ordermanagement.view.OrderConfirmedView;
import edu.psu.ist.ordermanagement.view.OrderDetailView;
import edu.psu.ist.paymentmanagement.controller.PaymentController;
import edu.psu.ist.trackingmanagement.controller.TrackingController;

import java.util.Date;

public class OrderController {
    Order orderModel;
    OrderDetailView orderDetailView;
    OrderConfirmedView orderConfirmedView;
    PaymentController paymentController;

    public OrderController(Cart cart) {
        paymentController = new PaymentController();
        this.orderDetailView = new OrderDetailView();
        this.orderConfirmedView = new OrderConfirmedView();
        createOrder(cart);
        processOrder();

    }

    public void createOrder(Cart cart){
        orderDetailView.promptFillInOrder();
        String address = orderDetailView.promptAddress();
        Shipping.DeliveryOption deliveryOption = switch (orderDetailView.promptDelivery()){
            case 1 -> Shipping.DeliveryOption.DELIVERY;
            case 2 -> Shipping.DeliveryOption.PICKUP;
            default -> null;
            };

        this.orderModel = new Order("RANDOM ID", paymentController.getPaymentModel(), cart.getTotalPrice(), new Date(), cart.getCartContents(), address, deliveryOption);

        orderConfirmedView.orderSuccessCreated();
        orderConfirmedView.printOrderDetails(orderModel.generateOrderSummary());
    }

    public void processOrder(){
        switch (orderConfirmedView.displayOptions()){
            case 1 -> new TrackingController(orderModel);
            case 2 -> {
                return;
            }
        }
    }



}
