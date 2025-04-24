package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step1Panel extends JPanel {

    private final JRadioButton giftCardRadioButton;
    private final JRadioButton debitCardRadioButton;
    private final JRadioButton creditCardRadioButton;
    private final JTextField cardNumberTextField;
    private final JTextField expirationDateTextField;

    private final JButton confirmButton;
    private final ButtonGroup paymentMethodButtonGroup;

    public Step1Panel(WizardFrame frame) {
        JPanel headerPanel = new JPanel();
        JLabel label = new JLabel("Step 1: Choose Payment Type");
        headerPanel.add(label);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));

        JPanel paymentMethodPanel = new JPanel();
        paymentMethodPanel.setLayout(new GridLayout(2,2,10,10));
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

        JPanel cardInfoPanel = new JPanel();
        cardInfoPanel.setLayout(new GridLayout(2,2,10,10));
        cardInfoPanel.setBorder(BorderFactory.createTitledBorder("Card Information"));
        cardInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        cardInfoPanel.add(new JLabel("Card Number"));
        cardNumberTextField = new JTextField(15);
        cardInfoPanel.add(cardNumberTextField);

        cardInfoPanel.add(new JLabel("Expiration Date"));
        expirationDateTextField = new JTextField(5);
        cardInfoPanel.add(expirationDateTextField);

        contentPanel.add(paymentMethodPanel);
        contentPanel.add(cardInfoPanel);

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        confirmButton = new JButton("Confirm");

        confirmButton.addActionListener(e -> {
            if (validateForm()) {
                frame.nextStep();
            }
        });

        buttonPanel.add(confirmButton);

        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    private boolean validateForm(){
        if (!giftCardRadioButton.isSelected() && !creditCardRadioButton.isSelected() && !debitCardRadioButton.isSelected()){
            JOptionPane.showMessageDialog(this, "Please select a payment method");
            return false;
        }

        if(cardNumberTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter a card number");
            return false;
        }

        if(expirationDateTextField.getText().isEmpty()){
            JOptionPane.showMessageDialog(this,"Please enter an expiration date");
            return false;
        }
        return true;
    }

    public JRadioButton getGiftCardRadioButton() { return giftCardRadioButton; }
    public JRadioButton getDebitCardRadioButton() { return debitCardRadioButton; }
    public JRadioButton getCreditCardRadioButton() { return creditCardRadioButton; }
    public JTextField getCardNumberTextField() { return cardNumberTextField; }
    public JTextField getExpirationDateTextField() { return expirationDateTextField; }
    public JButton getConfirmButton() { return confirmButton; }
    public ButtonGroup getPaymentMethodButtonGroup() { return paymentMethodButtonGroup; }

}
