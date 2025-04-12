package edu.psu.ist.ordermanagement.handler;

import edu.psu.ist.ordermanagement.model.Order;

public class ValidationHandler extends OrderHandler {
    @Override
    protected boolean process(Order order){
        if (order == null || order.getOrderTotal() <= 0){
            System.out.println("Order validation failed");
            return false;
        }

        System.out.println("Order validation success!");
        return true;
    }
}
