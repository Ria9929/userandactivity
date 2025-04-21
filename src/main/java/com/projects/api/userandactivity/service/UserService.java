package com.projects.api.userandactivity.service;

import com.projects.api.userandactivity.model.User;
import com.projects.api.userandactivity.model.Watcher;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserService {
    User saveUser(User user);
    List<User> getAllUsers();
    User getUserById(long userId);
    User updateUser(User newUser,long userId);
    void deleteUser(long userId);
    List<Watcher> getAssociatedWatchers(long userId);
}
