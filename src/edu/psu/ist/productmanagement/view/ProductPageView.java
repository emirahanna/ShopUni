package edu.psu.ist.productmanagement.view;

import javax.swing.*;

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
        productImage.setIcon(icon);
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
