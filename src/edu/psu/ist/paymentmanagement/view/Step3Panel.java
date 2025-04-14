package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;

public class Step3Panel extends JPanel {
    public Step3Panel(WizardFrame frame) {
        JLabel label = new JLabel("Step 3: Confirm & Print Receipt");
        JButton backButton = new JButton("Back");

        backButton.addActionListener(e -> frame.previousStep());

        add(label);
        add(backButton);
    }
}

