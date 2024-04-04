package com.example.Spring_mongodb.controller;

import com.example.Spring_mongodb.model.Userdetails;
import com.example.Spring_mongodb.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class Usercontroller {
    @Autowired
    private Repository userRepo;

    @PostMapping("/login")
    public String login(@RequestBody Userdetails user){
       boolean exist=false;
        for(Userdetails x:userRepo.findAll()){
            if(user.getNumber().equals(x.getNumber())){
                exist=true;
            }
        }
        if(exist==false){
            userRepo.save(user);
            return"added";
        }
        else{
            return "user already exists";

        }

    }
    @GetMapping("/display")
    public List display(){
        return userRepo.findAll();
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable String id){
        userRepo.deleteById(id);
        return "deleted";
    }
}
