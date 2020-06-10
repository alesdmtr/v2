package com.example.demo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/")
public class controller {
    @Value("${spring.application.name}")
    String appName;

    @Autowired
    private findSeans seansService;

    @RequestMapping("/seansi")
    public List<Seans> findSeans() {
        return seansService.findAll();
    }

    @RequestMapping(value="/seansi/getSeans", method = RequestMethod.GET)
    public Seans findSeans(@RequestParam("Id") String Id) {
        return seansService.findById(Long.parseLong(Id));
    }

    @RequestMapping(value="/seansi/deleteSeans", method = RequestMethod.GET)
    public void deleteSeans(@RequestParam("Id") String Id) {
        seansService.deleteById(Long.parseLong(Id));
    }

    @RequestMapping(value = "/seansi/addseans", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity sendViaResponseEntity() {
        return new ResponseEntity(HttpStatus.NOT_IMPLEMENTED);
    }

    @PostMapping(path = "/members", consumes = "application/json", produces = "application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProfile(@Valid @RequestBody Seans seans) {
        seansService.insertSeans(seans.getName(),seans.getzal(),  seans.getseanstime());
    }

}