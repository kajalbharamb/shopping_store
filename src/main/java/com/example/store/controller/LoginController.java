package com.example.store.controller;
import com.example.store.dto.Login;
import com.example.store.entity.User;
import com.example.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public User saveUser(@RequestBody User user) {
        return service.addUser(user);
    }

    @PostMapping("/users")
    public List<User> saveUsers(@RequestBody List<User> users) {
        return service.addUsers(users);
    }

    @GetMapping("/users")
    public List<User> findUsers() {
        return service.getUsers();
    }

    @GetMapping("/userById/{id}")
    public User findUserById(@PathVariable String id) {
        return service.getUserById(id);
    }

    @GetMapping("/userByName/{name}")
    public User findUserByName(@PathVariable String name) {
        return service.getUserByName(name);
    }

    @GetMapping("/userByRole/{role}")
    public List<User> findUserByRole(@PathVariable String role) {
        return service.getUserByRole(role);
    }

    @DeleteMapping("/userDelete/{id}")
    public String deleteUserById(@PathVariable String id) {
        return service.delete(id);
    }

    @PostMapping("/loginByEmailPass")
    public String login(@RequestBody Login login) {
        return service.loginrequired(login);
    }

}
