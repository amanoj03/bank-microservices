package com.example.bankadmin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired 
    private final UserRepo userRepo;

    public AdminService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }
    public List<User> getAllUsers(){
        return userRepo.findAll();
    }
    public User createUser(User user){
        return userRepo.save(user);
    }
    public void deleteUser(String id){
        userRepo.deleteById(id);
    }
    public User updateUser(String id,User user){
        User temp=userRepo.findById(id).orElse(null);
        temp.setId(user.getId());
        temp.setName(user.getName());
        temp.setAccno(user.getAccno());
        temp.setAccType(user.getAccType());
        temp.setEmail(user.getEmail());
        temp.setPhone(user.getPhone());
        temp.setBalance(user.getBalance());
        userRepo.save(temp);
        return temp;
    }
    public User updateEmail(String id,String email){
        User temp=userRepo.findById(id).orElse(null);
        temp.setEmail(email);
        userRepo.save(temp);
        return temp;
    }
    public User updatePhone(String id,String phone){
        User temp=userRepo.findById(id).orElse(null);
        temp.setPhone(phone);
        userRepo.save(temp);
        return temp;
    }
}
