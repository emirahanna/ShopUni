package edu.psu.ist.usermanagement.controller;

import edu.psu.ist.cartmanagement.controller.CartController;
import edu.psu.ist.cartmanagement.model.CartManager;
import edu.psu.ist.cartmanagement.util.User;
import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.usermanagement.model.UserAccount;
import edu.psu.ist.usermanagement.model.UserRole;
import edu.psu.ist.usermanagement.model.UserSession;
import edu.psu.ist.usermanagement.view.LogInView;
import edu.psu.ist.cartmanagement.util.CartObserver.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LogInController {
    private LogInView logInView;

    public LogInController() {
        this.logInView = new LogInView();
        initializeActionListeners();
    }

    private void initializeActionListeners() {
        logInView.getLogInButton().addActionListener(e -> login());

        //makes it so that the user doesn't have to manually delete the hint inside the text fields
        attachHintFocusListener(logInView.getPasswordField(), "Password");
        attachHintFocusListener(logInView.getUsernameField(), "Username");

        logInView.getSignUpPrompt().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new SignUpController();
                logInView.setVisible(false);
            }
        });
    }

    public static void attachHintFocusListener(JTextField field, String hint) {
        field.setText(hint);
        field.setForeground(Color.BLACK);

        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (field.getText().equals(hint)) {
                    field.setText("");
                    field.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (field.getText().isEmpty()) {
                    field.setForeground(Color.BLACK);
                    field.setText(hint);
                }
            }
        });
    }

    public void login() {
        String username = logInView.getUsernameField().getText();
        String password = logInView.getPasswordField().getText();
        UserAccount user = new UserAccount(username, password);
        try {
            UserRole role = user.verifyUser();
            if (role == UserRole.BUYER) {
                CartController.loadCartAtLogin(UserSession.getInstance().getUserID());
                new User(user, CartManager.getInstance());
                new MenuController();
                logInView.setVisible(false);
            }
            else {
                JOptionPane.showMessageDialog(logInView, "Login failed. You are not a registered user", "Login Error", JOptionPane.ERROR_MESSAGE);

            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(logInView, "Login failed. Incorrect username or password.", "Login Error", JOptionPane.ERROR_MESSAGE);
        }

    }
}