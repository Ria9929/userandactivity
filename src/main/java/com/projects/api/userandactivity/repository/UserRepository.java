package com.projects.api.userandactivity.repository;

import com.projects.api.userandactivity.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
