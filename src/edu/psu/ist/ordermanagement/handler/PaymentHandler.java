package edu.psu.ist.ordermanagement.handler;

import edu.psu.ist.ordermanagement.model.Order;

public class PaymentHandler extends OrderHandler{
    @Override
    protected boolean process (Order order){
        if (order.getPaymentID() == null){
            System.out.println("No payment info: Processing Failed");
            return false;
        }

        System.out.println("Payment processing success!");
        return true;
    }
}
