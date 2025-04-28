package edu.psu.ist.cartmanagement.view;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

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

    public CartContentsView() {
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

    private void setUpComponents() {
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
        productPageBreadcrumb = new JLabel("Product Page > ");
        cartBreadcrumb = new JLabel("Cart");


        //back button uses the method because I wanted to specify the Inset to make it look better
        addToPanel(backButton, topPanel, createGbc(0, 0, 1, 1, GridBagConstraints.WEST,  GridBagConstraints.NONE));
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
        basePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        GridBagConstraints gbcTop = createGbc(0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addToPanel(topPanel, basePanel, gbcTop);

        GridBagConstraints gbcCenter = createGbc(0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.BOTH);
        addToPanel(cartContentsScrollPane, basePanel, gbcCenter);

        GridBagConstraints gbcBottom = createGbc(0, 2, 1, 1, GridBagConstraints.SOUTH, GridBagConstraints.HORIZONTAL);
        addToPanel(bottomButtonsPanel, basePanel, gbcBottom);
    }

    private void addToPanel(Component comp, JPanel panel, GridBagConstraints gbc) {
        panel.add(comp, gbc);
    }

    private GridBagConstraints createGbc(int x, int y, int width, int height, int anchor, int fill) {
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.gridwidth = width;
        gbc.gridheight = height;
        gbc.weightx = 1.0;
        gbc.weighty = (anchor == GridBagConstraints.CENTER) ? 1.0 : 0;
        gbc.anchor = anchor;
        gbc.fill = fill;
        gbc.insets = new Insets(0, 0, 0, 0); // Default insets
        return gbc;
    }



    public void createCartItemCard(String title, int quantity, double price, ActionListener removeListener) {
        JPanel itemPanel = new JPanel(new GridBagLayout());

        itemPanel.setPreferredSize(new Dimension(400, 60));
        itemPanel.setMaximumSize(new Dimension(400, 60)); // Prevent stretching

        JLabel itemLabel = new JLabel(String.format("%-40sx%-2d $%-5.2f", title, quantity, price));
        JButton removeButton = new JButton("❌");
        removeButton.setPreferredSize(new Dimension(50, 25));
        removeButton.setMaximumSize(new Dimension(50, 25));

        removeButton.addActionListener(removeListener);

        addToPanel(itemLabel, itemPanel, createGbc(0, 0, 2, 1, GridBagConstraints.WEST, GridBagConstraints.WEST));
        addToPanel(removeButton, itemPanel, createGbc(2, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.EAST));
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


    public JPanel getBasePanel() {
        return basePanel;
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

    public JLabel getProductCtlgBreadcrumb() {
        return productCtlgBreadcrumb;
    }

    public JLabel getProductPageBreadcrumb() {
        return productPageBreadcrumb;
    }
}
