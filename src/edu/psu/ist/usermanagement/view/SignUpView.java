package edu.psu.ist.usermanagement.view;

import javax.swing.*;

public class SignUpView extends JFrame{
    private JTextField usernameField;
    private JLabel shopUniLabel;
    private JPanel basePanel;
    private JComboBox roleComboBox;
    private JLabel logInPrompt;
    private JButton signUpButton;
    private JPasswordField passwordField;

    public SignUpView(){
        setView();
        roleComboBox.addItem("Buyer");
        logInPrompt.setText("<html>Already have an account? <u>Sign in here.</u></html>");

    }

    private void setView() {
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JLabel getLogInPrompt() {
        return logInPrompt;
    }

    public JButton getSignUpButton() {
        return signUpButton;
    }

    public JTextField getUsernameField() {
        return usernameField;
    }

    public JTextField getPasswordField() {
        return passwordField;
    }

    public JComboBox getRoleComboBox() {
        return roleComboBox;
    }
}
