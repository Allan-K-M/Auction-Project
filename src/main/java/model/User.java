package model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Hashtable;

public class User {


    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private  String organisationName;
    private  boolean isAdmin;
    private status userStatus;




    public User(String userName, String password, String firstName, String lastName, String organisationName, boolean isAdmin){


        this.userName=userName;
        this.password=password;
        this.firstName=firstName;
        this.lastName=lastName;
        this.organisationName=organisationName;
        this.isAdmin=isAdmin;
        status userStatus = status.UNBLOCKED;

    }



    public String getOrganisationName() {
        return organisationName;
    }

    private String getPassword() {
        return password;
    }
    public boolean checkPassword(String password){
        if(getPassword().equals(password)){
            return true;
        }
        else
            return false;
    }

    public String getLastName() {
        return lastName;
    }



    public void setUserStatus(status userStatus) {
        this.userStatus = userStatus;
    }

    public status getUserStatus() {
        return userStatus;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getUserName() {
        return userName;
    }

    public boolean isAdmin() {
        return isAdmin;
    }



    enum status{
        BLOCKED,
        UNBLOCKED;

    }
}
