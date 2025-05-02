//package edu.psu.ist.productmanagement;
//
//
//import edu.psu.ist.cartmanagement.controller.CartController;
//import edu.psu.ist.cartmanagement.view.CartContentsView;
//import edu.psu.ist.productmanagement.model.Product;
//import edu.psu.ist.productmanagement.model.ProductDAO;
//
//import javax.swing.*;
//
//public class productTest {
//
//    void testCartQuantityUpdate() {
//        CartContentsView view = new CartContentsView();
//        Product product = ProductDAO.findProductByID("1");
//
//        CartController controller = new CartController();
//        controller.addProduct(product);  // triggers UI update
//
//        JLabel quantityLabel = view.getIte(product); // hypothetical getter
//        assertEquals("Quantity: 1", quantityLabel.getText());
//    }
//
//}
