package Menus;

import model.BusinessException;
import model.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

public class ManageUsersState extends State {

    @Override
    public State start() {
        display("===================================\n" + "1. Create user \n" + "2. Show users \n" + "3. Show organisations \n" + "4. Show organisations details \n" + "5. Block/Unblock User \n" + "6. Go back \n"+"===================================");
        String option = read();

        switch (option) {
            case ("1"):
                return createUser();

            case ("2"):
                return showUsers();

            case ("3"):
                return showOrganisations();

            case ("4"):
                return showOrganosationDetails();

            case ("5"):
                return changUserStatus();

            case ("6"): return goBack();
            default:
                display("Invalid choice! ");

        }
        return start();
    }



    private State createUser() {
        String username = read("Enter desired User Name: ");
        String firstName = read("Enter User's first name: ");
        String lastName = read("Enter User's last name: ");
        String password = read("Enter the password: ");
        String organisationName = read("Enter the user's organisation: ");
        String isAdmin = read("Is the user Admin?(y/n)").toLowerCase(Locale.ROOT);
        while (!isAdmin.equals("y") && !isAdmin.equals("n")) {
            isAdmin = read("Is the user Admin?(y/n)").toLowerCase(Locale.ROOT);
        }

        try {
            switch (isAdmin) {
                case ("y"):
                    MenuData.USER_MANAGEMENT.createUser(username, password, firstName, lastName, organisationName, true);

                case ("n"):
                    MenuData.USER_MANAGEMENT.createUser(username, password, firstName, lastName, organisationName, false);
            }
        } catch (BusinessException e) {
            System.out.println("Failed to create user: " + e);
        }
        return MenuData.manageUsersState.start();

    }

    private State showUsers() {

        displayUsers();
        return MenuData.manageUsersState.start();
    }

    private State showOrganisations() {
        Set<String> allOrganisations = MenuData.USER_MANAGEMENT.getAllOrganisation();
        display("Organisations present ");
        display("===============");
        allOrganisations.stream().forEach(o -> display(o));
        display("===============");
        return MenuData.manageUsersState.start();
    }

    private State showOrganosationDetails() {
        Set<String> allOrganisations = MenuData.USER_MANAGEMENT.getAllOrganisation();
        List<User> allUsers = MenuData.USER_MANAGEMENT.getAllUsers();

        display("\n");
            allOrganisations.stream().forEach(
                    o -> {
                        display("===============");
                        display(o);
                        display("===============");
                        allUsers.stream()
                                .filter(user -> user.getOrganisationName().equals(o))
                                .map(user -> user.getFirstName() + " " + user.getLastName())
                                .forEach(name -> display(name));
                        display("\n");
                    });

        return MenuData.manageUsersState.start();
    }
    private void displayUsers(){
        List<User> allUsers = MenuData.USER_MANAGEMENT.getAllUsers();
        display("\n");
        display("========================================");
        display("First name || Last Name || UserNames || ");
        display("========================================");
        for (int i = 0; i < allUsers.size(); i++) {
            String usersNames;
            User currentUser = allUsers.get(i);
            usersNames = (currentUser.getFirstName() + " || " + currentUser.getLastName() + " || " + currentUser.getUserName() + " || ");
            display(usersNames);
        }
        display("\n");
    }

    private State changUserStatus() {
        displayUsers();
        try {
            String userName=read("Enter user Name: ");
            display("1.Block \n" +
                    "2. Unblock");
            String option=read();
            switch (option){
                case ("1"):

                    MenuData.USER_MANAGEMENT.blockUser(option);
                    display(option+" has been blocked");

                case ("2"):
                    MenuData.USER_MANAGEMENT.unblockUser(option);
                    display(option+" has been unblocked");

                default:
                    display("Invalid option");
                    changUserStatus();

                }
            } catch (BusinessException e) {
            display("User status not changed: "+e);
            return changUserStatus();
        }
        return MenuData.manageUsersState.start();
    }
    private State goBack() {
        return MenuData.adminMenuState.start();
    }
}
