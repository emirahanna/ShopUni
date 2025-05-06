package edu.psu.ist.paymentmanagement.controller;

import javax.swing.*;

public class InputValidator {
     //the dumbest of all names....
     public static boolean areFieldsFilled(JComponent parent, JTextField... fields) {
         for (JTextField field : fields) {
             if (field.getText().trim().isEmpty()) {
                 JOptionPane.showMessageDialog(parent, "Please fill in all required fields.");
                 return false;
             }
         }
         return true;
     }

    public static Integer parseInteger(JComponent parent, String input, String fieldName) {
        try {
            return Integer.parseInt(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, fieldName + " must be a valid number.");
            return null;
        }
    }

    public static Long parseLong(JComponent parent, String input, String fieldName) {
        try {
            return Long.parseLong(input.trim());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(parent, fieldName + " must be a valid number.");
            return null;
        }
    }
}
