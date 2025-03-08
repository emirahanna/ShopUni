package UserManagement.view;

import javax.swing.*;
import java.awt.*;

public class UserLogInView extends JFrame {
    public UserLogInView() throws HeadlessException {
    }
    public void ShowLogIn() {
        Scanner scnr = new Scanner(System.in);
        System.out.println("Enter your username");
        String username = scnr.nextLine();
        System.out.println("Enter your password");
        String password = scnr.nextLine();
    }

    public void ShowLogInError() {
        AccessDeniedView accessDeniedView = new AccessDeniedView();
        accessDeniedView.ShowAccessDenied();
    }

    public void ForgotPassword() {
        UpdatePasswordView updatePasswordView = new UpdatePasswordView();
        updatePasswordView.ShowUpdatePassword();
    }
    
}
