package UserManagement.view;

import java.util.Scanner;

public class UserLogInView {
    Scanner scnr;

    public UserLogInView() {
        scnr = new Scanner(System.in);
    }

    public void ShowLogInError() {
        AccessDeniedView accessDeniedView = new AccessDeniedView();
        accessDeniedView.ShowAccessDenied();
    }

    public void ForgotPassword() {
        UpdatePasswordView updatePasswordView = new UpdatePasswordView();
        updatePasswordView.ShowUpdatePassword();
    }

    public String getUsernameInput() {
        System.out.print("Enter Login: ");
        return scnr.next();
    }

    public String getPasswordInput() {
        System.out.print("Enter Password: ");
        return scnr.next();
    }

    public void displayLoginSuccess() {
        System.out.println("Login successful!");
    }

    public void displayLoginFailure() {
        System.out.println("Login failed. Incorrect username or password.");
    }

}
