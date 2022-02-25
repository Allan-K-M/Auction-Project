package Menus;

import model.BusinessException;
import model.User;
import model.UserManagement;

//Yo
public class AdminMenuState extends MenuContext implements MenuStateInterface{
    private String userName;
    private User user;
    private UserManagement adminManagement;
    public AdminMenuState(String userName){

        if (userName.equals(null)) {
            throw new BusinessException("User name can not be Null");
        }
        this.userName=userName;
        this.user= (User) adminManagement.getUser(userName).get();

        display("Welcome "+user.getFirstName()+" "+user.getLastName());
        display("==========================");
        display("1. Auction Management");
        display("2. User Management");
        display("3. Log Out");
        display("==========================");
        userInput();
    }

    @Override
    public void login() {

    }

    @Override
    public void quit() {

    }

    @Override
    public void manageUsers() {

    }

    @Override
    public void manageAuctions() {

    }

    @Override
    public void goBack() {

    }
}
