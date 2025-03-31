package OrderManagement.controller;

import CartManagement.model.Cart;
import OrderManagement.model.Order;
import OrderManagement.model.Shipping;
import OrderManagement.view.OrderConfirmedView;
import OrderManagement.view.OrderDetailView;
import PaymentManagement.controller.PaymentController;
import TrackingManagement.controller.TrackingController;

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
