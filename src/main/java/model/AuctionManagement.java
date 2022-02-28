package model;

import java.util.*;

public class AuctionManagement {

    private final List<Auction> allAuctions = new ArrayList<>();
    private final List<Bid> allBids = new ArrayList<>();

    public void createAuction(String auctionId, String ownerId, String symbol, int quantity, Double minimumPrice) {
        if (ownerId == null) {
            throw new BusinessException("Invalid User Id!");

        }
        if (auctionId == null) {
            throw new BusinessException("Invalid Aucrtion Id!");

        }
        if (symbol == null) {
            throw new BusinessException("Invalid Symbol!");

        }
        if (quantity <= 0) {
            throw new BusinessException("Invalid Quantity!");

        }
        if (minimumPrice <= 0) {
            throw new BusinessException("Invalid Minimum Cost!");

        }
        Optional<Auction> auctionAlreadyExist = allAuctions.stream().filter((auction) -> auction.getAuctionId().equals(auctionId)).findAny();
        if (auctionAlreadyExist.isPresent()) {
            throw new BusinessException("Auction Already exist");
        }
        Auction newAuction = new Auction(auctionId, ownerId, symbol, quantity, minimumPrice);
        allAuctions.add(newAuction);
    }

    public List<Bid> closeAuction(String userId, String auctionId) {
        Auction currentAuction = getAuction(auctionId);
        if (!currentAuction.getOwnerId().equals(userId)) {
            throw new BusinessException("This user can not close the auction!");
        }
        List<Bid> winningBids = setWinningBids(auctionId);
        currentAuction.setAuctionStatus(Auction.status.CLOSED);
        return winningBids;
    }

    public List<Auction> getAllUserAuctions(String userId) {
        return allAuctions.stream().filter((auction) -> auction.getOwnerId().equals(userId)).toList();
    }

    public Auction getAuction(String auctionId) {
        return allAuctions.stream().filter((Auction) -> Auction.getAuctionId().equals(auctionId)).findAny().orElseThrow(() -> new BusinessException("Invalid Auction ID"));
    }

    //do we have to consider time?
    public void createBid(String auctionId, String ownerId, int quantity, Double cost) {
        Auction currentAuction = getAuction(auctionId);
        if (currentAuction.getOwnerId().equals(ownerId)) {
            throw new BusinessException("Owner can not bid on their own auction!");
        }

        if (currentAuction.getAuctionStatus() == Auction.status.CLOSED) {
            throw new BusinessException("Auction is already closed. Can not bid!");
        }
        if (currentAuction.getQuantity() < quantity) {
            throw new BusinessException("The quantity is greater than what is available! ");
        }

        Bid newBid = new Bid(auctionId, ownerId, quantity, cost);
        allBids.add(newBid);
    }

    public List<Bid> getAllBids(String auctionId) {
        List<Bid> currentAuctionBids = allBids.stream().filter(bid -> bid.getAuctionId().equals(auctionId)).sorted(Comparator.comparing(Bid::getValue)).toList();
        return currentAuctionBids;
    }


    private List<Bid> setWinningBids(String auctionId) {
        Auction currentAuction = getAuction(auctionId);
        List<Bid> allSortedBids = getAllBids(auctionId);
        List<Bid> winningBids = new ArrayList<>();
        allSortedBids.stream().filter(bid -> bid.getAuctionId().equals(auctionId)).forEach(bid -> {
            int bidQuantity = bid.getQuantity();
            int auctionQuantity = currentAuction.getQuantity();
            if (auctionQuantity > bidQuantity) {
                currentAuction.setQuantity(auctionQuantity - bidQuantity);
                winningBids.add(bid);
            } else if (auctionQuantity > 0) {
                bid.setQuantity(auctionQuantity);
                currentAuction.setQuantity(0);
                winningBids.add(bid);
            }
        });

        return winningBids;
    }
}
