package com.example.bankadmin;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/admin")
@RestController
public class AdminController {
    @Autowired
    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    
    @RequestMapping("/all")
    public List<User> getAllUsers(){
        return adminService.getAllUsers();
    }
    @RequestMapping(method = RequestMethod.POST,value="/create")
    public User createUser(@RequestBody User user){
        return adminService.createUser(user);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "/delete/{id}")
    public void deleteUser(@PathVariable String id){
        adminService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT,value = "/update/{id}")
    public User updateUser(@RequestBody User user, @PathVariable String id){
        return adminService.updateUser(id, user);
    }

    
    // @RequestMapping(method = RequestMethod.PUT,value = "/update/email/{id}/{email}")
    // public User updateEmail(@PathVariable String id,@PathVariable String email){
    //     return adminService.updateEmail(id, email);
    // }
    @RequestMapping(method = RequestMethod.PUT,value = "/update/phone/{id}/{phone}")
    public User updatePhone(@PathVariable String id,@PathVariable String phone){
        return adminService.updatePhone(id, phone);
    }
}
