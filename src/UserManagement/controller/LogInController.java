package UserManagement.controller;

import ProductManagement.controller.ProductListingController;
import ProductManagement.view.ProductListingView;
import UserManagement.model.UserAccount;
import UserManagement.model.UserRole;
import UserManagement.view.UserLogInView;

public class LogInController {
    UserLogInView logInView;
    private UserAccount authenticatedUser; // Stores the logged-in user


    public LogInController() {
        this.logInView = new UserLogInView();
        login();

    }

    public void login() {
        String username = logInView.getUsernameInput();
        String password = logInView.getPasswordInput();
        UserAccount user = new UserAccount(username, password);

        try {
            UserRole role = user.verifyUser();
            if (role == UserRole.BUYER) {
                logInView.displayLoginSuccess();
                authenticatedUser = user;
                new ProductListingController();
            }

        } catch (IllegalArgumentException e) {
            logInView.displayLoginFailure();
            login();
        }

    }


    public UserAccount getAuthenticatedUser() {
        return authenticatedUser;
    }

    public String getAuthUserID(){
        return authenticatedUser.getUsername();
    }
}