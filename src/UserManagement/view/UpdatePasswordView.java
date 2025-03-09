package UserManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UpdatePasswordView  extends JFrame {
    public UpdatePasswordView() throws HeadlessException {
    }
    public void ShowUpdatePassword() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scnr.nextLine();
        System.out.println("Enter your old password");
        String oldPassword = scnr.nextLine();
        System.out.println("Enter your new password");
        String newPassword = scnr.nextLine();
        System.out.println("Re-enter your new password");
        String confirmPassword = scnr.nextLine();
    }
}
