package controller;

import java.util.ArrayList;
import ProductDetailManagement.ProductDetails;
import view.ProductDetailsView;

/**
 * This class stores the model and the view
 * Establishes what occurs when user enters the view and what the buttons on the product details view do when clicked
 */

public class ViewProductDetailsController {

    private ProductDetails productDetails;
    private ProductDetailsView productDetailsView;

    //constructor stores model and view
    public ViewProductDetailsController (ProductDetails productDetails, ProductDetailsView productDetailsView){
        this.productDetails = productDetails;
        this.productDetailsView = productDetailsView;
    }

    //retrieves information about product requested
    public ArrayList<String> retrieveProduct(){
        return null;
    }

    //changes image and goes through image carousel for product on click if there's multiple images for a listing
    public String changeImg(){
        return null;
    }

}
