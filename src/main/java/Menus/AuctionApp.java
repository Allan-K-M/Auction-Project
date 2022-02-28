package Menus;

public class AuctionApp {

    public AuctionApp() {

        launch();
    }
    public static State launch(){
        return new HomeMenuState();
    }
}
