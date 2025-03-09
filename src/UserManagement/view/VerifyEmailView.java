package UserManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class VerifyEmailView  {
    public VerifyEmailView() {
    }
    public void ShowVerifyEmail() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter the 6-digit code sent to your email");
        String code = scnr.nextLine();
        if (code.equals("123456")) {
            System.out.println("Email verified successfully");
        } 
        else {
            System.out.println("Invalid code. Please try again.");
        }
    }
}
