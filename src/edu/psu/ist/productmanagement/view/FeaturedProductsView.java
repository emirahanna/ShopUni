package edu.psu.ist.productmanagement.view;

import java.awt.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import javax.swing.*;

import edu.psu.ist.productmanagement.model.Product;

public class FeaturedProductsView extends JFrame {
    private JPanel basePanel;
    private JPanel cardPanel;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleText;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel priceLabel;
    private JLabel productImage;
    private List<Product> featuredProducts;
    private int currIndex = 0;

    public FeaturedProductsView() {
        setView();
    }


    public void initializeFeaturedProducts(List<Product> products) {
        this.featuredProducts = products;

        if (products != null && !products.isEmpty()) {
            currIndex = 0;
            updateProductCarousel();
        }
        attachActionListeners();
        updateButtons();

    }

    private void attachActionListeners() {
        previousButton.addActionListener(e -> showPrevious());
        nextButton.addActionListener(e -> showNext());
    }

    public void showNext() {
        if (currIndex < featuredProducts.size() - 1) {
            currIndex++;
            updateProductCarousel();
        }
        updateButtons();
    }

    public void showPrevious() {
        if (currIndex > 0) {
            currIndex--;
            updateProductCarousel();
        }
        updateButtons();
    }

    private void updateButtons() {
        previousButton.setEnabled(currIndex > 0);
        nextButton.setEnabled(currIndex < featuredProducts.size() - 1);
    }

    private void updateImage(Product p) {
        try {
            ImageIcon icon = new ImageIcon(Objects.requireNonNull(getClass().getResource("/" + p.getID() + ".jpg")));
            setProductImage(icon);
        } catch (Exception e) {

            setEmptyImage();
        }
    }

    public void setProductImage(ImageIcon icon) {
        setScaledImage(icon);
        productImage.revalidate();
        productImage.repaint();
    }

    public void setEmptyImage() {
        productImage.setText("No product image available.");
    }

    private void setScaledImage(ImageIcon icon) {
        int labelWidth = productImage.getWidth();
        int labelHeight = productImage.getHeight();

        if (labelWidth == 0 || labelHeight == 0) {
            // Ensure the label is laid out first
            productImage.setSize(productImage.getPreferredSize());
            labelWidth = productImage.getWidth();
            labelHeight = productImage.getHeight();
        }

        // Calculate new dimensions while maintaining aspect ratio with typecasting to accuracymaxx
        double widthRatio = (double) labelWidth / icon.getIconWidth();
        double heightRatio = (double) labelHeight / icon.getIconHeight();
        double scaleFactor = Math.min(widthRatio, heightRatio);

        int newWidth = (int) (icon.getIconWidth() * scaleFactor);
        int newHeight = (int) (icon.getIconHeight() * scaleFactor);

        Image scaledImg = icon.getImage().getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH); //smooth because you want it to look good
        productImage.setIcon(new ImageIcon(scaledImg));
    }

    private void updateProductCarousel() {
        Product product = featuredProducts.get(currIndex);
        //text wrapping because name is too long
        updateImage(product);
        nameLabel.setText("<html><body style='width: 200px'>Name: " + product.getTitle() + "</body></html>");
        priceLabel.setText("Price: " + product.getPrice());
    }

    private void setView() {
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public JButton getBackButton() {
        return backButton;
    }

}
