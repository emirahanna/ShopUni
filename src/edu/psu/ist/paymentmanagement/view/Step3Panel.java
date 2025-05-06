package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step3Panel extends WizardStepPanel {

    private JButton backButton;
    private JLabel instructionLabel;
    private JLabel orderLabel;
    private JButton trackOrderButton;
    private JPanel headerPanel;
    private JPanel orderPanel;
    private JPanel buttonPanel;
    private JButton homeButton;

    public Step3Panel() {
        this.setLayout(new BorderLayout());
        setUpHeaderPanel();
        setUpOrderPanel();
        setUpTrackingButtonPanel();}

    private void setUpHeaderPanel(){
        headerPanel = new JPanel();
        instructionLabel = new JLabel("Step 3: Print Receipt");
        homeButton = new JButton("Home");
        headerPanel.add(homeButton);
        headerPanel.add(instructionLabel);
        add(headerPanel, BorderLayout.NORTH);
        headerPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
    }

    private void setUpOrderPanel(){
        orderPanel = new JPanel();
        orderLabel = new JLabel("Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.");
        orderLabel.setMaximumSize(new Dimension(300, -1));
        orderPanel.add(orderLabel);
        add(orderPanel, BorderLayout.CENTER);
    }

    private void setUpTrackingButtonPanel(){
        buttonPanel = new JPanel();
        trackOrderButton = new JButton("Track Order");
        buttonPanel.add(trackOrderButton);
        add(buttonPanel, BorderLayout.SOUTH);
    }


    @Override
    public JButton getNextButton() {
        return null;
    }


    @Override
    public JButton getBackButton() {
        return backButton;
    }

    public JButton getHomeButton() {
        return homeButton;
    }

    public JButton getTrackOrderButton() {
        return trackOrderButton;
    }

    public JLabel getOrderLabel() {
        return orderLabel;
    }
}

