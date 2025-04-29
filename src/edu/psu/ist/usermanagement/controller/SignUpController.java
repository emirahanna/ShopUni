package edu.psu.ist.usermanagement.controller;

import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.usermanagement.model.UserAccount;
import edu.psu.ist.usermanagement.model.UserDAO;
import edu.psu.ist.usermanagement.model.UserRole;
import edu.psu.ist.usermanagement.view.SignUpView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SignUpController {
    private SignUpView view;

    public SignUpController() {
        this.view = new SignUpView();
        initializeActionListeners();
    }

    private void initializeActionListeners() {
        view.getSignUpButton().addActionListener(e -> {
            createAccount();
            new MenuController();
            view.setVisible(false);
        });

        //makes it so that the user doesn't have to manually delete the hint inside the text fields
        attachHintFocusListener(view.getPasswordField(), "Password");
        attachHintFocusListener(view.getUsernameField(), "Username");


        view.getLogInPrompt().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                new LogInController();
                view.setVisible(false);
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

    public void createAccount() {
        try {
            String username = view.getUsernameField().getText();
            String password = view.getPasswordField().getText();
            if (username.isEmpty() || password.isEmpty()) {
                throw new IllegalArgumentException();
            }
            UserRole role = UserRole.valueOf(view.getRoleComboBox().getSelectedItem().toString().toUpperCase());
            UserAccount user = new UserAccount(username, password, role);
            UserDAO.insertUser(user);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(view, "Please ensure all details are filled");
        }
    }
}
