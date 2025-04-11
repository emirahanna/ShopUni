package edu.psu.ist.productmanagement.view;

import edu.psu.ist.productmanagement.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductListingView extends JFrame{
    private JPanel basePanel;
    private JPanel appLogo;
    private JLabel appName;
    private JButton p1AddToCartButton;
    private JLabel p1ProductImage;
    private JLabel p1ProductTitle;
    private JLabel p1ProductDescription;
    private JButton nextButton;
    private JButton previousButton;
    private JButton p2AddToCartButton;
    private JButton p3AddToCartButton;
    private JButton p4AddToCartButton;
    private JButton p5AddToCartButton;
    private JLabel p2ProductImage;
    private JLabel p3ProductImage;
    private JLabel p4ProductImage;
    private JLabel p5ProductImage;
    private JLabel p2ProductTitle;
    private JLabel p3ProductTitle;
    private JLabel p4ProductTitle;
    private JLabel p5ProductTitle;
    private JLabel p2ProductDescription;
    private JLabel p3ProductDescription;
    private JLabel p4ProductDescription;
    private JLabel p5ProductDescription;
    private JPanel p1Card;
    private JPanel p4Card;
    private JPanel p2Card;
    private JPanel p3Card;
    private JPanel p5Card;

    private Scanner scnr;

    public ProductListingView() {
        this.scnr = new Scanner(System.in);
        setView();

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
    private void setView() {
        //names the text at the top of the window
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        //sets the window to open with this resolution
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
