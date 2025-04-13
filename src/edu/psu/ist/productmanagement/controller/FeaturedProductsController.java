package edu.psu.ist.productmanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductCatalog;
import edu.psu.ist.productmanagement.view.FeaturedProductsView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class FeaturedProductsController {
   FeaturedProductsView featuredProductsView;
   ProductCatalog catalog;

    public FeaturedProductsController(){
        this.featuredProductsView = new FeaturedProductsView();
        this.catalog = new ProductCatalog();
        attachActionListeners();

        ArrayList<Product> featuredProducts = catalog.getFeaturedProducts();
        featuredProductsView.initializeFeaturedProducts(featuredProducts);
    }

    public void attachActionListeners() {
        featuredProductsView.getBackButton().addActionListener(e -> {
            new ProductListingController();
            featuredProductsView.setVisible(false);
        });
    }
}
