package model;

public class Bid {
    private int quantity;
    private int value;
    private String auctionId;
    private String ownerId;



    public Bid(String auctionId, String ownerId, int quantity, int value) {

        if(auctionId==null){
            throw new BusinessException("Invalid Auction ID");
        }

        if(quantity==0){
            throw new BusinessException("Invalid quantity");
        }
        if(value==0){
            throw new BusinessException("Invalid Value");
        }

        this.auctionId=auctionId;
        this.value=value;
        this.quantity=quantity;
        this.ownerId=ownerId;

    }


    public String getAuctionId() {
        return auctionId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getValue() {
        return value;
    }
}
