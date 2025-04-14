package edu.psu.ist.usermanagement.controller;

import edu.psu.ist.productmanagement.controller.ProductListingController;
import edu.psu.ist.usermanagement.model.UserAccount;
import edu.psu.ist.usermanagement.model.UserRole;
import edu.psu.ist.usermanagement.view.LogInView;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LogInController {
    private static final Log log = LogFactory.getLog(LogInController.class);
    LogInView logInView;
    private UserAccount authenticatedUser; // Stores the logged-in user


    public LogInController() {
        this.logInView = new LogInView();
        initializeActionListeners();

    }

    private void initializeActionListeners(){
        logInView.getLogInButton().addActionListener(e -> login());
    }

    public void login() {
        String username = logInView.getUsernameField().getText();
        String password = logInView.getPasswordField().getText();
        UserAccount user = new UserAccount(username, password);

        try {
            UserRole role = user.verifyUser();
            if (role == UserRole.BUYER) {
                JOptionPane.showMessageDialog(logInView, "Buyer Login Success");
                authenticatedUser = user;
                new ProductListingController();
                logInView.setVisible(false);
            }

        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(logInView,
                    "Login failed. Incorrect username or password.","Login Error", JOptionPane.ERROR_MESSAGE);
        }

    }


    public UserAccount getAuthenticatedUser() {
        return authenticatedUser;
    }

    public String getAuthUserID(){
        return authenticatedUser.getUsername();
    }
}