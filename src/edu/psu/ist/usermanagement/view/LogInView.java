package edu.psu.ist.usermanagement.view;

import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LogInView extends JFrame{
    private JPanel logInPanel;
    private JTextField usernameField;
    private JButton logInButton;
    private JLabel shopUniLabel;
    private JTextField passwordField;
    public LogInView(){
        setView();
    }

    private void setView() {
        this.setTitle("ShopUni");
        this.setContentPane(logInPanel);
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
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
    public JLabel getShopUniLabel() {
        return shopUniLabel;
    }
    public JTextField getPasswordField() {
        return passwordField;
    }

    }

