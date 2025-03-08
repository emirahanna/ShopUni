package UserManagement.view;

import javax.swing.*;
import java.awt.*;

public class AccessDeniedView  extends JFrame {
    public AccessDeniedView() throws HeadlessException {
    }
    public void ShowAccessDenied() {
        Scanner scnr = new Scanner(System.in);
        String username = scnr.nextLine();
        String password = scnr.nextLine();
        System.out.println("Access Denied for user: " + username);
        System.out.println("Please enter your password: ");
    }
    public void ShowAccessDeniedError() {
        System.out.println("Invalid password. Access Denied.");
    }
}
