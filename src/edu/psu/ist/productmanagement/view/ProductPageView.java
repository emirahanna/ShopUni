package edu.psu.ist.productmanagement.view;

import javax.swing.*;
import java.awt.*;

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


    public ProductPageView()  {
        setView();
    }

    public void setProductImage(ImageIcon icon){
        setScaledImage(icon);
        productImage.revalidate();
        productImage.repaint();
    }

    public void setEmptyImage(){
        productImage.setText("No product image available.");
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



    public JPanel getBasePanel() {
        return basePanel;
    }

    public JButton getBackButton() {
        return backButton;
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
