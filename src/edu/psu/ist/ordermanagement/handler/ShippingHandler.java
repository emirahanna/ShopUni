package edu.psu.ist.ordermanagement.handler;

import edu.psu.ist.ordermanagement.model.Order;

public class ShippingHandler extends OrderHandler{
    @Override
    protected boolean process (Order order){

        //process shipping based on choice of delivery method

        if(order.getShippingDetails().getDeliveryOption() == null){
            System.out.println("No delivery option specified");
            return false;
        }
        return true;
    }
}
