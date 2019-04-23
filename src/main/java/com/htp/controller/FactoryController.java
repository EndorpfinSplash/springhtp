package com.htp.controller;

import com.htp.domain.Factory;
import com.htp.domain.User;
import com.htp.repository.FactoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping(value = "/factories", method = RequestMethod.GET)
public class FactoryController {

    @Autowired
    private FactoryDao factoryDao;


//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @RequestMapping(method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public String getAllFactories(Model model) {
        model.addAttribute("factoriesList",
                factoryDao.findAll());
        return "factories";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.GET, params = "factory_id")
    public String editUser(@RequestParam ("factory_id") Long factory_id, Model model) {
        model.addAttribute("factory", factoryDao.findById(factory_id));
        return "factory/edit";
    }

  @RequestMapping(value = "/create", method = RequestMethod.GET, params = "new")
    public String createUser(Model model) {
        model.addAttribute("factory", new Factory());
        return "factory/create";
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public String saveUserFromForm(Factory factory) {
        factoryDao.save(factory);
        return "redirect:/factories";
    }


    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String updateUserFromForm(Factory factory) {
        factoryDao.update(factory);
        return "redirect:/factories";
    }


    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteFactory(@RequestParam ("factory_id") Long factory_id) {
        factoryDao.delete(factory_id);
        return "redirect:/factories";
    }
}
