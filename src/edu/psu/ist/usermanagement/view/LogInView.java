package edu.psu.ist.usermanagement.view;

import javax.swing.*;

public class LogInView extends JFrame{
    private JPanel logInPanel;
    private JTextField usernameField;
    private JButton logInButton;
    private JLabel shopUniLabel;
    private JTextField passwordField;
    private JLabel signUpPrompt;

    public LogInView(){
        setView();
    }

    private void setView() {
        this.setTitle("ShopUni");
        this.setContentPane(logInPanel);
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        signUpPrompt.setText("<html>Don't have an account? <u>Sign up here.</u></html>");
        focusOnDummyPanel();

    }

    private void focusOnDummyPanel(){
        logInPanel.setFocusable(true);
        logInPanel.requestFocusInWindow();
    }



    public JPanel getLogInPanel() {
        return logInPanel;
    }
    public JTextField getUsernameField() {
        return usernameField;
    }
    public JButton getLogInButton() {
        return logInButton;
    }
    public JTextField getPasswordField() {
        return passwordField;
    }

    public JLabel getSignUpPrompt() {
        return signUpPrompt;
    }
}

