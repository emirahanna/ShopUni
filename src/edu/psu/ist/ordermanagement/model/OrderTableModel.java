package edu.psu.ist.ordermanagement.model;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class OrderTableModel extends AbstractTableModel {
    private String[] columnNames = new String[]{"ID", "Status", "Location", "Last Updated Time"};
    private ArrayList<Order> orderList;

    public OrderTableModel() { //populate the table here
        this.orderList = OrderDAO.returnAsArrayList(); //method
    }

    public int getRowCount() {
        return this.orderList != null ? this.orderList.size() : 0;
    }

    public int getColumnCount() {
        return this.columnNames.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        Object val;
        switch (columnIndex) {
            case 0 -> val = (this.orderList.get(rowIndex)).getOrderID();
            case 1 -> val = (this.orderList.get(rowIndex)).getOrderStatusManager().getOrderStatus();
            case 2 -> val = (this.orderList.get(rowIndex)).getOrderStatusManager().getLocation();
            case 3 -> val = (this.orderList.get(rowIndex)).getOrderStatusManager().getLastUpdatedTime();
            default -> val = "Empty";
        }

        return val;
    }

    public String getColumnName(int col) {
        return this.columnNames[col];
    }

    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    public String getOrderDetails(int index){
        return orderList.get(index).getOrderItems();
    }
}
