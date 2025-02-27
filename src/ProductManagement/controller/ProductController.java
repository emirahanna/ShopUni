package ProductManagement.controller;

import ProductManagement.model.Product;
import ProductManagement.view.ProductListingView;

public class ProductController {
    Product productModel;
    ProductListingView productPageView;

    public ProductController(Product productModel, ProductListingView productPageView) {
        this.productModel = productModel;
        this.productPageView = productPageView;
    }
}
