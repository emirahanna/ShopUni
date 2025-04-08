package productmanagement.view;

/**
 * The view of the product when in the catalog (listing form)
 */

import productmanagement.model.Product;

import java.util.ArrayList;
import java.util.Scanner;

public class ProductListingView {
    private Scanner scnr;

    public ProductListingView() {
        this.scnr = new Scanner(System.in);

    }

    public void displayProducts(ArrayList<Product> products, int currentPage, int totalPages) {
        System.out.println();
        System.out.println("=== Product Catalog (Page " + currentPage + " of " + totalPages + ") ===");

        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (int i = 0; i < products.size(); i++) {
            System.out.println((i + 1) + ". " + products.get(i).getTitle());
        }

        System.out.println("Options:");
        if (currentPage > 1) {
            System.out.println("P - Previous Page");
        }
        if (currentPage < totalPages) {
            System.out.println("N - Next Page");
        }
        System.out.println("S - Select a Product");
        System.out.println("X - Exit");
    }

    public String getUserChoice() {
        System.out.println("Enter selected choice: ");
        return scnr.next();
    }
    public String getSelectedProduct(){
        System.out.println("Enter number (1-3): ");
        return scnr.next();
    }

    public void invalidSelection(){
        System.out.println("Invalid selection.");
    }

    public void invalidInput(){
        System.out.println("Invalid input. Please try again.");
    }

    public void displaySelection(String s){
        System.out.println("You selected: " + s);
    }

    public void exitCatalog(){
        System.out.println("Exiting product catalog...");
    }

    public void lastPageWarning(){
        System.out.println("You are already on the last page.");
    }

    public void firstPageWarning(){
        System.out.println("You are already on the first page.");
    }
}

