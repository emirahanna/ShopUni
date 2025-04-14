package edu.psu.ist.productmanagement.view;

import edu.psu.ist.productmanagement.controller.ProductPageController;

import javax.swing.*;
import java.util.Scanner;

public class ProductPageView extends JFrame{
    private JPanel basePanel;
    private JButton backButton;
    private JPanel productDetails;
    private JLabel productTitle;
    private JLabel productDescription;
    private JLabel productPrice;
    private JButton addToCartButton;
    private JLabel productCatalogBreadCrumb;
    private JLabel productPageBreadCrumb;
    private JLabel productImage;

    private Scanner scnr;
    public ProductPageView()  {
        this.scnr = new Scanner(System.in);
        setView();
    }

    public void displayOptions(ProductPageController controller){
        System.out.println(controller.retrieveProduct());
        System.out.println("\nOptions:");
        System.out.println("A - Add To Cart");
        System.out.println("X - Back To Catalog");
    }

    public String getUserChoice() {
        System.out.println("Enter selected choice: ");
        return scnr.next();
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

    public void succAddToCart(){
        System.out.println("Successfully added to cart!\n");
    }
    public void invalidInput(){
        System.out.println("Invalid input. Please try again.\n");
    }

    public JPanel getBasePanel() {
        return basePanel;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JPanel getProductDetails() {
        return productDetails;
    }

    public JLabel getProductTitle() {
        return productTitle;
    }

    public JLabel getProductDescription() {
        return productDescription;
    }

    public JLabel getProductPrice() {
        return productPrice;
    }

    public JButton getAddToCartButton() {
        return addToCartButton;
    }

    public JLabel getProductCatalogBreadCrumb() {
        return productCatalogBreadCrumb;
    }

    public JLabel getProductPageBreadCrumb() {
        return productPageBreadCrumb;
    }

    public JLabel getProductImage() {
        return productImage;
    }


}
