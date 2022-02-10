package com.example.bankusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    
    @RequestMapping("/info/{id}")
    public User getInformation(@PathVariable String id){
        return userServices.getInformation(id);
    }

    @RequestMapping("/balance/{id}")
    public String getBalance(@PathVariable String id){
        return userServices.getBalance(id);
    }
    @RequestMapping("/name/{id}")
    public String getName(@PathVariable String id){
        return userServices.getName(id);
    }
}
