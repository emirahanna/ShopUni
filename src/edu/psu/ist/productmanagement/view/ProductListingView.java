package edu.psu.ist.productmanagement.view;

import edu.psu.ist.productmanagement.model.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class ProductListingView extends JFrame {
    private JPanel basePanel;
    private JButton p1ViewProductButton;
    private JLabel p1ProductImage;
    private JLabel p1ProductTitle;
    private JLabel p1ProductDescription;
    private JButton nextButton;
    private JButton previousButton;
    private JButton p2ViewProductButton;
    private JButton p3ViewProductButton;
    private JButton p4ViewProductButton;
    private JButton p5ViewProductButton;
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
    private JLabel appLogoName;
    private JLabel productCatalogBreadCrumb;
    private JLabel pageIndicator;
    private JButton featuredProductsButton;

    private Scanner scnr;

    public ProductListingView() {
        setView();
        this.scnr = new Scanner(System.in);
    }

    public String getSelectedProduct() {
        System.out.println("Enter number (1-3): ");
        return scnr.next();
    }

    public void invalidSelection() {
        System.out.println("Invalid selection.");
    }

    public void invalidInput() {
        System.out.println("Invalid input. Please try again.");
    }

    public void displaySelection(String s) {
        System.out.println("You selected: " + s);
    }

    public void exitCatalog() {
        System.out.println("Exiting product catalog...");
    }

    public void lastPageWarning() {
        System.out.println("You are already on the last page.");
    }

    public void firstPageWarning() {
        System.out.println("You are already on the first page.");
    }

    private void setView() {
        //names the text at the top of the window
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        //sets the window to open with this resolution
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void initializeProducts(ArrayList<Product> products, int currentPage, int totalPages) {
        JLabel[] titles = {p1ProductTitle, p2ProductTitle, p3ProductTitle, p4ProductTitle, p5ProductTitle};
        JLabel[] descriptions = {p1ProductDescription, p2ProductDescription, p3ProductDescription, p4ProductDescription, p5ProductDescription};
        JPanel[] cards = {p1Card, p2Card, p3Card, p4Card, p5Card};

        String title = "";
        String desc = "";

        // Get and display individual product card's data
        for (int i = 0; i < 5; i++) {
            if (i < products.size()) {
                Product p = products.get(i);
                title = p.getTitle();
                desc = p.getDescription();
                titles[i].setText("<html>" + title + "</html>"); //attempt to make the text wrap
                descriptions[i].setText("<html>" + desc + "</html>");
                cards[i].setVisible(true);
            } else {
                titles[i].setText("");
                descriptions[i].setText("");
                cards[i].setVisible(false);
            }
        }

        previousButton.setEnabled(currentPage > 1);
        nextButton.setEnabled(currentPage < totalPages);
    }

    //moved this just in case we need later - i thought this was mostly for stuff when we are fully in the scanner

//    public void displayProducts(ArrayList<Product> products, int currentPage, int totalPages) {
//        System.out.println();
//        System.out.println("=== Product Catalog F ===");
//
//        if (products.isEmpty()) {
//            System.out.println("No products available.");
//            return;
//        }
//
//        for (int i = 0; i < products.size(); i++) {
//            System.out.println((i + 1) + ". " + products.get(i).getTitle());
//        }
//
//        System.out.println("Options:");
//        if (currentPage > 1) {
//            System.out.println("P - Previous Page");
//        }
//        if (currentPage < totalPages) {
//            System.out.println("N - Next Page");
//        }
//        System.out.println("S - Select a Product");
//        System.out.println("X - Exit");
//    }
//
//    public String getUserChoice() {
//        System.out.println("Enter selected choice: ");
//        return scnr.next();
//    }

    //end of moved code

    public JPanel getBasePanel() {
        return basePanel;
    }


    public JLabel getAppLogoName() {
        return appLogoName;
    }

    public JButton getP1ViewProductButton() {
        return p1ViewProductButton;
    }

    public JLabel getP1ProductImage() {
        return p1ProductImage;
    }

    public JLabel getP1ProductTitle() {
        return p1ProductTitle;
    }

    public JLabel getP1ProductDescription() {
        return p1ProductDescription;
    }

    public JButton getNextButton() {
        return nextButton;
    }

    public JButton getPreviousButton() {
        return previousButton;
    }

    public JButton getP2ViewProductButton() {
        return p2ViewProductButton;
    }

    public JLabel getP2ProductImage() {
        return p2ProductImage;
    }

    public JLabel getP2ProductTitle() {
        return p2ProductTitle;
    }

    public JLabel getP2ProductDescription() {
        return p2ProductDescription;
    }

    public JButton getP3ViewProductButton() {
        return p3ViewProductButton;
    }

    public JLabel getP3ProductImage() {
        return p3ProductImage;
    }

    public JLabel getP3ProductTitle() {
        return p3ProductTitle;
    }

    public JLabel getP3ProductDescription() {
        return p3ProductDescription;
    }

    public JButton getP4ViewProductButton() {
        return p4ViewProductButton;
    }

    public JLabel getP4ProductImage() {
        return p4ProductImage;
    }

    public JLabel getP4ProductTitle() {
        return p4ProductTitle;
    }

    public JLabel getP4ProductDescription() {
        return p4ProductDescription;
    }

    public JButton getP5ViewProductButton() {
        return p5ViewProductButton;
    }

    public JLabel getP5ProductImage() {
        return p5ProductImage;
    }

    public JLabel getP5ProductTitle() {
        return p5ProductTitle;
    }

    public JLabel getP5ProductDescription() {
        return p5ProductDescription;
    }

    public JPanel getP1Card() {
        return p1Card;
    }

    public JPanel getP2Card() {
        return p2Card;
    }

    public JPanel getP3Card() {
        return p3Card;
    }

    public JPanel getP4Card() {
        return p4Card;
    }

    public JPanel getP5Card() {
        return p5Card;
    }

    public JLabel getProductCatalogBreadCrumb() {
        return productCatalogBreadCrumb;
    }

    public JLabel getPageIndicator() {
        return pageIndicator;
    }
    public JButton getFeaturedProductsButton(){return featuredProductsButton;}
}
