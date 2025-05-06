package edu.psu.ist.menumanagement.view;

import javax.swing.*;

public class MenuView extends JFrame{
    private JButton viewProductDetailsButton;
    private JButton addToCartButton;
    private JButton purchaseProductButton;
    private JPanel basePanel;
    private JLabel promptLabel;
    private JButton trackOrdersButton;
    private JButton logOutButton;

    public MenuView() {
        setView();
    }

    private void setView() {
        //names the text at the top of the window
        this.setTitle("ShopUni");
        this.setContentPane(basePanel);
        //sets the window to open with this resolution
        this.setSize(500, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
        this.promptLabel.setText("<html>Or you can experience the app as we intended (click to experience all use cases sequentially)</html>");
    }

    public JButton getViewProductDetailsButton() {
        return viewProductDetailsButton;
    }

    public JButton getAddToCartButton() {
        return addToCartButton;
    }

    public JButton getPurchaseProductButton() {
        return purchaseProductButton;
    }

    public JButton getTrackOrdersButton() {
        return trackOrdersButton;
    }

    public JLabel getPromptLabel() {
        return promptLabel;
    }

    public JButton getLogOutButton() {
        return logOutButton;
    }
}
