package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    @DisplayName("checkPassword should return false when the password is not valid")
    @Test
    public void shouldReturnFalseIfPasswordIsNotvalid() {
        //Arrange

        //Act


        //Assert
        assertFalse(TestData.USER1.checkPassword("sfs"));

    }


    @DisplayName("checked Password should return true when the password is not valid")
    @Test
    public void shouldReturnTrueIfPasswordIsvalid() {
        //Arrange

        //Act

        //Assert
        assertTrue(TestData.USER1.checkPassword("Dog1"));


    }

}