package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step1Panel extends WizardStepPanel {

    private JRadioButton giftCardRadioButton;
    private JRadioButton debitCardRadioButton;
    private JRadioButton creditCardRadioButton;
    private JTextField cardNumberTextField;
    private JTextField expirationDateTextField;
    private JLabel step1BreadCrumb;
    private JLabel instructionLabel;
    private JButton backButton;
    private JButton nextButton;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel buttonPanel;
    private JPanel paymentMethodPanel;
    private JPanel cardInfoPanel;
    private JButton confirmButton;
    private ButtonGroup paymentMethodButtonGroup;

    public Step1Panel() {
        setUpHeaderPanel();
        setUpContentPanel();
        setUpButtonPanel();
        setUpFrame();
    }

    private void setUpFrame() {
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private void setUpContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        setUpCardInfoPanel();
        setUpPaymentMethodPanel();
    }

    private void setUpPaymentMethodPanel() {
        paymentMethodPanel = new JPanel();
        paymentMethodPanel.setLayout(new GridLayout(2, 2, 10, 10));
        paymentMethodPanel.setBorder(BorderFactory.createTitledBorder("Payment Method"));
        paymentMethodPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        giftCardRadioButton = new JRadioButton("Gift Card");
        creditCardRadioButton = new JRadioButton("Credit Card");
        debitCardRadioButton = new JRadioButton("Debit Card");

        paymentMethodButtonGroup = new ButtonGroup();
        paymentMethodButtonGroup.add(giftCardRadioButton);
        paymentMethodButtonGroup.add(creditCardRadioButton);
        paymentMethodButtonGroup.add(debitCardRadioButton);

        paymentMethodPanel.add(giftCardRadioButton);
        paymentMethodPanel.add(creditCardRadioButton);
        paymentMethodPanel.add(debitCardRadioButton);
        contentPanel.add(paymentMethodPanel);
    }

    private void setUpCardInfoPanel() {
        cardInfoPanel = new JPanel();
        cardInfoPanel.setLayout(new GridLayout(2, 2, 10, 10));
        cardInfoPanel.setBorder(BorderFactory.createTitledBorder("Card Information"));
        cardInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        cardInfoPanel.add(new JLabel("Card Number"));
        cardNumberTextField = new JTextField(15);
        cardInfoPanel.add(cardNumberTextField);

        cardInfoPanel.add(new JLabel("Expiration Date"));
        expirationDateTextField = new JTextField(5);
        cardInfoPanel.add(expirationDateTextField);
        contentPanel.add(cardInfoPanel);
    }

    private void setUpButtonPanel() {
        buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        confirmButton = new JButton("Confirm");
        buttonPanel.add(confirmButton);
    }

    private void setUpHeaderPanel() {
        headerPanel = new JPanel();
        nextButton = new JButton("Next");
        backButton = new JButton("Back");
        instructionLabel = new JLabel("Step 1: Choose Payment Type");
        headerPanel.add(backButton);
        headerPanel.add(instructionLabel);
        headerPanel.add(nextButton);
    }


    private boolean validateForm() {
        if (!giftCardRadioButton.isSelected() && !creditCardRadioButton.isSelected() && !debitCardRadioButton.isSelected()) {
            JOptionPane.showMessageDialog(this, "Please select a payment method");
            return false;
        }

        if (cardNumberTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter a card number");
            return false;
        }

        if (expirationDateTextField.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter an expiration date");
            return false;
        }
        return true;
    }

    public JRadioButton getGiftCardRadioButton() {
        return giftCardRadioButton;
    }

    public JRadioButton getDebitCardRadioButton() {
        return debitCardRadioButton;
    }

    public JRadioButton getCreditCardRadioButton() {
        return creditCardRadioButton;
    }

    public JTextField getCardNumberTextField() {
        return cardNumberTextField;
    }

    public JTextField getExpirationDateTextField() {
        return expirationDateTextField;
    }

    public JButton getConfirmButton() {
        return confirmButton;
    }

    public JButton getBackButton() {
        return backButton;
    }

    public JButton getNextButton() {
        return nextButton;
    }


}
