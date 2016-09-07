package za.co.emunicipality.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.co.emunicipality.domain.User;
import za.co.emunicipality.dto.LoginDTO;
import za.co.emunicipality.dto.UserDTO;
import za.co.emunicipality.service.UserService;

import java.util.List;

@CrossOrigin(allowedHeaders = {"*" }, origins = "*")
@RestController
@RequestMapping(value = "/users")
public class UserController {

    @Autowired
    UserService userService;

    public static Long loggedInUserId;
    public static String loggedInIdNumber;
    public static String loggedInFirstName;
    public static String loggedInSurname;
    public static String loggedInAddress;
    public static String loggedInCity;
    public static String loggedInPostalCode;
    public static String loggedInGender;
    private String loggedInEmailAddress;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public List<User> getAllUsers() {
        return userService.getAllUser();
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        userService.saveUser(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    public User loginUser;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResponseEntity<?> loginUser(@RequestBody LoginDTO login) {
        loginUser = userService.loginUser(login.getEmailAddress(),login.getPassword());
        return loginUser != null ? new ResponseEntity<>(loginUser ,HttpStatus.OK) : new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }

    @RequestMapping(value = "/getLogin", method = RequestMethod.GET)
    public ResponseEntity<?> getLoginUser() {
       return new ResponseEntity<>(loginUser ,HttpStatus.OK);
    }


    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public ResponseEntity<User> updateUser(@PathVariable("id") Long id, @RequestBody UserDTO user) {
        userService.updateUser(id,user.getEmailAddress(),user.getFirstName());
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
