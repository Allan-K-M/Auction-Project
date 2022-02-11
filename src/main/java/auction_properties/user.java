package auction_properties;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class user implements user_interface{
    String userName;
    int id;
    String password;
    String firstName;
    String lastName;
    String orgName;
    enum status{
        BLOCKED,
        UNBLOCKED;

    }
    status userStatus;



    public user(String userName,int id, String password, String firstName, String lastName, String orgName){
        this.userName=userName;
        this.id=id;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.orgName=orgName;

        status userStatus = status.UNBLOCKED;

    }


    Hashtable<String, ArrayList<auction>>usersAuctions=new Hashtable<>();
    HashSet<String>auctionIds=new HashSet<>();
    @Override
    public boolean createAuction(String userId, String auctionId, String symboll, int quantity, int minPrice) {
        /*Check if valid Auction Id
        User Id is already verified through log in
        After log in the userId is stored and they will not enter it themselves
         */

        if(!auctionIds.add(auctionId)){
            System.out.println("Invalid Id");

            return false;
        }


        auction newAuction=new auction(userId,auctionId,symboll,quantity,minPrice);
        if(usersAuctions.containsKey(userId)){
            ArrayList<auction>userAuctions=usersAuctions.get(userId);

            usersAuctions.get(userId).add(newAuction);
        }
        else {
            usersAuctions.put(userId, new ArrayList<>());
            usersAuctions.get(userId).add(newAuction);
        }
        return true;
    }

    @Override
    public boolean closeAuction(String userId, String auctionId) {

        if(!usersAuctions.containsKey(userId)){
            //Throw Exception??
            System.out.println("Invalid Id!!");
            return false;
        }
        if(!auctionIds.contains(auctionId)){
            System.out.println("Invalid Auction Id");
            return false;
        }

        ArrayList<auction> currentAuctions=usersAuctions.get(userId);
        for(int i=0;i<currentAuctions.size();i++){
            auction auctionToClose=currentAuctions.get(i);
           if(currentAuctions.get(i).auctionId.equals(auctionId)) {
               auctionToClose.auctionStatus= auction.status.CLOSED;
               //auctionIds.remove(auctionId);
               System.out.println("Auction "+auctionId+" is closed");

           }
        }
        return  true;
    }

    @Override
    public boolean openAuction(String userId, String auctionId) {

        if(!usersAuctions.containsKey(userId)){
            //Throw Exception??
            System.out.println("Invalid Id!!");
            return false;
        }
        if(!auctionIds.contains(auctionId)){
            System.out.println("Invalid Auction Id");
            return false;
        }

        ArrayList<auction> currentAuctions=usersAuctions.get(userId);
        for(int i=0;i<currentAuctions.size();i++){
            auction auctionToClose=currentAuctions.get(i);
            if(currentAuctions.get(i).auctionId.equals(auctionId)) {
                auctionToClose.auctionStatus= auction.status.OPEN;
                //auctionIds.remove(auctionId);
                System.out.println("Auction "+auctionId+" is open");

            }
        }
        return  true;
    }

    @Override
    public void getAuctions(String userId) {
        if(!usersAuctions.containsKey(userId)){
            System.out.println("Invalid UserId!!");

            return;
        }
        ArrayList<auction> currentAuctions=usersAuctions.get(userId);
        for(int i=0;i<currentAuctions.size();i++){
            auction currentAuction=currentAuctions.get(i);

            String auctionId=currentAuction.auctionId;
            String  symbol=currentAuction.symbol;
            int quantity=currentAuction.quantity;

            System.out.println("Auction ID: "+auctionId+" || Symbol: "+symbol+" || Quantity:  "+quantity+" || STATUS:"+currentAuction.auctionStatus);
        }


    }
}
