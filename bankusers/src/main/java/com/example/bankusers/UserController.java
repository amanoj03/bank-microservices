package com.example.bankusers;

import javax.ws.rs.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/user")
@RestController
public class UserController {
    @Autowired
    private UserServices userServices;

    public UserController(UserServices userServices) {
        this.userServices = userServices;
    }
    
    @RequestMapping(method = RequestMethod.GET,value ="/info/{id}")
    public User getInformation(@PathVariable String id){
        return userServices.getInformation(id);
    }

    @RequestMapping(method = RequestMethod.GET,value ="/balance/{id}")
    public String getBalance(@PathVariable String id){
        return userServices.getBalance(id);
    }
    @RequestMapping(method = RequestMethod.GET,value ="/name/{id}")
    public String getName(@PathVariable String id){
        return userServices.getName(id);
    }
    @RequestMapping(method = RequestMethod.PUT,value ="/deposit/{id}/{amt}")
    public User deposit(@PathVariable String id,@PathVariable String amt){
        return userServices.deposit(id, amt);
    }
    @RequestMapping(method = RequestMethod.PUT,value ="/withdrawl/{id}/{amt}")
    public User withdrawl(@PathVariable String id,@PathVariable String amt){
        return userServices.withdrawl(id, amt);
    }
}
