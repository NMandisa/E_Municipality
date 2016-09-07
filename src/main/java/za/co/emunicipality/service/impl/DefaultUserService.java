package za.co.emunicipality.service.impl;

import org.codehaus.groovy.runtime.StackTraceUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import za.co.emunicipality.domain.User;
import za.co.emunicipality.repository.UserRepository;
import za.co.emunicipality.service.UserService;

import java.util.List;

/**
 * Created by User on 7/28/2016.
 */
@Service
public class DefaultUserService implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User loginUser(String emailAddress, String password) {
        User user = userRepository.findByEmailAddress(emailAddress);
        return user != null && (user.getPassword().equals(password)) ? user : null;
    }

    @Override
    public User updateUser(Long userid,String emailAddress,String firstName){
        User user;
        try {
            user = userRepository.findOne(userid);
            if(user != null){user.setEmailAddress(emailAddress);
                user.setFirstName(firstName);
                userRepository.save(user);
                return user;
                }
            }
            catch (Exception ex) {
            return null;
        }
            return null;
        }
}
