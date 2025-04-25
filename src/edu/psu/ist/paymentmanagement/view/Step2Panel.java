package edu.psu.ist.paymentmanagement.view;

import javax.swing.*;
import java.awt.*;

public class Step2Panel extends WizardStepPanel {
    private JTextField nameTextField;
    private JTextField addressTextField;
    private JButton nextButton;
    private JButton backButton;
    private JPanel basePanel;
    private JPanel textFieldPanel;
    private JPanel deliveryOptionPanel;
    private JPanel headerPanel;
    private JRadioButton deliveryRadioButton;
    private JRadioButton pickupRadioButton;
    private ButtonGroup paymentMethodButtonGroup;


    public Step2Panel() {
        setUpBasePanel();
        setUpHeaderPanel();
        setUpDeliveryOptionPanel();
        setUpInfoFieldPanel();
    }

    private void setUpBasePanel(){
        basePanel = new JPanel();
        basePanel.setLayout(new BorderLayout());;
        add(basePanel);
    }
    private void setUpHeaderPanel(){
        headerPanel = new JPanel();
        backButton = new JButton("Back");
        nextButton = new JButton("Next");
        headerPanel.add(backButton);
        headerPanel.add(new JLabel("Step 2: Enter Payment Details"));
        headerPanel.add(nextButton);
        basePanel.add(headerPanel, BorderLayout.NORTH);
    }

    private void setUpDeliveryOptionPanel(){
        deliveryOptionPanel = new JPanel();
        deliveryOptionPanel.setLayout(new GridLayout(1, 2, 10, 10));
        deliveryOptionPanel.setBorder(BorderFactory.createTitledBorder("Delivery Options"));
        deliveryOptionPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        pickupRadioButton = new JRadioButton("Pickup");
        deliveryRadioButton = new JRadioButton("Delivery");

        paymentMethodButtonGroup = new ButtonGroup();
        paymentMethodButtonGroup.add(pickupRadioButton);
        paymentMethodButtonGroup.add(deliveryRadioButton);

        deliveryOptionPanel.add(pickupRadioButton);
        deliveryOptionPanel.add(deliveryRadioButton);

        basePanel.add(deliveryOptionPanel, BorderLayout.CENTER);

    }

    private void setUpInfoFieldPanel(){
        textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new GridLayout(2, 2, 10, 10));
        textFieldPanel.setBorder(BorderFactory.createTitledBorder("Payment Information"));
        textFieldPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        textFieldPanel.add(new JLabel("Full Name"));
        nameTextField = new JTextField();
        nameTextField.setPreferredSize(new Dimension(200, 50));
        textFieldPanel.add(nameTextField);

        textFieldPanel.add(new JLabel("Billing Address"));
        addressTextField = new JTextField();
        addressTextField.setPreferredSize(new Dimension(200, 50));
        textFieldPanel.add(addressTextField);
        basePanel.add(textFieldPanel, BorderLayout.SOUTH);
    }


    public JTextField getNameTextField() {
        return nameTextField;
    }

    public JTextField getAddressTextField() {
        return addressTextField;
    }

    @Override
    public JButton getNextButton() {
        return nextButton;
    }

    @Override
    public JButton getBackButton() {
        return backButton;
    }

    public JRadioButton getDeliveryRadioButton() {
        return deliveryRadioButton;
    }

    public JRadioButton getPickupRadioButton() {
        return pickupRadioButton;
    }
}
