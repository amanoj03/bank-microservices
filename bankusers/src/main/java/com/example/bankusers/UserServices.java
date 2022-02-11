package com.example.bankusers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServices {
    @Autowired
    private final UserRepo userRepo;

    public UserServices(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public User getInformation(String id){
        return userRepo.findById(id).orElse(null);
    }
    
    public String getBalance(String id){
        User temp= userRepo.findById(id).orElse(null);
        return temp.getBalance();
    }

    public String getName(String id){
        User temp=userRepo.findById(id).orElse(null);
        return temp.getName();
    }
    public User deposit(String id,String amt){
        User temp=userRepo.findById(id).orElse(null);
        temp.setBalance(String.valueOf(Integer.parseInt(temp.getBalance())+Integer.parseInt(amt)));
        userRepo.save(temp);
        System.out.println(temp);
        return temp;
    }
    public User withdrawl(String id,String amt){
        User temp=userRepo.findById(id).orElse(null);
        if(Integer.parseInt(temp.getBalance())<Integer.parseInt(amt)){
            temp.setBalance(String.valueOf(0));
        }else{
            temp.setBalance(String.valueOf(Integer.parseInt(temp.getBalance())-Integer.parseInt(amt)));
        }
        userRepo.save(temp);
        return temp;
    }
}
