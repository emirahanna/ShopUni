package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class WizardFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private int currentStep = 0;

    public WizardFrame() {
        setTitle("Payment Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 300);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        cardPanel.add(new Step1Panel(this), "Step1");
        cardPanel.add(new Step2Panel(this), "Step2");
        cardPanel.add(new Step3Panel(this), "Step3");

        add(cardPanel);
        setVisible(true);
    }

    public void nextStep() {
        currentStep++;
        cardLayout.next(cardPanel);
    }

    public void previousStep() {
        if (currentStep > 0) {
            currentStep--;
            cardLayout.previous(cardPanel);
        }
    }
}
