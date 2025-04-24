package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step1Panel extends WizardStepPanel {

    private JRadioButton giftCardRadioButton;
    private JRadioButton debitCardRadioButton;
    private JRadioButton creditCardRadioButton;
    private JTextField cardNumberTextField;
    private JTextField expirationDateTextField;
    private JTextField nameTextField;
    private JLabel step1BreadCrumb;
    private JLabel instructionLabel;
    private JButton backButton;
    private JButton nextButton;
    private JPanel contentPanel;
    private JPanel headerPanel;
    private JPanel paymentMethodPanel;
    private JPanel cardInfoPanel;
    private JPanel giftCardInfoPanel;
    private JButton confirmButton;
    private ButtonGroup paymentMethodButtonGroup;

    public Step1Panel() {
        setUpHeaderPanel();
        setUpContentPanel();
        setUpFrame();
    }

    private void setUpFrame() {
        add(headerPanel, BorderLayout.NORTH);
        add(contentPanel, BorderLayout.CENTER);
    }

    private void setUpContentPanel() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        setUpPaymentMethodPanel();
        setUpGiftCardInfoPanel();
        setUpCardInfoPanel();
        cardInfoPanel.setVisible(false);
    }

    private void setUpPaymentMethodPanel() {
        paymentMethodPanel = new JPanel();
        paymentMethodPanel.setLayout(new GridLayout(2, 2, 10, 10));
        paymentMethodPanel.setBorder(BorderFactory.createTitledBorder("Payment Method"));
        paymentMethodPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        giftCardRadioButton = new JRadioButton("Gift Card");
        creditCardRadioButton = new JRadioButton("Credit Card");
        debitCardRadioButton = new JRadioButton("Debit Card");

        giftCardRadioButton.setPreferredSize(new Dimension(200, 10));

        paymentMethodButtonGroup = new ButtonGroup();
        paymentMethodButtonGroup.add(giftCardRadioButton);
        paymentMethodButtonGroup.add(creditCardRadioButton);
        paymentMethodButtonGroup.add(debitCardRadioButton);

        paymentMethodPanel.add(giftCardRadioButton);
        paymentMethodPanel.add(creditCardRadioButton);
        paymentMethodPanel.add(debitCardRadioButton);
        contentPanel.add(paymentMethodPanel);
    }

    public void setUpCardInfoPanel() {
        cardInfoPanel = new JPanel();
        cardInfoPanel.setLayout(new GridLayout(3, 2, 10, 10));
        cardInfoPanel.setBorder(BorderFactory.createTitledBorder("Card Information"));
        cardInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        cardInfoPanel.add(new JLabel("Card Number"));
        cardNumberTextField = new JTextField(15);
        cardInfoPanel.add(cardNumberTextField);

        cardInfoPanel.add(new JLabel("Name"));
        nameTextField = new JTextField(15);
        cardInfoPanel.add(nameTextField);

        cardInfoPanel.add(new JLabel("Expiration Date (mmyy)"));
        expirationDateTextField = new JTextField(15);
        cardInfoPanel.add(expirationDateTextField);
        contentPanel.add(cardInfoPanel);
        cardInfoPanel.setVisible(true);
    }

    public void setUpGiftCardInfoPanel() {
        giftCardInfoPanel = new JPanel();
        giftCardInfoPanel.setLayout(new GridLayout(1, 2, 10, 10));
        giftCardInfoPanel.setBorder(BorderFactory.createTitledBorder("Card Information"));
        giftCardInfoPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        giftCardInfoPanel.add(new JLabel("Card Number"));
        cardNumberTextField = new JTextField(15);
        giftCardInfoPanel.add(cardNumberTextField);
        contentPanel.add(giftCardInfoPanel);
        giftCardInfoPanel.setVisible(true);
    }

    public void toggleGiftCardDisplay(boolean b) {
        giftCardInfoPanel.setVisible(b);
    }

    public void toggleCardDisplay(boolean b) {
        cardInfoPanel.setVisible(b);
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

    public JTextField getNameTextField() {
        return nameTextField;
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
