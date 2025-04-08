package ordermanagement.view;

import java.util.Scanner;

public class OrderDetailView  {
    private Scanner scnr;
    public OrderDetailView() {
        scnr = new Scanner(System.in);
    }
    public void promptFillInOrder(){
        System.out.println("Please fill in the order details below:");
    }
    public String promptAddress(){
        System.out.print("Address: ");
        return scnr.next();
    }

    public int promptDelivery(){
        System.out.print("""
                Delivery Options:
                1. Delivery
                2. Pickup
                """);
        return scnr.nextInt();
    }
}
