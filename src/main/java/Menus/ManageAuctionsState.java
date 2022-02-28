package Menus;

import model.BusinessException;

public class ManageAuctionsState extends State{
    @Override
    public State start() {
        display("===================================\n" +
                "1. Create an auction \n" +
                "2. See your auctions \n" +
                "3. Close an auction \n" +
                "4. Bid \n" +
                "5. Won bids \n" +
                "6. Lost bids \n" +
                "7. Go back \n" +
                "===================================");
        String option=read();

        switch (option){
            case("1") :return createAuction();

            case ("2"): return seeAuctions();

            case ("3"): return closeAuction();

            case ("4"): return bid();

            case("5"): return getWonBids();

            case ("6"): return getLostBids();

            case ("7"): return goback();

            default: display("Invalid choice! ");
        }

        return start();
    }

    private State createAuction() {
        try {
            display("Auction Creation");
            String symbol=read("Enter your Auction Symbol: ");
            String auctionId=read("Enter your Auction ID: ");
            int quantity=readInt("Enter your quantity: ");
            Double minimumPrice=readDouble("Enter your price: ");
            String ownerId=MenuData.currentUser.getUserName();
            MenuData.AUCTION_MANAGEMENT.createAuction(auctionId,ownerId,symbol,quantity,minimumPrice);

        } catch (BusinessException |NumberFormatException e) {
            System.out.println(" Failed to create Auction  "+e.getMessage());

        }
        return MenuData.manageAuctionsState.start();
    }

    private State seeAuctions() {

        return null;


    }

    private State closeAuction() {
        return null;
    }


    private State bid() {
        return null;
    }

    private State getWonBids() {
        return null;
    }



    private State getLostBids() {
        return null;
    }

    private State goback() {
        if(MenuData.currentUser.isAdmin()){
            return MenuData.adminMenuState.start();
        }
        return MenuData.userMenuState.start();
    }


}
