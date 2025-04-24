package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;

public class Step3Panel extends WizardStepPanel {

    private JButton backButton;
    private JLabel instructionLabel;
    private JLabel orderLabel;
    private JButton printReceiptButton;
    public Step3Panel() {
        instructionLabel = new JLabel("Step 3: Confirm & Print Receipt");
        backButton = new JButton("Back");
        printReceiptButton = new JButton("Confirm Order");
        orderLabel = new JLabel();

        add(backButton);
        add(instructionLabel);
        add(orderLabel);
    }

    @Override
    public JButton getNextButton() {
        return null;
    }

    @Override
    public JButton getBackButton() {
        return backButton;
    }
}

