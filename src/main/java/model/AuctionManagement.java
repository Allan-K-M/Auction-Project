package model;

import java.util.*;

public class AuctionManagement {

    private final List<Auction>allAuctions=new ArrayList<>();
    private final List<Bid>allBids=new ArrayList<>();

    public void createAuction( String auctionId,String ownerId, String symbol, int quantity, int minimumPrice) {


       Optional<Auction>auctionAlreadyExist=allAuctions.stream()
                .filter((auction)->auction.getAuctionId().equals(auctionId))
               .findAny();
       if(auctionAlreadyExist.isPresent()){
           throw new BusinessException("Auction Already exist");
       }
       Auction newAuction= new Auction(auctionId,ownerId,symbol,quantity,minimumPrice);
       allAuctions.add(newAuction);
    }

    public List<Bid>closeAuction(String userId, String auctionId) {
       Auction currentAuction= getAuction(auctionId);
       if(!currentAuction.getOwnerId().equals(userId)){
           throw new BusinessException("This user can not close the auction!");
       }
       List<Bid>winningBids= setWinningBids(auctionId);
       currentAuction.setAuctionStatus(Auction.status.CLOSED);
      return winningBids;
    }

    //return list instead of optional
    public List<Auction> getAllUserAuctions(String userId) {

        return allAuctions.stream()
                .filter((auction)->auction.getOwnerId().equals(userId))
                .toList();
    }

    public Auction getAuction(String auctionId){
        return allAuctions.stream()
                .filter((Auction)->Auction.getAuctionId().equals(auctionId))
                .findAny().orElseThrow(() -> new BusinessException("Invalid Auction ID"));
    }

    //do we have to consider time?
    public void createBid(String auctionId,String ownerId, int quantity,int cost){
        Auction currentAuction=getAuction(auctionId);
        if(currentAuction.getOwnerId().equals(ownerId)){
            throw new BusinessException("Owner can not bid on their own auction!");
        }

        if(currentAuction.getAuctionStatus()== Auction.status.CLOSED){
            throw new BusinessException("Auction is already closed. Can not bid!");
        }
        if(currentAuction.getQuantity()<quantity){
            throw new BusinessException("The quantity is greater than what is available! ");
        }

        Bid newBid=new Bid(auctionId,ownerId,quantity,cost);
        allBids.add(newBid);
    }

    public List<Bid> getAllBids(String auctionId){
        List<Bid>currentAuctionBids=allBids.stream()
                .filter(bid->bid.getAuctionId().equals(auctionId))
                .sorted(Comparator.comparing(Bid::getValue))
                .toList();
        return currentAuctionBids;
    }

    public List<Bid> setWinningBids(String auctionId){
        Auction currentAuction=getAuction(auctionId);
        List<Bid>allSortedBids=getAllBids(auctionId);
        List<Bid>winningBids=new ArrayList<>();
        //for each instead
        while (currentAuction.getQuantity()>0){
            Bid topBid=allSortedBids.remove(0);
            int bidQuantity=topBid.getQuantity();
            int previousAuctionQuantity=currentAuction.getQuantity();
            if (previousAuctionQuantity>bidQuantity) {
                currentAuction.setQuantity(previousAuctionQuantity - bidQuantity);
            }
            else {
                topBid.setQuantity(previousAuctionQuantity);
                currentAuction.setQuantity(0);
            }
            winningBids.add(topBid);
        }

        return winningBids;
    }
}
