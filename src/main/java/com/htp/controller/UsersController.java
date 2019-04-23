package com.htp.controller;

import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping(value = "/users", method = RequestMethod.GET)
public class UsersController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/user", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getUser(@RequestParam("name") String name, ModelMap model) {
        model.addAttribute("usersList", userDao.search(name));
        return "user";
    }


//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getAllUsers(ModelMap model) {
        model.addAttribute("usersList",
                userDao.findAll());
        return "user";
    }
    @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
    public String createUser(Model model) {
        model.addAttribute("user", new User());
        return "user/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUserFromForm(User user) {
        user = userDao.save(user);
        return "redirect:/users/user?user_id=" + user.getUserId();
    }

    @RequestMapping(value = "/user", params = "user_id")
    public String getUserById(@RequestParam("user_id") Long user_id, ModelMap modelMap) {
        modelMap.addAttribute("usersList",
                Collections.singletonList(userDao.findById(user_id))
        );
        return "user";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.GET, params = "user_id")
    public String editUser(@RequestParam ("user_id") Long user_id, Model model) {
        model.addAttribute("user", userDao.findById(user_id));
        return "user/edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUserFromForm(User user) {
        userDao.update(user);
        return "redirect:/users/";
    }
    /*    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUserFromForm(User user) {
        userDao.update(user);
        return "redirect:/users";
    }*/

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(@RequestParam ("user_id") Long user_id) {
        userDao.delete(user_id);
        return "redirect:/users";
    }

}
