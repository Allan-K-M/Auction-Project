package Menus;

import model.BusinessException;
import model.User;
import model.UserManagement;

public class UserMenuState extends State{
    @Override
    public State start() {
        display("Welcome "+MenuData.currentUser.getFirstName()+" "+ MenuData.currentUser.getLastName());
        display("===================================\n" +
                "1. Auction management \n" +
                "2. Log out \n" +
                "===================================");
        String option=read();
        if(option.equals("1")){
            return MenuData.manageAuctionsState.start();
        }
        if(option.equals("2")){
            MenuData.currentUser=null;
            return MenuData.homeMenuState.start();
        }
        display("Invalid Choice ! ");
        return start();
    }
}
