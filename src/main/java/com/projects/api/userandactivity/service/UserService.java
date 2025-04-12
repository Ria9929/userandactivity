package com.projects.api.userandactivity.service;

import com.projects.api.userandactivity.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long userId);
    User updateUser(User newUser,long userId);
    void deleteUser(long userId);
}
