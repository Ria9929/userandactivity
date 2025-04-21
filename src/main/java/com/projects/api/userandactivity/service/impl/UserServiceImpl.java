package com.projects.api.userandactivity.service.impl;

import com.projects.api.userandactivity.model.Watcher;
import com.projects.api.userandactivity.repository.WatcherRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.projects.api.userandactivity.model.User;
import com.projects.api.userandactivity.repository.UserRepository;
import com.projects.api.userandactivity.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepo;


    @Override
    public User saveUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    @Override
    public User getUserById(long userId) {
        Optional<User> userById= userRepo.findById(userId);
        if (userById.isPresent()){
            return userById.get();
        } else {
            throw new RuntimeException();
        }
    }

    @Override
    public User updateUser(User newUser, long userId) {
        User existingUser= userRepo.findById(userId).orElseThrow(()-> new RuntimeException());
        existingUser.setName(newUser.getName());
        existingUser.setCountryCode(newUser.getCountryCode());
        existingUser.setEmailId(newUser.getEmailId());
        existingUser.setPhoneNumber(newUser.getPhoneNumber());
        userRepo.save(existingUser);
        return existingUser;
    }

    @Override
    public void deleteUser(long userId) {
        User existingUser= userRepo.findById(userId).orElseThrow(()-> new RuntimeException());
        userRepo.deleteById(userId);
    }

    @Override
    public List<Watcher> getAssociatedWatchers(long userId) {
        User existingUser= userRepo.findById(userId).orElseThrow(()-> new RuntimeException());
        return existingUser.getWatchers();
    }
}
