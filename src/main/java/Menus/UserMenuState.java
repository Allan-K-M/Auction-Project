package Menus;

import model.BusinessException;
import model.User;
import model.UserManagement;

public class UserMenuState  implements MenuStateInterface{
    MenuContext context;
    public UserMenuState(MenuContext context){
        this.context=context;
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
