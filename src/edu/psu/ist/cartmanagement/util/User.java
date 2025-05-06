package edu.psu.ist.cartmanagement.util;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.usermanagement.model.UserAccount;

import javax.swing.*;

public class User implements CartObserver {
    private UserAccount account;
    private CartManager cart;
    private boolean alertShown;

    public User(UserAccount account, CartManager cart) {
        this.account = account;
        this.cart = cart;
        cart.addObserver(this);
        alertShown = false;
    }

    @Override
    public void update() {
        boolean hasItems = !cart.getItems().isEmpty();
        account.setHasCartItems(hasItems);

        if (hasItems && !alertShown) {
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Welcome back! You still have " + cart.getItems().size() + " item(s) in your cart.", "Cart Reminder", JOptionPane.INFORMATION_MESSAGE);
                alertShown = true;
            });
        }
    }
}
