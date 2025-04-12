package edu.psu.ist.ordermanagement.handler;

import edu.psu.ist.ordermanagement.model.Order;

public abstract class OrderHandler {

    private OrderHandler nextHandler;

    public void setNextHandler(OrderHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public void handleOrder(Order order){
        if(process(order)){
            if(nextHandler != null){
                nextHandler.handleOrder(order);
            }
        }else{
            System.out.println("Order processing stopped at: " + this.getClass().getName());
        }
    }

    protected abstract boolean process(Order order);
}
