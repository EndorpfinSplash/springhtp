package com.htp.controller.restController;

import com.htp.controller.requests.FactoryCreateRequest;
import com.htp.domain.Factory;
import com.htp.repository.FactoryDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/rest/factories", method = RequestMethod.GET)
public class FactoryRestController {

    @Autowired
    private FactoryDao factoryDao;
// Рест-контроллеры возвращают не название вьюхи а объект класса org.springframework.http.ResponseEntity
// который в дальнейшем конструируется данными из модели

//    @RequestMapping(value = "/users", method = RequestMethod.GET)
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<Factory>> getAllFactories() {
        List<Factory> factoryList = factoryDao.findAll();
        return new ResponseEntity<>(factoryList,HttpStatus.OK);
    }

    @GetMapping
    @RequestMapping(value = "/{factory_id}")
    public ResponseEntity<Factory> getFactoryById(@PathVariable (value = "factory_id") Long factory_id) {
        Factory factory = factoryDao.findById(factory_id);
        return new ResponseEntity<>(factory,HttpStatus.OK);
    }

    @PostMapping
    @RequestMapping
    public ResponseEntity<Factory> saveFactory(@RequestBody FactoryCreateRequest factoryCreateRequest) {
        Factory factory = new Factory();
        factory.setFactory_name(factoryCreateRequest.getFactory_name());
        factory.setFactory_open_year(factoryCreateRequest.getFactory_open_year());

        return new ResponseEntity<>(factory,HttpStatus.OK);
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
