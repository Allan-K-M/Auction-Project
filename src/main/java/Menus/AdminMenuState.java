package Menus;


import model.User;

public class AdminMenuState extends  State {
    @Override
    public State start() {
        display("Welcome "+MenuData.currentUser.getFirstName()+" "+ MenuData.currentUser.getLastName());
        display("===================================\n" +
                "1. User management \n" +
                "2. Auction management \n" +
                "3. Log out \n" +
                "===================================");
        String option=read();
        if(option.equals("1")){
            return MenuData.manageUsersState.start();
        }
        if(option.equals("2")){
            return MenuData.manageAuctionsState.start();
        }
        if(option.equals("3")){
            MenuData.currentUser=null;
            return MenuData.homeMenuState.start();
        }

        display("Invalid choice");
        return start();

    }
}
