package model;

import java.util.*;
import java.util.stream.Collectors;

public class UserManagement {
    private final List<User> users = new ArrayList<>();
    //Hashmap??

    public UserManagement() {
        createUser("Allan", "3r3", "Allan", "Mwangi", "Adaptive", true);
        createUser("Kyle", "3r3", "Kyle", "Tapang", "Adaptive", true);

        createUser("Mark", "Dog1", "Mark", "White", "Bank Of America", true);
        createUser("Peter", "Dog1", "Peter", "Parker", "Bank Of America", true);
        createUser("John", "Dog1", "John", "Blue", "ADP", false);

    }


    public void createUser(String userName, String password, String firstName, String lastName, String organisationName, boolean isAdmin) {
//null checkers

        if (userName == null) {
            throw new BusinessException("Invalid User Name");
        }
        if (password == null) {
            throw new BusinessException("Invalid Password");
        }
        if (firstName == null) {
            throw new BusinessException("Invalid First Name");
        }
        if (lastName == null) {
            throw new BusinessException("Invalid Last Name");
        }
        if (organisationName == null) {
            throw new BusinessException("Invalid Organisation Name");
        }

        Optional<User> userAlreadyExists = users.stream()
                .filter(User -> User.getUserName().equals(userName))
                .findAny();
        if (userAlreadyExists.isPresent()) {
            throw new BusinessException("User Already Exists!");
        } else {
            User newUser = new User(userName, password, firstName, lastName, organisationName, isAdmin);
            users.add(newUser);
        }
    }


    public Set<String> getAllOrganisation() {
        return users.stream()
                .map(User::getOrganisationName)
                .collect(Collectors.toSet());
    }


    public Optional<User> getUser(String userName) {
        return users.stream()
                .filter(User -> User.getUserName().equals(userName))
                .findAny();

    }

    //return list of all users
    public List<String> getAllUsers() {
        List<String> userNamesList = new ArrayList<>();

        for (int i = 0; i < users.size(); i++) {
            StringBuilder usersNames = new StringBuilder();
            User currentUser = users.get(i);
            usersNames.append(currentUser.getFirstName() + "  " + currentUser.getLastName() + "  " + currentUser.getUserName());
            userNamesList.add(String.valueOf(usersNames));
        }

        return userNamesList;
    }

    private boolean changeUserStatus(String userName, User.status desiredStatus) {
        Optional<User> currentUserOptional = getUser(userName);
        if (currentUserOptional.isPresent()) {
            User currentUser = currentUserOptional.get();
            currentUser.setUserStatus(desiredStatus);
            return true;
        }
        return false;
    }

    //What if user is blocked already??
    public void blockUser(String userName) {
        User.status unblocked = User.status.BLOCKED;
        if (changeUserStatus(userName, unblocked)) {
            return;
        } else {
            throw new BusinessException("Invalid User Name");
        }
    }

    public void unblockUser(String userName) {
        User.status unblocked = User.status.UNBLOCKED;
        if (changeUserStatus(userName, unblocked)) {
            return;
        } else {
            throw new BusinessException("Invalid User Name");
        }
    }
}
