package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step3Panel extends WizardStepPanel {

    private JButton backButton;
    private JLabel instructionLabel;
    private JLabel orderLabel;
    private JButton printReceiptButton;
    private JPanel headerPanel;
    private JPanel orderPanel;

    public Step3Panel() {
        setUpHeaderPanel();
        setUpOrderPanel();    }

    private void setUpHeaderPanel(){
        headerPanel = new JPanel();
        backButton = new JButton("Back");
        instructionLabel = new JLabel("Step 3: Print Receipt");
        headerPanel.add(backButton);
        headerPanel.add(instructionLabel);
        add(headerPanel, BorderLayout.NORTH);
    }

    private void setUpOrderPanel(){
        orderPanel = new JPanel();
        orderLabel = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        orderLabel.setMaximumSize(new Dimension(300, -1));
        orderPanel.add(orderLabel);
        add(orderPanel, BorderLayout.CENTER);
    }


    @Override
    public JButton getNextButton() {
        return null;
    }


    @Override
    public JButton getBackButton() {
        return backButton;
    }

    public JLabel getOrderLabel() {
        return orderLabel;
    }
}

