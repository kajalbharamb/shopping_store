package com.example.store.service;
import com.example.store.dto.Login;
import com.example.store.entity.User;
import com.example.store.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import java.util.List;

@Service
public class UserService {

    User user;
    @Autowired
    private UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public List<User> addUsers(List<User> users){
        return userRepository.saveAll(users);
    }

    public List<User> getUsers(){ return userRepository.findAll(); }

    public User getUserById(String id){
        return userRepository.findById(id).orElse(null);
    }

    public User getUserByName(String name){
        return userRepository.findByName(name);
    }
    public List<User> getUserByRole(String role){
        return (List<User>) userRepository.findByRole(role);
    }

    public String delete(String id){
        userRepository.deleteById(id);
        return "deleted User" +id;
    }

    public String loginrequired(Login login){
        if(  userRepository.findById(login.getEmail()).get().getEmail().equals(login.getEmail())&&userRepository.findById(login.getEmail()).get().getPassword().equals(login.getPassword())){
            return "user logged in";
        }
        else {
            return "Access denied";
        }
    }




}
