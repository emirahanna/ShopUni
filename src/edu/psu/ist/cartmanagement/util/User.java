package edu.psu.ist.cartmanagement.util;

import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.usermanagement.model.UserAccount;

import javax.swing.*;

public class User implements CartObserver {
    final UserAccount account;
    final CartManager cart;

    public User(UserAccount account, CartManager cart) {
        this.account = account;
        this.cart = cart;
        cart.addObserver(this);
    }

    @Override
    public void update() {
        boolean hasItems = !cart.getItems().isEmpty();
        account.setHasCartItems(hasItems);

        if (hasItems) {
            SwingUtilities.invokeLater(() -> {
                JOptionPane.showMessageDialog(null, "Welcome back! You still have " + cart.getItems().size() + " item(s) in your cart.", "Cart Reminder", JOptionPane.INFORMATION_MESSAGE);
            });
        }
    }
}
