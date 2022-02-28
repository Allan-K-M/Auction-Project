package Menus;

import model.AuctionManagement;
import model.User;
import model.UserManagement;

public record MenuData() {
    public static final UserManagement USER_MANAGEMENT=new UserManagement();
    public static final AuctionManagement AUCTION_MANAGEMENT=new AuctionManagement();
    public static User currentUser;

    public static final State homeMenuState=new HomeMenuState();
    public static final State loginMenuState=new LoginMenuState();
    public static final State userMenuState=new UserMenuState();
    public static final State adminMenuState=new AdminMenuState();
    public static final State exitMenuState=new ExitMenuState();
    public static final State manageUsersState=new ManageUsersState();
    public static final State manageAuctionsState=new ManageAuctionsState();

}
