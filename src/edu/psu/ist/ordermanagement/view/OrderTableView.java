package edu.psu.ist.ordermanagement.view;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.*;

public class OrderTableView extends JFrame {
    private JPanel basePanel;
    private JTable orderTable;
    private JScrollPane scrollPane;
    private JButton backButton;

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

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public JButton getBackButton() {
        return backButton;
    }
}
