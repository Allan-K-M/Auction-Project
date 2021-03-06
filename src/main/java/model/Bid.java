package model;

public class Bid {
    private int quantity;
    private Double value;
    private String auctionId;
    private String ownerId;



    public Bid(String auctionId, String ownerId, int quantity, Double value) {

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

    public Double getValue() {
        return value;
    }
}
