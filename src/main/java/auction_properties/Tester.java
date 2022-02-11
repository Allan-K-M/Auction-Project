package auction_properties;

import java.util.Collection;

public class Tester {


    public static  void main(String[] agrs0) throws UserAlreadyExistsException {

        admin Allan=new admin("Allan","a123");

        String user1="Mark";
        String pass="1234";
        String fName="Mark";
        String lName="Mugo";
        String orgName="Adaptive";

        Allan.createUser(user1,pass,fName,lName,orgName);

       System.out.println(Allan.getUser("Mark").lastName);



        System.out.println(Allan.getAllOrg());




        System.out.println(Allan.getAllOrg());
        Collection<user> users=Allan.getAllUsers();
        for(user e: users){
            System.out.println(e.firstName);
            System.out.println(e.id);


        }

        Allan.blockUser("Mark");


        Allan.getAllOrgDetail();
        System.out.println();

        String user2="Richard";
        String passW="1234";
        String fiName="Richard";
        String lasName="Chongo";
        String orgaName="Adaptive";
        Allan.createUser(user2,passW,fiName,lasName,orgaName);

        Allan.getAllOrgDetail();


        user mark=Allan.getUser("Mark");



        String auctionId="auction1";
        String symbol="KSH";
        int quantity=30;
        int minCost=4;
        mark.createAuction(user1,auctionId,symbol,quantity,minCost);
        mark.createAuction(user2,auctionId,symbol,quantity,minCost);
        //mark.createAuc(userId,auctionId,symbol,quantity,minCost);
        mark.getAuctions(user1);
        mark.closeAuction(user1,auctionId);


        mark.getAuctions(user2);

        mark.openAuction(user1,auctionId);
    }
}
