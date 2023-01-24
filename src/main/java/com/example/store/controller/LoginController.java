package com.example.store.controller;
import com.example.store.dto.request.LoginDto;
import com.example.store.dto.response.UserResponse;
import com.example.store.entity.User;
import com.example.store.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LoginController {

    @Autowired
    private UserService service;

    @PostMapping("/user")
    public ResponseEntity<UserResponse> saveUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(new UserResponse(HttpStatus.CREATED.value(),"Created a new user",service.addUser(user)),HttpStatus.ACCEPTED);
    }

    @PostMapping("/users")
    public ResponseEntity<UserResponse> saveUsers(@Valid @RequestBody List<User> users) {
        return new ResponseEntity<>(new UserResponse(HttpStatus.ACCEPTED.value(),"Created a list of users",service.addUsers(users)),HttpStatus.ACCEPTED);
    }

    @PostMapping("/loginByEmailPass")
    public String login(@Valid @RequestBody LoginDto loginDto) {
        return service.loginrequired(loginDto);
    }

    @GetMapping("/users")
    public ResponseEntity<UserResponse> findUsers() {
        return new ResponseEntity<>(new UserResponse(HttpStatus.ACCEPTED.value(), "Displayed a list of users",service.getUsers()),HttpStatus.ACCEPTED);
    }

    @GetMapping("/userById/{id}")
    public ResponseEntity<UserResponse> findUserById(@PathVariable String id)
    {
        return new ResponseEntity<>(new UserResponse(HttpStatus.ACCEPTED.value(), "Displayed a user by using userId",service.getUserById(id)),HttpStatus.ACCEPTED);
    }

    @GetMapping("/userByName/{name}")
    public ResponseEntity<UserResponse> findUserByName(@PathVariable String name) {
        return new ResponseEntity<>(new UserResponse(HttpStatus.ACCEPTED.value(), "Displayed a user by using userName",service.getUserByName(name)),HttpStatus.ACCEPTED);

    }

    @GetMapping("/userByRole/{role}")
    public ResponseEntity<UserResponse> findUserByRole(@PathVariable String role) {
        return new ResponseEntity<>(new UserResponse(HttpStatus.ACCEPTED.value(), "Displayed a user by using userRole",service.getUserByRole(role)),HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/userDelete/{id}")
    public String deleteUserById(@PathVariable String id) {
        return service.delete(id);
    }


}
