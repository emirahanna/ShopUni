package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step2Panel extends JPanel {
    private final JTextField nameTextField;
    private final JTextField addressTextField;
    private final JButton confirmButton;
    private final JButton backButton;


    public Step2Panel(WizardFrame frame) {

        setLayout(new BorderLayout());

        JPanel headerPanel = new JPanel();
        JLabel label = new JLabel("Step 2: Enter Payment Details");
        headerPanel.add(label);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(2,2,10,10));
        contentPanel.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        contentPanel.add(new JLabel("Full Name"));
        nameTextField = new JTextField();
        contentPanel.add(nameTextField);

        contentPanel.add(new JLabel("Billing Address"));
        addressTextField = new JTextField();
        contentPanel.add(addressTextField);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        backButton = new JButton("Back");
        confirmButton = new JButton("Confirm");

        backButton.addActionListener(e -> frame.previousStep());
        confirmButton.addActionListener(e -> {
            if(validateForm()){
                frame.nextStep();
            }
        });

        buttonPanel.add(backButton);
        buttonPanel.add(confirmButton);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private boolean validateForm(){
        if(nameTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter your full name");
            return false;
        }

        if (addressTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this, "Enter your full address");
            return false;
        }
        return true;
    }

    public JTextField getNameTextField() { return nameTextField; }
    public JTextField getAddressTextField() { return addressTextField; }
    public JButton getConfirmButton() { return confirmButton; }
    public JButton getBackButton() { return backButton; }
}
