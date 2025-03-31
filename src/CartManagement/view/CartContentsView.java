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
        this.scnr = new Scanner(System.in);
    }

    public void displayCart(Map<Product, Integer> cart, double totalPrice) {
        System.out.printf("%-30s %5s %5s\n", "Item", "QTY", "AMT");
        for (Product p : cart.keySet()) {
            System.out.printf("%-30s %5d %5.2f\n", p.getTitle(), cart.get(p), p.getPrice());
        }
        System.out.printf("%42.2f\n", totalPrice);
        System.out.println();
        System.out.println();
    }

    public int displayOptions() {
        System.out.println("""
                What would you like to do with you cart today?
                
                1. Remove Product
                2. Empty Cart
                3. Buy Cart
                4. Exit Cart (Back to Catalog)
                """);
        System.out.print("Enter your choice: ");
        int readNum = scnr.nextInt();
        while(readNum < 1 || readNum > 5){
            System.out.print("Invalid Input. Enter a number between 1 - 4");
            readNum = scnr.nextInt();
        }
        return readNum;
    }

    public void cartEmptied(){
        System.out.println("Cart emptied.");
    }

    public void exitingCart(){
        System.out.println("Exiting cart...");
    }
    public void invalidChoice(){
        System.out.println("Invalid choice. Please try again.");
    }
    public void removeProductPrompt(){
        System.out.print("Enter product name to remove: ");

    }
    public void productNotFound(){
        System.out.println("Product not found in cart.");
    }

    public void productWasRemoved(String s){
        System.out.println(s + " removed from cart.");
    }

    public void proceedingToCheckout(){
        System.out.println("Proceeding to checkout... ");
    }

    public void cartEmptyReminder(){
        System.out.println("Cart is empty! Add products before purchasing.");
    }
}
