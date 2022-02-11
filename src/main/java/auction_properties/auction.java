package auction_properties;

public class auction {
    String userId;
    String symbol;
    int quantity;
    int minCost;

    enum status{
        OPEN,
        CLOSED;
    }
    status auctionStatus;


    String auctionId;


    public auction(String userId,String auctionId, String symbol, int quantity, int minCost) {
        this.userId=userId;
        this.symbol=symbol;
        this.quantity=quantity;
        this.minCost=minCost;
        this.auctionId=auctionId;
        auctionStatus=status.OPEN;
    }
}
