package edu.psu.ist.ordermanagement.view;

import javax.swing.*;

public class OrderTableView extends JFrame {
    private JPanel basePanel;
    private JTable orderTable;
    private JScrollPane scrollPane;
    private JButton backButton;
    private JLabel orderDetails;

    public OrderTableView() {
        this.setView();
    }

    public void setView() {
        this.scrollPane.setViewportView(this.orderTable);
        this.orderTable.setFillsViewportHeight(true);
        this.scrollPane.setVerticalScrollBarPolicy(22);
        this.setContentPane(this.basePanel);
        this.setSize(500, 800);
        this.setTitle("ShopUni - Tracking Order");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public JPanel getBasePanel() {
        return basePanel;
    }
    public JTable getOrderTable() {
        return orderTable;
    }
    public JLabel getOrderDetails() {
        return orderDetails;
    }
    public JButton getBackButton() {
        return backButton;
    }
}
