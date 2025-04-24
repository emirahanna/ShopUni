package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step3Panel extends WizardStepPanel {

    private JButton backButton;
    private JLabel instructionLabel;
    private JLabel orderLabel;
    private JButton printReceiptButton;
    private JPanel basePanel;
    private JPanel headerPanel;
    private JPanel orderPanel;


    public Step3Panel() {
        setUpBasePanel();
        setUpHeaderPanel();
        setUpOrderPanel();
    }

    private void setUpBasePanel(){
        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());
        add(basePanel);
    }

    private void setUpHeaderPanel(){
        headerPanel = new JPanel();
        backButton = new JButton("Back");
        instructionLabel = new JLabel("Step 3: Confirm & Print Receipt");

        headerPanel.add(backButton);
        headerPanel.add(instructionLabel);

        basePanel.add(headerPanel, BorderLayout.NORTH);
    }

    private void setUpOrderPanel(){
        orderPanel = new JPanel();
        printReceiptButton = new JButton("Confirm Order");
        orderLabel = new JLabel();

        orderLabel.setPreferredSize(new Dimension(300, 100));

        orderPanel.add(orderLabel);
        orderPanel.add(printReceiptButton);

        basePanel.add(orderPanel, BorderLayout.CENTER);
    }

    @Override
    public JButton getNextButton() {
        return null;
    }

    @Override
    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getInstructionLabel() { return instructionLabel; }

    public JLabel getOrderLabel() { return orderLabel; }

    public JButton getPrintReceiptButton() { return printReceiptButton; }

    public JPanel getBasePanel() { return basePanel; }

    public JPanel getHeaderPanel() { return headerPanel; }

    public JPanel getOrderPanel() { return orderPanel; }
}

