package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;

public class Step1Panel extends JPanel {
    public Step1Panel(WizardFrame frame) {
        JLabel label = new JLabel("Step 1: Choose Payment Type");
        JButton nextButton = new JButton("Next");

        nextButton.addActionListener(e -> frame.nextStep());

        add(label);
        add(nextButton);
    }
}
