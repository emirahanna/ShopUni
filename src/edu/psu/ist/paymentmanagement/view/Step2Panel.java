package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step2Panel extends WizardStepPanel {
    private JTextField nameTextField;
    private JTextField addressTextField;
    private JButton nextButton;
    private JButton backButton;


    public Step2Panel() {

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        JLabel label = new JLabel("Step 2: Enter Payment Details");
        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        headerPanel.add(backButton);
        headerPanel.add(label);
        headerPanel.add(nextButton);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2, 2, 10, 10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        contentPanel.add(new JLabel("Full Name"));
        nameTextField = new JTextField();
        contentPanel.add(nameTextField);

        contentPanel.add(new JLabel("Billing Address"));
        addressTextField = new JTextField();
        contentPanel.add(addressTextField);


        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }


    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    @Override
    public JButton getNextButton() {
        return nextButton;
    }

    @Override
    public JButton getBackButton() {
        return backButton;
    }
}
