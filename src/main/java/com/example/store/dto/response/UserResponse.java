package com.example.store.dto.response;

import com.example.store.entity.User;

import java.util.List;

public class UserResponse extends ApiResponse{
    private User user;
    private List<User> users;

    public UserResponse(int statusCode, String message, User user) {
        super(statusCode, message);
        this.user = user;
    }

    public UserResponse(int statusCode, String message, List<User> users) {
        super(statusCode, message);
        this.users = users;
    }
}

