package UserManagement.view;

import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class UserRegisterView extends JFrame {
    public UserRegisterView() throws HeadlessException {
    }
    
    public void ShowRegister() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Create your username");
        String username = scnr.nextLine();
        System.out.println("Create your password");
        String password = scnr.nextLine();
        System.out.println("Re-enter your password");
        String confirmPassword = scnr.nextLine();
    }
    public void ShowRegisterSuccess() {
        System.out.println("Registration successful");
    }

    public void ShowRegisterErrorUsername() {
        System.out.println("Username already exists");
    }

    public void ShowRegisterErrorPassword() {
        System.out.println("Passwords do not match");
    }

}
