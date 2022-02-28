package model;

public class Auction {
    private final String auctionId;
    private final String ownerId;
    private final String symbol;
    private final Double minimumPrice;
    private int quantity;
    private status auctionStatus;



    public Auction(String auctionId, String ownerId, String symbol, int quantity, Double minimumPrice) {


        this.auctionId=auctionId;
        this.ownerId=ownerId;
        this.symbol=symbol;
        this.quantity=quantity;
        this.minimumPrice = minimumPrice;
        auctionStatus=status.OPEN;
    }

    public String getAuctionId() {
        return auctionId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public String getSymbol() {
        return symbol;
    }

    public int getQuantity() {
        return quantity;
    }

    public Double getMinimumPrice() {
        return minimumPrice;
    }

    public status getAuctionStatus() {
        return auctionStatus;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setAuctionStatus(status auctionStatus) {
        this.auctionStatus = auctionStatus;
    }

    enum status{
        OPEN,
        CLOSED;
    }
}
