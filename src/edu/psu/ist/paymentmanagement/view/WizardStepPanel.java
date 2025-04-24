package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;

public abstract class WizardStepPanel extends JPanel {
    public abstract JButton getNextButton();
    public abstract JButton getBackButton();
}
