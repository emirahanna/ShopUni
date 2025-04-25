package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.List;
import java.util.ArrayList;

public class PaymentWizardFrame extends JFrame {
    private CardLayout cardLayout;
    private JPanel basePanel;
    private List<WizardStepPanel> stepPanels;

    public PaymentWizardFrame() {
        setCardLayout();
        setView();
    }

    private void setView() {
        setTitle("ShopUni - Payment Wizard");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 800);

        setVisible(true);
    }

    private void setCardLayout() {
        cardLayout = new CardLayout();
        basePanel = new JPanel(cardLayout);
        stepPanels = new ArrayList<WizardStepPanel>();
        WizardStepPanel step1 = new Step1Panel();
        WizardStepPanel step2 = new Step2Panel();
        WizardStepPanel step3 = new Step3Panel();

        stepPanels.add(step1);
        stepPanels.add(step2);
        stepPanels.add(step3);

        basePanel.add(step1, "Step1");
        basePanel.add(step2, "Step2");
        basePanel.add(step3, "Step3");

        add(basePanel);
    }

    public void repaintNextStep() {
        cardLayout.next(basePanel);
    }

    public void repaintPreviousStep() {
        cardLayout.previous(basePanel);
    }

    public CardLayout getCardLayout() {
        return cardLayout;
    }

    public JPanel getBasePanel() {
        return basePanel;
    }

    public List<WizardStepPanel> getStepPanels() {
        return stepPanels;
    }
}
