package za.co.emunicipality.service;

import za.co.emunicipality.domain.User;

import java.util.List;

/**
 * Created by NMandisa Mkhungo on 7/28/2016.
 */
public interface UserService {

    /**
     * This is a service to save a User entity
     *
     * @param user to save
     * @return a persisted User
     */
    User saveUser(User user);

    /**
     * This is a service that returns all users
     *
     * @return a list of users
     */
    List<User> getAllUser();

    User loginUser(String emailAddress,String password);

    User updateUser(Long userid,String emailAddress,String firstName);
}
