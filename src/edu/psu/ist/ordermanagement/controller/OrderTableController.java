package edu.psu.ist.ordermanagement.controller;

import edu.psu.ist.menumanagement.controller.MenuController;
import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.ordermanagement.model.OrderTableModel;
import edu.psu.ist.ordermanagement.view.OrderTableView;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
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
        this.tableModelListener();

    }

    private void addActionListeners() {
        this.view.getBackButton().addActionListener(e -> {
            new MenuController();
            view.setVisible(false);
        });
    }

    public void displayData() {
        this.model = new OrderTableModel();
        this.view.getOrderTable().setModel(this.model);
    }

    private void mouseListener() {
        this.view.getOrderTable().addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 1) {
                    JTable target = (JTable) e.getSource();
                    //add func to make it select the indiidual row
                }

            }
        });
    }

    private void tableModelListener() {
        this.model.addTableModelListener(new TableModelListener() {
            public void tableChanged(TableModelEvent e) {
                if (e.getType() == 0) {
                    int row = e.getFirstRow();
                    int column = e.getColumn();
                    Order updatedValue = (Order) model.getValueAt(row, column);
//                    ClothingListController.this.clothingArrayList.add(ClothingListController.this.selectedRow, updatedValue);
//                    ClothingListController.this.clothingArrayList.remove(ClothingListController.this.selectedRow + 1);
                }

            }
        });
    }
}
