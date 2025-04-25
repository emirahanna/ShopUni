package edu.psu.ist.ordermanagement.controller;

import java.time.LocalDate;
import java.util.Date;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.ordermanagement.handler.PaymentHandler;
import edu.psu.ist.ordermanagement.handler.ShippingHandler;
import edu.psu.ist.ordermanagement.handler.ValidationHandler;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.Shipping;
import edu.psu.ist.ordermanagement.view.OrderConfirmedView;
import edu.psu.ist.ordermanagement.view.OrderDetailView;
import edu.psu.ist.paymentmanagement.controller.PaymentController;
import edu.psu.ist.trackingmanagement.controller.TrackingController;

public class OrderController {
    Order orderModel;
    OrderDetailView orderDetailView;
    OrderConfirmedView orderConfirmedView;
    PaymentController paymentController;

    public OrderController(CartManager cart) {
        paymentController = new PaymentController();
        this.orderDetailView = new OrderDetailView();
        this.orderConfirmedView = new OrderConfirmedView();

        createOrder(cart);
        processOrder();

    }

    public void createOrder(CartManager cart){
        String address = orderDetailView.promptAddress();
        Shipping.DeliveryOption deliveryOption = switch (orderDetailView.promptDelivery()){
            case 1 -> Shipping.DeliveryOption.DELIVERY;
            case 2 -> Shipping.DeliveryOption.PICKUP;
            default -> null;
            };

        this.orderModel = new Order(paymentController.getPaymentModel().getPaymentID(), LocalDate.now(), cart , address, deliveryOption);

        //establish chain of responsibility and handlers
        ValidationHandler validationHandler = new ValidationHandler();
        PaymentHandler paymentHandler = new PaymentHandler();
        ShippingHandler shippingHandler = new ShippingHandler();

        //connect handlers
        validationHandler.setNextHandler(paymentHandler);
        paymentHandler.setNextHandler(shippingHandler);

        //process order through chain of responsibility
        validationHandler.handleOrder(orderModel);

        orderConfirmedView.orderSuccessCreated();
        orderConfirmedView.printOrderDetails(orderModel.generateOrderSummary());
    }

    public void processOrder(){
        switch (orderConfirmedView.displayOptions()){
            case 1 -> new TrackingController(orderModel);
            case 2 -> {
                orderConfirmedView.printOrderDetails(orderModel.generateOrderSummary());
                orderConfirmedView.orderSuccessCreated();
            }
        }
    }
}
