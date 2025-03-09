package CartManagement.view;

import ProductManagement.model.Product;


import java.util.Map;
import java.util.Scanner;

/**
 * The GUI that depicts the contents of the cart
 */
public class CartContentsView {
    private Scanner scnr;


    public CartContentsView(Map<Product, Integer> cart, double totalPrice) {
        displayCart(cart, totalPrice);
        displayOptions();
        this.scnr = new Scanner(System.in);
    }

    public void displayCart(Map<Product, Integer> cart, double totalPrice) {
        System.out.printf("%-15s %5s %5s", "Item", "QTY", "AMT");
        for (Product p : cart.keySet()) {
            System.out.printf("%-15s %5d %5f", p, cart.get(p), p.getPrice());
        }
        System.out.printf("%25f", totalPrice);
    }

    public int displayOptions() {
        System.out.println("""
                What would you like to do with you cart today?
                
                1. Remove Product
                2. Empty Cart
                3. Buy Cart
                4. Exit Cart
                """);
        System.out.print("Enter your choice: ");
        int readNum = scnr.nextInt();
        while(readNum < 1 || readNum > 5){
            System.out.print("Invalid Input. Enter a number between 1 - 4");
            readNum = scnr.nextInt();
        }
        return readNum;
    }
}
