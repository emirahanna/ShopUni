package edu.psu.ist.productmanagement.controller;

import edu.psu.ist.productmanagement.model.Product;
import edu.psu.ist.productmanagement.model.ProductCatalog;
import edu.psu.ist.productmanagement.view.ProductListingView;

import java.util.ArrayList;

public class ProductListingController {
    private ProductCatalog catalog;
    private ProductListingView view;
    private int currentPage;
    private boolean isCatalogOpen;

    public ProductListingController() {
        this.catalog = new ProductCatalog();
        this.view = new ProductListingView();
        this.currentPage = 1;
        isCatalogOpen = true;
        showCatalog();
    }

    public void showCatalog() {
        int totalPages = catalog.getTotalPages();
        while (isCatalogOpen) {
            ArrayList<Product> products = catalog.getProductsOnPage(currentPage);
            view.displayProducts(products, currentPage, totalPages);

            String choice = view.getUserChoice().toUpperCase();

            switch (choice) {
                case "N" -> nextPage(totalPages);
                case "P" -> prevPage();
                case "S" -> {
                    Product selectedProduct = selectProduct(products);
                    if (selectedProduct != null){
                        new ProductPageController(selectedProduct);
                    }
                    isCatalogOpen = false;
                }
                case "X" -> {
                    view.exitCatalog();
                    isCatalogOpen = false;
                }
                default -> view.invalidInput();
            }
        }
    }

    private void nextPage(int totalPages) {
        if (currentPage < totalPages) {
            currentPage++;
        } else {
            view.lastPageWarning();
        }
    }

    private void prevPage() {
        if (currentPage > 1) {
            currentPage--;
        } else {
            view.firstPageWarning();
        }
    }

    private Product selectProduct(ArrayList<Product> products) {
        try {
            int choice = Integer.parseInt(view.getSelectedProduct());
            if (choice < 1 || choice > products.size()) {
                view.invalidSelection();
            } else {
                view.displaySelection(products.get(choice - 1).getTitle());
                return products.get(choice - 1);
            }
        } catch (NumberFormatException e) {
            view.invalidInput();
        }
        return null;
    }
}

