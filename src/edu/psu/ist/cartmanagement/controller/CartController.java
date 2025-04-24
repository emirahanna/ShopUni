package edu.psu.ist.cartmanagement.controller;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Date;
import java.util.Map;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.util.CartObserver;
import edu.psu.ist.cartmanagement.view.CartContentsView;
import edu.psu.ist.paymentmanagement.controller.PaymentWizardController;
import edu.psu.ist.paymentmanagement.view.PaymentWizardFrame;
import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.productmanagement.controller.ProductPageController;
import edu.psu.ist.productmanagement.model.Product;

public class CartController implements CartObserver {
    final CartManager cart;
    final CartContentsView view;
    private Product recentProduct;

    public CartController() {
        this.cart = CartManager.getInstance(); //singleton model
        view = new CartContentsView();
        attachActionListeners();
        cart.addObserver(this);
        update(); // Populate view at start
        //manageCart();
    }


    public void addProduct(Product p) {
        cart.addProduct(p);
        recentProduct = p;
        view.getProductPageBreadcrumb().setText(p.getTitle() + ">");
        update();
    }

    private void removeProduct() {
        view.removeProductPrompt();
        String productName = view.getProductName();
        for (Product p : cart.getCartContents().keySet()) {
            if (p.getTitle().equalsIgnoreCase(productName)) {
                cart.removeProduct(p);
                view.productWasRemoved(p.getTitle());
                return;
            }
        }
        view.productNotFound();
    }

    private void buyCart() {
        if (cart.getCartContents().isEmpty()) {
            view.cartEmptyReminder();
            return;
        }
        cart.emptyCart();  // Simulate purchase
    }

    //you can test the cart page here

    public static void main(String[] args) {
        //ensure the code runs on time, without invoke later, it had UI bugs
        SwingUtilities.invokeLater(() -> {
            CartController crtl = new CartController();
            crtl.addProduct(new Product("Levi Pants", "Effortlessly chic, this draped front top is crafted from a MicroModal blend offering a soft, luxurious feel with a hint of stretch.\nWith a slim fit and high neckline, it features gathered detailing across the front creating a flattering, asymmetrical silhouette.\nPair with skirts or tailored trousers for a sophisticated take.", "20342391331", "imageID", "sellerID", new Date(), "Tops", 40.0));
            crtl.addProduct(new Product("Nike Hoodie", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", 30.0));
            crtl.addProduct(new Product("Zara Pants", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance.\nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", 60.0));
            crtl.addProduct(new Product("Lorem Ipsum", "Designed in a responsible MicroModal mix, this draped short-sleeve top combines comfort with elegance. \nFeaturing a flattering gathered design across the front and a unique asymmetric neckline, style it with your favourite pair of jeans for an effortlessly refined look. ", "20342391331", "imageID", "sellerID", new Date(), "Tops", 100.0));
        });
    }

    public void attachActionListeners() {
        view.getEmptyCartButton().addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(view.getBasePanel(), "Cart is empty!");
            } else {
                int confirmMessage = JOptionPane.showConfirmDialog(view.getBasePanel(), "Are you sure you want to empty your cart?", "Empty Cart", JOptionPane.YES_NO_OPTION);

                if (confirmMessage == JOptionPane.YES_OPTION) {
                    cart.emptyCart();
                    update();
                    JOptionPane.showMessageDialog(view.getBasePanel(), "Cart has been emptied");
                }
            }
        });
        view.getBuyNowButton().addActionListener(e -> {
            if (cart.isEmpty()) {
                JOptionPane.showMessageDialog(view.getBasePanel(), "Cart is empty! Add products before purchasing.");
            } else {
                new PaymentWizardController(this);
                view.setVisible(false);
            }
        });
        view.getBackButton().addActionListener(e -> {
            new ProductListingController();
            view.setVisible(false);
        });
        //using mouse listeners for the breadcrumbs, but that means I need to implement all the Mouse Listener methods ouch
        view.getProductCtlgBreadcrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductListingController();
                view.setVisible(false);
            }
        });
        view.getProductPageBreadcrumb().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new ProductPageController(recentProduct);
                view.setVisible(false);
            }
        });
    }

    @Override
    public void update() {
        view.clearCartDisplay();

        for (Map.Entry<Product, Integer> entry : cart.getCartContents().entrySet()) { //I want both the product, and the quantity
            Product product = entry.getKey();
            int quantity = entry.getValue();
            view.createCartItemCard(product.getTitle(), quantity, product.getPrice(), e -> {
                cart.removeProduct(product);
                JOptionPane.showMessageDialog(view.getBasePanel(), product + " removed from cart");
            });
        }
        view.layoutComponents();
        view.repaintCartDisplay();
    }

    public String getCartContents() {
        StringBuilder sb = new StringBuilder();
        for (Product p : cart.getCartContents().keySet()) {
            sb.append(String.format("%-30s %5d %5.2f\n", p.getTitle(), cart.getCartContents().get(p), p.getPrice()));
        }
        return sb.toString();
    }

    public double getPrice() {
        return cart.getTotalPrice();
    }
}

