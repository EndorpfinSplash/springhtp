package com.htp.controller;


import com.htp.controller.requests.UserCreateRequest;
import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/rest/users")
public class UserController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDao.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        User user = userDao.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<User> updateUser(@PathVariable Long id,
                                           @RequestBody UserCreateRequest userCreateRequest) {
        User user = userDao.findById(id);
        user.setUserName(userCreateRequest.getUserName());
        user.setUserSurname(userCreateRequest.getUserSurname());
        user.setBirthDate(userCreateRequest.getBirthDate()); //TODO: DEFAULT
        user.setDepartmentId(userCreateRequest.getDepartmentId());
        user = userDao.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }

    @PostMapping
    public ResponseEntity<User> saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = new User();

        user.setUserName(userCreateRequest.getUserName());
        user.setUserSurname(userCreateRequest.getUserSurname());
        user.setBirthDate(userCreateRequest.getBirthDate()); //TODO: DEFAULT
        user.setDepartmentId(userCreateRequest.getDepartmentId());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    

    @DeleteMapping
    @RequestMapping(value = "/{id}")
    public void deleteUserByID(@PathVariable Long id) {
       userDao.delete(id);
    }

    @RequestMapping(value = "/search/{name}", method = RequestMethod.GET)
    public ResponseEntity<List<User>> searchUser(@PathVariable(value = "name") String searchedName) {
        List<User> users = userDao.search(searchedName);
        return new ResponseEntity<>(users, HttpStatus.OK) ;
    }

}
