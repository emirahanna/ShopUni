package edu.psu.ist.productmanagement.view;

import javax.swing.*;

public class ProductNotFoundPage extends JFrame {
    private JButton backButton;
    private JLabel infoLabel;
    private JLabel errorMessageLabel;
    private JPanel basePanel;

    public ProductNotFoundPage() {
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
    }

    public JButton getBackButton() {
        return backButton;
    }
}
