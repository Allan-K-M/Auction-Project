package Menus;

import model.User;
import model.UserManagement;

import java.util.Optional;

public class LoginMenuState extends MenuContext implements MenuStateInterface {
    public LoginMenuState(){

        display("Enter a your username and Password to log in");
        var userName=userInput("Enter Your Name: ");

        UserManagement login=new UserManagement();
        Optional<User>currentUserOptional=login.getUser(userName);
        if(currentUserOptional.isPresent()){
            User currentUser=currentUserOptional.get();
            var password= userInput("Enter your password: ");
            if(currentUser.checkPassword(password)) {
                return;
            }
        }
            display("Invalid username!");
            new LoginMenuState();




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
