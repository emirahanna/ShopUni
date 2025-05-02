package edu.psu.ist.productmanagement.controller;
import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.productmanagement.view.ProductNotFoundPage;


public class ProductNotFoundController {
    private ProductNotFoundPage view;

    public ProductNotFoundController() {
        this.view = new ProductNotFoundPage();
        attachActionListeners();
    }

    public void attachActionListeners() {
        view.getBackButton().addActionListener(e -> {
            new MenuController();
            view.setVisible(false);
        });
    }
}
