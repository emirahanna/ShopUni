package ProductManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class ProductPageView{

    private Scanner scnr;
    public ProductPageView()  {
        this.scnr = new Scanner(System.in);
    }

    public void displayOptions(){
        System.out.println("PRINTED PRODUCT INFO");
        System.out.println("\nOptions:");
        System.out.println("A - Add To Cart");
        System.out.println("X - Back To Catalog");
    }

    public String getUserChoice() {
        System.out.println("Enter selected choice: ");
        return scnr.next();
    }

    public void succAddToCart(){
        System.out.println("Successfully added to cart!");
    }
    public void invalidInput(){
        System.out.println("Invalid input. Please try again.");
    }

}
