package model;

import junit.framework.TestCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class AuctionManagementTest extends TestCase {


    @DisplayName("throws Business exception if any of the input variables are null")
    @Test
    public void shouldThrowIfNullValueIsEnteredInCCreateAuction() {
        //Arrange

        TestData.ADMIN_AUCTION.createAuction("Auction0","Allan","ssh",4,34.3);


        //Act
        BusinessException exception0 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction0","Allan","ssh",4,34.3);
            //ADMIN.createUser("Allan", "Dog1", "Allan", "Mwangi", "Adaptive", true);
        });

        BusinessException exception1 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction(null,"Allan","ssh",4,34.3);
        });
        BusinessException exception2 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction2", null, "ssh", 4, 34.3);
        });
        BusinessException exception3 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction3","Allan",null,4,34.3);
        });
        BusinessException exception4 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction4","Allan","ssh",0,34.3);
        });

        NullPointerException exception5 = assertThrows(NullPointerException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction5","Allan","ssh",5,null);
        });
        BusinessException exception6 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createAuction("Auction6","Allan","ssh",5,0.0);
        });


        //Assert
        assertTrue(exception0.getMessage().contains("Already exist"));
        assertTrue(exception1.getMessage().contains("Invalid"));
        assertTrue(exception2.getMessage().contains("Invalid"));
        assertTrue(exception3.getMessage().contains("Invalid"));
        assertTrue(exception4.getMessage().contains("Invalid"));
       // assertTrue(exception5.getMessage().contains("Invalid"));
        assertTrue(exception6.getMessage().contains("Invalid"));
    }

    @Test
    public void shouldCloseAuction() {
        TestData.ADMIN_AUCTION.createAuction("Auction7","Allan","ssh",4,34.3);

        TestData.ADMIN_AUCTION.closeAuction("Allan","Auction7");
        assertTrue(TestData.ADMIN_AUCTION.getAuction("Auction7").getAuctionStatus().equals(Auction.status.CLOSED));
    }
    @Test
    public void shouldThrowIfUserCanNotCloseAuction() {
        //Arrange
        TestData.ADMIN_AUCTION.createAuction("Auction8","Allan","ssh",4,34.3);

        //Act
        BusinessException exception0=assertThrows(BusinessException.class,()->TestData.ADMIN_AUCTION.closeAuction("Kyle","Auction8"));
        BusinessException exception1=assertThrows(BusinessException.class,()->TestData.ADMIN_AUCTION.closeAuction("Allan","Auction9"));
        //Assert
        assertTrue(exception0.getMessage().contains("user can not close"));
        assertTrue(exception1.getMessage().contains("Invalid Auction ID"));
    }

    @Test
    public void shouldReturnAllUserAuctions() {
        //Arrange

        List<Auction>userAuctions=new ArrayList<>();
        Auction auction0=new Auction("AllanAuction0","Kyle","ssh",30,34.0);
        Auction auction1=new Auction("AllanAuction1","Kyle","ssh",30,34.0);
        Auction auction2=new Auction("AllanAuction2","Kyle","ssh",30,34.0);
        userAuctions.add(auction0);
        userAuctions.add(auction1);
        userAuctions.add(auction2);
        TestData.ADMIN_AUCTION.createAuction("AllanAuction0","Kyle","ssh",30,34.0);
        TestData.ADMIN_AUCTION.createAuction("AllanAuction1","Kyle","ssh",30,34.0);
        TestData.ADMIN_AUCTION.createAuction("AllanAuction2","Kyle","ssh",30,34.0);


        //Act
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getAuctionId(),(userAuctions).get(0).getAuctionId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getOwnerId(),(userAuctions).get(0).getOwnerId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getQuantity(),(userAuctions).get(0).getQuantity());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getSymbol(),(userAuctions).get(0).getSymbol());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getMinimumPrice(),(userAuctions).get(0).getMinimumPrice());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(0).getAuctionStatus(),(userAuctions).get(0).getAuctionStatus());

        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getAuctionId(),(userAuctions).get(1).getAuctionId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getOwnerId(),(userAuctions).get(1).getOwnerId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getQuantity(),(userAuctions).get(1).getQuantity());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getSymbol(),(userAuctions).get(1).getSymbol());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getMinimumPrice(),(userAuctions).get(1).getMinimumPrice());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(1).getAuctionStatus(),(userAuctions).get(1).getAuctionStatus());

        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getAuctionId(),(userAuctions).get(2).getAuctionId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getOwnerId(),(userAuctions).get(2).getOwnerId());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getQuantity(),(userAuctions).get(2).getQuantity());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getSymbol(),(userAuctions).get(2).getSymbol());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getMinimumPrice(),(userAuctions).get(2).getMinimumPrice());
        assertEquals(TestData.ADMIN_AUCTION.getAllUserAuctions("Kyle").get(2).getAuctionStatus(),(userAuctions).get(2).getAuctionStatus());

        //Assert
    }

    @Test
    public void shouldThrowIfGetAuctionIdIsInvalid() {
        //Arrange


        //Act


        //Assert
        assertThrows(BusinessException.class,()->TestData.ADMIN_AUCTION.getAuction("Dog1"));
    }

    @Test
    public void shouldThrowIfValuesEnteredInCreateBidInvalid() {
        //Arrange
        TestData.ADMIN_AUCTION.createAuction("AllanAuction100","Allan","ssh",14,34.3);

        //Act
        BusinessException exception0 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid("AllanAuction100","Allan",5,34.3);
        });
        BusinessException exception1 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid(null,"Kyle",5,34.3);
        });
        BusinessException exception2 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid("AllanAuction100",null,5,34.3);
        });
        BusinessException exception3 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid("AllanAuction100","Kyle",0,34.3);
        });

        BusinessException exception4 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid("AllanAuction100","Kyle",0,0.0);
        });

        BusinessException exception5 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN_AUCTION.createBid("AllanAuction100","Kyle",0,null);
        });
        //Assert

        assertTrue(exception0.getMessage().contains("Owner"));
        assertTrue(exception1.getMessage().contains("Invalid"));
        assertTrue(exception2.getMessage().contains("Invalid"));
        assertTrue(exception3.getMessage().contains("Invalid"));
        assertTrue(exception4.getMessage().contains("Invalid"));
        assertTrue(exception5.getMessage().contains("Invalid"));
    }

    public void testGetAllBids() {
    }

    public void testGetAllUserBids() {
    }

    public void testGetUserWonBids() {
    }

    public void testGetUserLostBids() {
    }
}