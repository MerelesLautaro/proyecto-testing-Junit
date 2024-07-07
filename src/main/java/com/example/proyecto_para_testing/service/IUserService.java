package com.example.proyecto_para_testing.service;

import com.example.proyecto_para_testing.model.User;

import java.util.List;

public interface IUserService {
    public void saveUser(User user);
    public List<User> getUsers();
    public User findUser(Long id);
    public void deleteUser(Long id);
    public void editUser(Long id, User user);
    public String login(String email, String password);
}
