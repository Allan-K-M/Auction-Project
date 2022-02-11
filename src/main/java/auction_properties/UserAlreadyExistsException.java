package auction_properties;

public class UserAlreadyExistsException extends Exception{
    public UserAlreadyExistsException(String errorMessage){
        super(errorMessage);
    }
}
