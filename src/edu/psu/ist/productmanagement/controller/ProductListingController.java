package edu.psu.ist.productmanagement.controller;

import java.util.ArrayList;

import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductCatalog;
import edu.psu.ist.productmanagement.view.ProductListingView;

public class ProductListingController {
    final ProductCatalog catalog;
    final ProductListingView view;
    private int currentPage;
    final boolean isCatalogOpen;

    public ProductListingController() {
        this.catalog = new ProductCatalog();
        this.view = new ProductListingView();
        this.currentPage = 1;
        isCatalogOpen = true;

        setupListeners();
        showCatalog();

    }

    public void showCatalog() {
        ArrayList<Product> products = catalog.getProductsOnPage(currentPage);
        int totalPages = catalog.getTotalPages();
        view.initializeProducts(products, currentPage, totalPages);
        view.getPageIndicator().setText(("Page " + currentPage + " of " + totalPages));
    }

    private void nextPage(int totalPages) {
        if (currentPage < totalPages) {
            currentPage++;
        }
    }

    private void prevPage() {
        if (currentPage > 1) {
            currentPage--;
        }
    }


    private void setupListeners() {
        view.getNextButton().addActionListener(e -> {
            nextPage(catalog.getTotalPages());
            showCatalog();
        });
        view.getPreviousButton().addActionListener(e -> {
            prevPage();
            showCatalog();
        });
        view.getFeaturedProductsButton().addActionListener(e -> {
            new FeaturedProductsController();
            view.setVisible(false);
        });

        view.getP1ViewProductButton().addActionListener(e -> openProductPage(0));
        view.getP2ViewProductButton().addActionListener(e -> openProductPage(1));
        view.getP3ViewProductButton().addActionListener(e -> openProductPage(2));
        view.getP4ViewProductButton().addActionListener(e -> openProductPage(3));
        view.getP5ViewProductButton().addActionListener(e -> openProductPage(4));
    }

    private void openProductPage(int index) {
        ArrayList<Product> products = catalog.getProductsOnPage(currentPage);
        if (index < products.size()) {
            Product selectedProduct = products.get(index);
            view.setVisible(false);
            new ProductPageController(selectedProduct);
        }
    }
}

