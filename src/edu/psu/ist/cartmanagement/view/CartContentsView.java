package edu.psu.ist.cartmanagement.view;

import edu.psu.ist.productmanagement.model.Product;

import javax.swing.*;
import java.awt.*;
import java.util.Map;
import java.util.Scanner;

public class CartContentsView extends JFrame{
    private JPanel basePanel;
    private JPanel cartContentsPanel;
    private JScrollPane cartContentsScrollPane;
    private JPanel bottomButtonsPanel;
    private JPanel topPanel;
    private JButton emptyCartButton;
    private JButton buyNowButton;
    private JButton backButton;
    private JLabel cartTitle;
    private Scanner scnr;

    public CartContentsView(){
        scnr = new Scanner(System.in);
        setUpComponents();
        setView();
    }

    /*
    notes:
    GridBag - grid, need to specify rows and columns. (good for strict adherence to the code ig)

     */

    private void setUpComponents(){
        basePanel = new JPanel(new GridBagLayout());
        cartContentsPanel = new JPanel();
        cartContentsPanel.setLayout(new BoxLayout(cartContentsPanel, BoxLayout.Y_AXIS));


        cartContentsScrollPane = new JScrollPane(cartContentsPanel);
        cartContentsScrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        cartContentsScrollPane.setPreferredSize(new Dimension(440, 1000)); // Scroll area

        emptyCartButton = createStyledButton("Empty Cart");
        buyNowButton = createStyledButton("Buy Now");
        backButton = new JButton("<");

        topPanel = new JPanel();
        topPanel.setLayout(new GridBagLayout());
        cartTitle = new JLabel("Your Cart");
        topPanel.add(backButton, new GridBagConstraints());
        topPanel.add(cartTitle, new GridBagConstraints());

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

        addToPanel(topPanel, basePanel,  0, 0, 1, 1, GridBagConstraints.WEST, new Insets(0, 0, 10, 0));
        addToPanel(cartContentsScrollPane, basePanel, 0, 1, 1, 1, GridBagConstraints.CENTER , new Insets(0, 0, 10, 0));
        addToPanel(bottomButtonsPanel, basePanel, 0, 2, 1, 1, GridBagConstraints.SOUTH, new Insets(0, 0, 0, 0));
    }

    private void addToPanel(Component comp, JPanel panel, int x, int y, int width, int height, int anchor, Insets insets) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 1.0;
        gbc.weighty = (anchor == GridBagConstraints.CENTER) ? 1.0 : 0;
        gbc.anchor = anchor;
        gbc.fill = (anchor == GridBagConstraints.CENTER) ? GridBagConstraints.BOTH : GridBagConstraints.HORIZONTAL ;
        gbc.insets = insets;
        panel.add(comp, gbc);
    }


    public void createCartItemCard(String title, int quantity, double price){
        JPanel itemPanel = new JPanel(new GridBagLayout());
//        itemPanel.setBorder(BorderFactory.createCompoundBorder(
//                BorderFactory.createLineBorder(Color.LIGHT_GRAY),
//                BorderFactory.createEmptyBorder(10, 10, 10, 10)
//        ));

        itemPanel.setPreferredSize(new Dimension(400, 60));
        itemPanel.setMaximumSize(new Dimension(400, 60)); // Prevent stretching

        JLabel itemLabel = new JLabel(title + " x" + quantity + " - $" + price);
        JButton removeButton = new JButton("❌");
        removeButton.setPreferredSize(new Dimension(50, 25));
        removeButton.setMaximumSize(new Dimension(50, 25));

        removeButton.addActionListener(e -> {
            // TODO: cart.removeProduct(product); refreshCartDisplay();
        });

        addToPanel(itemLabel, itemPanel, 0, 0, 1, 1, GridBagConstraints.WEST, new Insets(0, 0, 10, 0));
        addToPanel(removeButton, itemPanel, 2, 0, 1, 1, GridBagConstraints.EAST, new Insets(0, 0, 0, 0));
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
        this.setTitle("ShopUni - Cart");
        this.setContentPane(basePanel);
        //sets the window to open with this resolution
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
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

    public String getProductName(){
        return scnr.next();
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
