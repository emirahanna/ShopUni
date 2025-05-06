package edu.psu.ist.productmanagement.controller;

import java.util.ArrayList;

import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductCatalog;
import edu.psu.ist.productmanagement.model.ProductCategory;
import edu.psu.ist.productmanagement.view.ProductListingView;

public class ProductListingController {
    final ProductCatalog catalog;
    final ProductListingView view;
    private int currentPage;
    private ProductCategory currCategory;

    public ProductListingController() {
        this.catalog = new ProductCatalog();
        this.view = new ProductListingView();
        this.currentPage = 1;
        currCategory = ProductCategory.NONE;

        setupListeners();
        setUpComboBox();
        showCatalog();
    }

    public void showCatalog() {
        ArrayList<Product> products = null;
        int totalPages = 0;
        if (currCategory.equals(ProductCategory.NONE)) {
            products = catalog.getProductsOnPage(currentPage);
            totalPages = catalog.getTotalPages();
        } else {
            catalog.getProductsByCategory(currCategory);
            products = catalog.getProductsByCategoryOnPage(currentPage);
            totalPages = catalog.getTotalPagesForCategory();
        }

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
        view.getMenuButton().addActionListener(e -> {
            new MenuController();
            view.setVisible(false);
        });
        view.getCategoryComboBox().addActionListener(e -> setUpComboBox());
        view.getP1ViewProductButton().addActionListener(e -> openProductPage(0));
        view.getP2ViewProductButton().addActionListener(e -> openProductPage(1));
        view.getP3ViewProductButton().addActionListener(e -> openProductPage(2));
        view.getP4ViewProductButton().addActionListener(e -> openProductPage(3));
        view.getP5ViewProductButton().addActionListener(e -> openProductPage(4));
    }

    private void setUpComboBox() {
        currCategory = ProductCategory.valueOf(view.getCategoryComboBox().getSelectedItem().toString().toUpperCase());
        currentPage = 1; // Reset to first page when category changes yay
        showCatalog();
    }

    private void openProductPage(int index) {
        ArrayList<Product> products = (currCategory == ProductCategory.NONE) ? catalog.getProductsOnPage(currentPage): catalog.getProductsByCategoryOnPage(currentPage);
        if (index < products.size()) {
            Product selectedProduct = products.get(index);
            view.setVisible(false);
            new ProductPageController(selectedProduct);
        }
    }
}

