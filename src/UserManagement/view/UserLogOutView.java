package UserManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserLogOutView  extends JFrame {
    public UserLogOutView() throws HeadlessException {
    }
    public void ShowLogOut() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Are you sure you want to log out? (yes/no)");
        String button = scnr.nextLine();
        if (button.equals("yes")) {
            System.out.println("You have successfully logged out.");
        }
    }
}