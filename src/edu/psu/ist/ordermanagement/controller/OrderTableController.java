package edu.psu.ist.ordermanagement.controller;

import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.ordermanagement.model.OrderTableModel;
import edu.psu.ist.ordermanagement.view.OrderTableView;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class OrderTableController {

    private OrderTableModel model;
    private OrderTableView view;

    public OrderTableController() {
        model = new OrderTableModel();
        view = new OrderTableView();
        this.displayData();
        this.addActionListeners();
        this.mouseListener();
        this.autoSelectFirstRow();


    }

    private void autoSelectFirstRow(){
        if (model.getRowCount() > 0) {
            view.getOrderTable().setRowSelectionInterval(0, 0); // selects first row
            showOrderDetails(0);
        }
    }

    private void addActionListeners() {
        this.view.getBackButton().addActionListener(e -> {
            new MenuController();
            view.setVisible(false);
        });
    }

    public void displayData() {
        this.view.getOrderTable().setModel(this.model);
    }

    private void mouseListener() {
        this.view.getOrderTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    showOrderDetails(target.getSelectedRow());
                }

            }
        });
    }

    private void showOrderDetails(int selectedRow){
        view.getOrderDetails().setText("<html>" + model.getOrderDetails(selectedRow) +"</html>");
    }

}
