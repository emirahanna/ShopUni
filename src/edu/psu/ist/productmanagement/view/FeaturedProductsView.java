package edu.psu.ist.productmanagement.view;

import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.psu.ist.productmanagement.model.Product;

public class FeaturedProductsView extends JFrame{
    private JPanel basePanel;
    private JPanel cardPanel;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleText;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel priceLabel;
    
    private List<Product> featuredProducts;
    private int currIndex =0;

    final Scanner scnr;

public FeaturedProductsView(){
    setView();
    this.scnr = new Scanner(System.in);
}


public void initializeFeaturedProducts(List<Product> products){
    this.featuredProducts = products;

    if(products != null && !products.isEmpty()){
        currIndex = 0;
        updateProductCarousel();
    }
    attachActionListeners();
    updateButtons();

    }

    private void attachActionListeners(){
        previousButton.addActionListener(e -> showPrevious());
        nextButton.addActionListener(e -> showNext());
    }

    public void showNext(){
    if(currIndex < featuredProducts.size() - 1) {
        currIndex++;
        updateProductCarousel();
    }
    updateButtons();
    }

    public void showPrevious(){
        if(currIndex > 0) {
            currIndex--;
            updateProductCarousel();
        }
        updateButtons();
    }

    private void updateButtons(){
        previousButton.setEnabled(currIndex>0);
        nextButton.setEnabled(currIndex < featuredProducts.size()-1);
    }

    private void updateProductCarousel(){
    Product product = featuredProducts.get(currIndex);
    //text wrapping because name is too long
    nameLabel.setText("<html><body style='width: 200px'>Name: " + product.getTitle() + "</body></html>");
    priceLabel.setText("Price: "+ product.getPrice());
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
