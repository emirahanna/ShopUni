package UserManagement.view;

import javax.swing.*;
import java.awt.*;

public class UserLogOutView  extends JFrame {
    public UserLogOutView() throws HeadlessException {
    }
    public void ShowLogOut() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Are you sure you want to log out?");
        button = scnr.nextLine();
        if (button.clicked) {
            System.out.println("You have successfully logged out.");
        }
    }
}