package com.example.proyecto_para_testing.controller;

import com.example.proyecto_para_testing.model.User;
import com.example.proyecto_para_testing.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Repository
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private IUserService userServ;

    @PostMapping("/save")
    public void saveUser(@RequestBody User user) {
        userServ.saveUser(user);
    }

    @GetMapping("/get")
    public List<User> getUsers(){
        return userServ.getUsers();
    }

    @GetMapping("/get/{id}")
    public User findUser(@PathVariable Long id){
        return userServ.findUser(id);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteUser(@PathVariable Long id){
        userServ.deleteUser(id);
    }

    @PutMapping("/edit/{}")
    public User editUser(@PathVariable Long id, @RequestBody User user){
        userServ.editUser(id,user);
        return userServ.findUser(id);
    }
}
