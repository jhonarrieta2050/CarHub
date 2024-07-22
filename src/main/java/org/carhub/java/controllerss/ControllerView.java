package org.carhub.java.controllerss;


import org.carhub.java.modelUser.User;
import org.carhub.java.view.AccountManagement;
import org.carhub.java.view.Home;

public class ControllerView {
    private static final AccountManagement accountManagement = new AccountManagement();
    private  static  final Home home = new Home();
    private static User user;

    public static void showView() {
        user = accountManagement.accountManagement();
        home.home(user);
    }

    public static void home(User user) {
        home.home(user);
    }


}
