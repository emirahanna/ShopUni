package edu.psu.ist.paymentmanagement.view;

import edu.psu.ist.ordermanagement.model.Order;
import edu.psu.ist.trackingmanagement.controller.TrackingController;

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
        setUpHeaderPanel();
        setUpOrderPanel();
        setUpTrackingButtonPanel();}

    private void setUpHeaderPanel(){
        headerPanel = new JPanel();
        backButton = new JButton("Back");
        instructionLabel = new JLabel("Step 3: Print Receipt");
        homeButton = new JButton("Home");
        headerPanel.add(backButton);
        headerPanel.add(instructionLabel);
        headerPanel.add(homeButton);
        add(headerPanel, BorderLayout.NORTH);
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

