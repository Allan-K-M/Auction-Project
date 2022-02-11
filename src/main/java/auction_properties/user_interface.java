package auction_properties;

public interface user_interface {
    /**
     * The user can create a new auction
     * @param symboll Symboll for the item
     * @param amount quantity of the items
     * @param price cost
     * @return successfully open or not
     */
    public boolean createAuction(String userId ,String auctionID,String symboll, int amount, int price);

    public boolean closeAuction(String userId,String auctionId);

    public  boolean openAuction(String userId, String auctionId);

    public void getAuctions(String userId);



}
