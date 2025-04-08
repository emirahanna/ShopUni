package ordermanagement.view;


import java.util.Scanner;

public class OrderConfirmedView {
    private Scanner scnr;
    public OrderConfirmedView() {
        scnr = new Scanner(System.in);
    }

    public void orderSuccessCreated(){
        System.out.println("Order Successfully Created!");
    }
    public void printOrderDetails(String s){
        System.out.println();
        System.out.println(s);
        System.out.println("-----------------------------------------");
        System.out.println();
    }

    public int displayOptions() {
        System.out.println("""
                What would you like to do with your order today?
                1. Track Order
                2. Exit
                """);
        System.out.print("Enter your choice: ");
        int readNum = scnr.nextInt();
        while(readNum < 1 || readNum > 5){
            System.out.print("Invalid Input. Enter a number between 1 - 2");
            readNum = scnr.nextInt();
        }
        return readNum;
    }
}
