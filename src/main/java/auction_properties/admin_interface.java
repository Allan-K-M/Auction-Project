package auction_properties;

import java.util.Collection;
import java.util.Set;

public interface admin_interface<E> {
    /**
    Creates a new instance of a user with all the valid input\
    assigns next available userId
     */
     public void createUser(String username, String password, String firstName, String lastName, String Organisation) throws UserAlreadyExistsException;


     /**
     returns the names of all the users
      */
     public Collection<user> getAllUsers();


     /**
     returns the names of all the organisations
      * @return
      */
     public Set<String> getAllOrg();


     public void getAllOrgDetail();

     /**
     returns the specific name vof a user based on the userId
     sort the users?
      */
     public user getUser(String  userId);


     /**
     blocks a specific user based on their id. This prevents them from accessing the auction management
     returns the name of the blocked user
     calls getUser
      */
     public String blockUser(String userId);


     /**
     unblocks the user
     returns name of the unblocked user
     calls getUser
      */
     public String unblockUser(String userId);



}
