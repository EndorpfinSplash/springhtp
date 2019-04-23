package com.htp.controller.restController;


import com.htp.controller.requests.UserCreateRequest;
import com.htp.domain.Role;
import com.htp.domain.User;
import com.htp.repository.RoleDao;
import com.htp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value = "/rest/users")
public class UserRestController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private RoleDao roleDao;

    @GetMapping // =  method = RequestMethod.GET
    @RequestMapping(value = "/")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userDao.findAll();
        return new ResponseEntity<>(users, HttpStatus.OK) ;
    }

    @PutMapping
    @RequestMapping(value = "/")
    public ResponseEntity<List<User>> updateUsers(@RequestBody List<User> users) {
        List<Long> usersId = userDao.batchUpdate(users);
       // List<User> userList = usersId.stream().forEach(id -> userDao.findById(id)).collect(Coll);
        return new ResponseEntity<>(users, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUserByID(@PathVariable Long id) {
        User user = userDao.findById(id);
        return new ResponseEntity<>(user, HttpStatus.OK) ;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
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
    @Transactional
    public ResponseEntity<User> saveUser(@RequestBody UserCreateRequest userCreateRequest) {
        User user = new User();

        user.setUserName(userCreateRequest.getUserName());
        user.setUserSurname(userCreateRequest.getUserSurname());
        user.setBirthDate(userCreateRequest.getBirthDate());
        user.setDepartmentId(userCreateRequest.getDepartmentId());
        userDao.save(user);
        roleDao.save(new Role(user.getUserId(), "ROLE_USER"));
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
