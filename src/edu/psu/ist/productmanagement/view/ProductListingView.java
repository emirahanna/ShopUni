package edu.psu.ist.productmanagement.view;

import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.psu.ist.productmanagement.model.Product;

public class ProductListingView extends JFrame {
    private JPanel basePanel;
    private JButton p1ViewProductButton;
    private JLabel p1ProductTitle;
    private JLabel p1ProductDescription;
    private JButton nextButton;
    private JButton previousButton;
    private JButton p2ViewProductButton;
    private JButton p3ViewProductButton;
    private JButton p4ViewProductButton;
    private JButton p5ViewProductButton;
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
    private JLabel productCatalogBreadCrumb;
    private JLabel pageIndicator;
    private JButton featuredProductsButton;

    final Scanner scnr;

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


    public JButton getP1ViewProductButton() {
        return p1ViewProductButton;
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


    public JButton getP3ViewProductButton() {
        return p3ViewProductButton;
    }

    public JButton getP4ViewProductButton() {
        return p4ViewProductButton;
    }

    public JButton getP5ViewProductButton() {
        return p5ViewProductButton;
    }

    public JLabel getProductCatalogBreadCrumb() {
        return productCatalogBreadCrumb;
    }

    public JLabel getPageIndicator() {
        return pageIndicator;
    }
    public JButton getFeaturedProductsButton(){return featuredProductsButton;}
}
