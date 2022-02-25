package model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserManagementTest {


    @DisplayName("Tests the validity of a created User")
    @Test
    public void shouldThrowIfNullValueIsEnteredInCreateUser() {
        //Arrange


        //Act
        BusinessException exception0 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.createUser("Allan", "Dog1", "Allan", "Mwangi", "Adaptive", true);
        });

        BusinessException exception1 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.createUser("Allan1", null, "Allan", "Mwangi", "Adaptive", true);
        });
        BusinessException exception2 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.createUser("Allan2", "sded", null, "Mwangi", "Adaptive", true);
        });
        BusinessException exception3 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.createUser("Allan3", "Dog1", "Allan", null, "Adaptive", true);
        });
        BusinessException exception4 = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.createUser("Allan4", "Dog1", "Allan", "Mwangi", null, true);
        });

        //Assert
        assertTrue(exception0.getMessage().contains("User"));
        assertTrue(exception1.getMessage().contains("Invalid"));
        assertTrue(exception2.getMessage().contains("Invalid"));
        assertTrue(exception3.getMessage().contains("Invalid"));
        assertTrue(exception4.getMessage().contains("Invalid"));
    }

    public void testGetAllOrganisation() {
    }


    @DisplayName("Should throw Business Exception if User does not exist")
    @Test
    public void shouldReturnEmptyOptionalIfGetUserDoesNotExist() {
        //Arrange


        //Act


        //Assert
        assertTrue(TestData.ADMIN.getUser("JF").isEmpty());

    }

    @org.junit.Test
    public void testGetAllUsers() {
    }


    @DisplayName("Throws a Business Exception when uUser to be unblocked is not Found")
    @Test
    public void shouldThrowWhenUserToBeBlockedIsNotFound() {
        //Arrange
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.blockUser("JF");
        });

        assertTrue(exception.getMessage().contains("Invalid"));
        //Act

        //Assert

    }


    @DisplayName("Throws a Business Exception when uUser to be unblocked is not Found")
    @Test
    public void shouldThrowWhenUserToBeUnblockedIsNotFound() {
        //Arrange

        //Act
        BusinessException exception = assertThrows(BusinessException.class, () -> {
            TestData.ADMIN.unblockUser("JF");
        });
        //Assert

        assertTrue(exception.getMessage().contains("Invalid"));
    }

    @DisplayName("Confirms that a user is blocked")
    @Test
    public void shouldBeBlocked() {
        //Arrange

        //Act
            TestData.ADMIN.blockUser("Kyle");
            User Kyle=TestData.ADMIN.getUser("Kyle").get();
    //Assert
        assertTrue(Kyle.getUserStatus().equals(User.status.BLOCKED));

    }

    @DisplayName("Confirms that a user is Unblocked")
    @Test
    public void shouldBeUnlocked() {
        //Arrange

        //Act
        TestData.ADMIN.unblockUser("Kyle");
        User Kyle=TestData.ADMIN.getUser("Kyle").get();
        //Assert
        assertTrue(Kyle.getUserStatus().equals(User.status.UNBLOCKED));

    }
}