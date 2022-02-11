package auction_properties;

import java.util.*;

public class admin<E>implements admin_interface {
    String adminName;
    String passWord;




    public admin(String adminName, String passWord){
        this.adminName=adminName;
        this.passWord=passWord;
    }

    //List<String>orgNames=new ArrayList<>();
    HashMap<String, user> users=new HashMap<>();
    //HashSet<String>userNames=new HashSet<>();
    Hashtable<String ,ArrayList<String >>orgNames=new Hashtable<>();



    @Override
    public void createUser(String userName, String password, String firstName, String lastName, String orgName) throws UserAlreadyExistsException {

        user newUser= new user(userName,users.size(),password,firstName,lastName,orgName);

        if(users.put(userName, newUser)!=null){

            throw new UserAlreadyExistsException("User "+userName+" already exists");
        }
        else
            addOrg(orgName, firstName,lastName);
            //addUser(newUser);

    }

    private void addOrg(String orgName ,String firstName,String lastName){
        String fullName=firstName+" "+lastName;
        if(orgNames.get(orgName)==null){
            orgNames.put(orgName, new ArrayList<String>());
        }

        orgNames.get(orgName).add(fullName);

    }

    /*private void addUser(user newUser){
        users.add(newUser);

    }*/

    @Override
    public Collection<user> getAllUsers() {
        return  users.values();
    }

    @Override
    public Set<String> getAllOrg() {

        return orgNames.keySet();
    }

    @Override
    public void getAllOrgDetail() {
        System.out.println(orgNames.toString());
    }

    @Override
    public user getUser(String userId) {
        return users.get(userId);
    }

    @Override
    public String blockUser(String userId) {
        getUser(userId).userStatus= user.status.BLOCKED;
        return getUser(userId).userName+" is blocked";
    }

    //Streams java -> Collections
    @Override
    public String unblockUser(String userId) {
        getUser(userId).userStatus=user.status.UNBLOCKED;
        return getUser(userId).userName+" is unblocked";
    }
    //initialize users
    //lamda
    //command pattern
    //pattern for handling console input
}
