package edu.psu.ist.productmanagement.view;

import edu.psu.ist.productmanagement.model.Product;

import javax.swing.*;
import java.util.List;
import java.util.Scanner;

public class FeaturedProductsView extends JFrame{
    private JPanel basePanel;
    private JButton previousButton;
    private JButton nextButton;
    private JLabel titleText;
    private JButton backButton;
    private JLabel nameLabel;
    private JLabel priceLabel;

    private List<Product> featuredProducts;
    private int currIndex =0;

    private Scanner scnr;

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
        this.setSize(500, 700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }


    public JButton getBackButton() {
        return backButton;
    }
    public JPanel getBasePanel(){return basePanel;}
    public JButton getPreviousButton(){return previousButton;}
    public JButton getNextButton(){return nextButton;}
    public JLabel getTitleText(){return titleText;}

}
