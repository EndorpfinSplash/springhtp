package com.htp.controller;

import com.htp.domain.User;
import com.htp.repository.UserDao;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class HelloController {

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = {"/home","/hello"}, method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String printHello(ModelMap model) {
        model.addAttribute("message", "Hello Spring MVC Framework!");
        return "hello";
    }

    @RequestMapping(value = "/user/search", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String printHello(@RequestParam("query") String query, ModelMap model) {
        List<User> search = userDao.search(query);
        model.addAttribute("userName",
                StringUtils.join(search.stream().map(User::getUserName).collect(Collectors.toList()), ","));

        model.addAttribute("usersList",
                userDao.findAll());

        return "home";
    }
}
