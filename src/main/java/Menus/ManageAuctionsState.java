package Menus;

import model.Auction;
import model.Bid;
import model.BusinessException;

import java.util.List;

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

            display(" Auction id "+auctionId+ " created successfully! ");
        } catch (BusinessException |NumberFormatException e) {
            System.out.println(" Failed to create Auction! "+e.getMessage());

        }
        return MenuData.manageAuctionsState.start();
    }

    private State seeAuctions() {
        List<Auction>allUserAuctions=MenuData.AUCTION_MANAGEMENT.getAllUserAuctions(MenuData.currentUser.getUserName());
        if(allUserAuctions.isEmpty()){
            display("You currently have no auctions! ");
            return MenuData.manageAuctionsState.start();
        }
        allUserAuctions.stream()
                .forEach(auction -> {
                    display("Auction Id || AuctionStatus || Auction Symbol || Auction Quantity ");
                    display(auction.getAuctionId()+" || "+auction.getAuctionStatus()+" || "+auction.getSymbol()+" || "+auction.getQuantity());
                    List<Bid>allAuctionsBids=MenuData.AUCTION_MANAGEMENT.getAllBids(auction.getAuctionId());
                    if(allAuctionsBids.isEmpty()){
                        display("There are no bids yet for your Auction! ");
                    }
                    allAuctionsBids.stream().forEach(
                            bid -> {
                                display("Owner Id || Price || Quantity ");
                                display(bid.getOwnerId()+" || "+bid.getValue()+" || "+bid.getQuantity());
                            }
                    );

                });

        return MenuData.manageAuctionsState.start();
    }

    private State closeAuction() {
        try {
            String userName=MenuData.currentUser.getUserName();
            String auctionId=read("Enter your Auction ID: ");
            List<Bid>winningBids=MenuData.AUCTION_MANAGEMENT.closeAuction(userName,auctionId);
            display("Auction Closed Successfully! ");
            display("============================");
            display("Owner Id || Price || Quantity ");
            winningBids.stream()
                    .forEach(bid -> {

                        display(bid.getOwnerId()+"   ||     "+bid.getValue()+"   ||     "+bid.getQuantity());
                    });
        } catch (BusinessException e) {
            display("Failed to Close Auction: "+e.getMessage());
        }
        return MenuData.manageAuctionsState.start();
    }


    private State bid() {
        try {


            String auctionId = read("Enter the Auction Id of the Auction you wish to bid on: ");
            Double price = readDouble("Enter the price you wish to bid it for: ");
            int quantity = readInt("How many would you like to purchase: ");
            MenuData.AUCTION_MANAGEMENT.createBid(auctionId, MenuData.currentUser.getUserName(), quantity, price);
        }catch (BusinessException | NumberFormatException e){
            display(" Failed to create Bid! "+e.getMessage());
        }
        return MenuData.manageAuctionsState.start();
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
