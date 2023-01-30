package com.example.store.service;

import com.example.store.dto.request.LoginDto;
import com.example.store.entity.ActivityHistory;
import com.example.store.entity.User;
import com.example.store.repository.AcitvityHistoryRepository;
import com.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private AcitvityHistoryRepository acitvityHistoryRepository;

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public List<User> addUsers(List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name) {
        return userRepository.findByName(name);
    }

    public List<User> getUserByRole(String role) {
        return (List<User>) userRepository.findByRole(role);
    }

    public String delete(String id) {
        userRepository.deleteById(id);
        return "deleted User" + id;
    }

    public String loginrequired(@Valid LoginDto loginDto) {
        if (userRepository.findById(loginDto.getEmail()).get().getEmail().equals(loginDto.getEmail()) && userRepository.findById(loginDto.getEmail()).get().getPassword().equals(loginDto.getPassword())) {
            acitvityHistoryRepository.save(new ActivityHistory(loginDto.getEmail(), "User Logged IN"));
            return "user logged in";
        } else {
            return "Access denied";
        }
    }


}
