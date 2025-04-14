package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;

public class Step2Panel extends JPanel {
    public Step2Panel(WizardFrame frame) {
        JLabel label = new JLabel("Step 2: Enter Payment Details");
        JButton nextButton = new JButton("Next");
        JButton backButton = new JButton("Back");

        nextButton.addActionListener(e -> frame.nextStep());
        backButton.addActionListener(e -> frame.previousStep());

        add(label);
        add(backButton);
        add(nextButton);
    }
}
