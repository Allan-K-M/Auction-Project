package Menus;

import model.User;
import model.UserManagement;

import java.util.Optional;

public class LoginMenuState extends State {

    @Override
    public State start() {

        String userName = read("Enter your User name: ");
        String password = read("Enter your password: ");
        Optional<User> currentUserOptional = MenuData.USER_MANAGEMENT.getUser(userName);
        if (currentUserOptional.isEmpty() || !currentUserOptional.get().checkPassword(password)) {
            display("Invalid User Name or password! ");
            String proceed = read("Enter 1 to retry or 2 to Exit: ");
            if (proceed.equals("2")) {
                return MenuData.exitMenuState.start();
            }
            return start();
        }

        MenuData.currentUser = currentUserOptional.get();

        if (currentUserOptional.get().isAdmin()) {
            return MenuData.adminMenuState.start();
        }
        return MenuData.userMenuState.start();
    }
}
