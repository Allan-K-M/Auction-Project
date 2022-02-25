package model;

public class Auction {
    private final String auctionId;
    private final String ownerId;
    private final String symbol;
    private final int minimumPrice;
    private int quantity;
    private status auctionStatus;



    public Auction( String auctionId,String ownerId, String symbol, int quantity, int minimumPrice) {

        if(ownerId==null){
            throw new BusinessException("Invalid User Id!");

        }
        if(auctionId==null){
            throw new BusinessException("Invalid Aucrtion Id!");

        }
        if(symbol==null){
            throw new BusinessException("Invalid Symbol!");

        }
        if(quantity<=0){
            throw new BusinessException("Invalid Quantity!");

        }
        if(minimumPrice <=0){
            throw new BusinessException("Invalid Minimum Cost!");

        }

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

    public int getMinimumPrice() {
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
