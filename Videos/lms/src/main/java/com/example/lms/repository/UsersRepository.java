package com.example.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.lms.model.Users;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByName(String username);
}
