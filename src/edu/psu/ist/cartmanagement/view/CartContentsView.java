package edu.psu.ist.cartmanagement.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.util.Map;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import edu.psu.ist.productmanagement.model.Product;

public class CartContentsView extends JFrame {
    private JPanel basePanel;
    private JPanel cartContentsPanel;
    private JScrollPane cartContentsScrollPane;
    private JPanel bottomButtonsPanel;
    private JPanel topPanel;
    private JButton emptyCartButton;
    private JButton buyNowButton;
    private JButton backButton;
    private JLabel cartBreadcrumb;
    private JLabel productCtlgBreadcrumb;
    private JLabel productPageBreadcrumb;
    final Scanner scnr;

    public CartContentsView(){
        scnr = new Scanner(System.in);
        setUpComponents();
        setView();
    }

    /*
    notes:
    GridBag - grid. allows for most customization, need to specify rows and columns. (good for strict adherence to the code ig)
    box layout - good for single row/column - can use for the one line panels
    flow layout - line up left to right and wrap as needed (but no precise control)
    border layout - good if you want to arrange around the border (can anchor to 5 regions)

    why are there so many layouts, this is my 13th reason

     */

    private void setUpComponents(){
        basePanel = new JPanel(new GridBagLayout());
        cartContentsPanel = new JPanel(new GridBagLayout());
        cartContentsPanel.setLayout(new BoxLayout(cartContentsPanel, BoxLayout.Y_AXIS)); //because i only want it to go down vertically? idk seems like the best choice


        cartContentsScrollPane = new JScrollPane(cartContentsPanel);
        cartContentsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cartContentsScrollPane.setPreferredSize(new Dimension(440, 1000)); // Scroll area

        emptyCartButton = createStyledButton("Empty Cart");
        buyNowButton = createStyledButton("Buy Now");
        backButton = new JButton("Back");

        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        productCtlgBreadcrumb = new JLabel("Catalog > ");
        productPageBreadcrumb = new JLabel("Product Page > "); //TODO: make this dynamic according to product Title
        cartBreadcrumb = new JLabel("Cart");


        //back button uses the method because I wanted to specify the Inset to make it look better
        addToPanel(backButton, topPanel, 0,0,1,1, GridBagConstraints.WEST, new Insets(0,0,0,16), GridBagConstraints.NONE);
        topPanel.add(productCtlgBreadcrumb, new GridBagConstraints());
        topPanel.add(productPageBreadcrumb, new GridBagConstraints());
        topPanel.add(cartBreadcrumb, new GridBagConstraints());

        bottomButtonsPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        bottomButtonsPanel.add(emptyCartButton);
        bottomButtonsPanel.add(buyNowButton);
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(204, 30));
        return button;
    }

    public void layoutComponents() {
        // Padding for the whole frame
        basePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        addToPanel(topPanel, basePanel,  0, 0, 1, 1, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), GridBagConstraints.NONE);
        addToPanel(cartContentsScrollPane, basePanel, 0, 1, 1, 1, GridBagConstraints.CENTER , new Insets(0, 0, 0, 0), GridBagConstraints.BOTH);
        addToPanel(bottomButtonsPanel, basePanel, 0, 2, 1, 1, GridBagConstraints.SOUTH, new Insets(0, 0, 0, 0), GridBagConstraints.HORIZONTAL);
    }

    private void addToPanel(Component comp, JPanel panel, int x, int y, int width, int height, int anchor, Insets insets, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 1.0;
        gbc.weighty = (anchor == GridBagConstraints.CENTER) ? 1.0 : 0;
        gbc.anchor = anchor;
        gbc.fill = fill ;
        gbc.insets = insets;
        panel.add(comp, gbc);
    }




    public void createCartItemCard(String title, int quantity, double price, ActionListener removeListener){
        JPanel itemPanel = new JPanel(new GridBagLayout());

        itemPanel.setPreferredSize(new Dimension(400, 60));
        itemPanel.setMaximumSize(new Dimension(400, 60)); // Prevent stretching

        //TODO: MAKE THE FORMATTING STANDARD, its is not for some reason
        JLabel itemLabel = new JLabel( String.format("%-40sx%-2d $%-5.2f", title, quantity, price));
        JButton removeButton = new JButton("❌");
        removeButton.setPreferredSize(new Dimension(50, 25));
        removeButton.setMaximumSize(new Dimension(50, 25));

        removeButton.addActionListener(removeListener);

        addToPanel(itemLabel, itemPanel, 0, 0, 2, 1, GridBagConstraints.WEST, new Insets(0, 0, 0, 0), GridBagConstraints.WEST);
        addToPanel(removeButton, itemPanel, 2, 0, 1, 1, GridBagConstraints.EAST, new Insets(0, 0, 0, 0), GridBagConstraints.EAST);
        cartContentsPanel.add(itemPanel);
    }



    public void clearCartDisplay() {
        cartContentsPanel.removeAll();
    }

    public void repaintCartDisplay() {
        cartContentsPanel.revalidate();
        cartContentsPanel.repaint();
    }

    private void setView() {
        //names the text at the top of the window
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        //sets the window to open with this resolution
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        layoutComponents();
    }



    public String getProductName(){
        return scnr.next();
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

    public JPanel getBasePanel() {
        return basePanel;
    }

    public JPanel getCartContentsPanel() {
        return cartContentsPanel;
    }

    public JScrollPane getCartContentsScrollPane() {
        return cartContentsScrollPane;
    }

    public JPanel getBottomButtonsPanel() {
        return bottomButtonsPanel;
    }

    public JPanel getTopPanel() {
        return topPanel;
    }

    public JButton getEmptyCartButton() {
        return emptyCartButton;
    }

    public JButton getBuyNowButton() {
        return buyNowButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getCartBreadcrumb() {
        return cartBreadcrumb;
    }

    public JLabel getProductCtlgBreadcrumb() {
        return productCtlgBreadcrumb;
    }

    public JLabel getProductPageBreadcrumb() {
        return productPageBreadcrumb;
    }
}
