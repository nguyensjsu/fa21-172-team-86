package com.example.springuser.Repositories;

import com.example.springuser.Models.User;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Finding by email is more unique then finding by ID
Users can always register with the same email with different ID's
*/

public interface UserRepository extends JpaRepository <User, Long> {
    User findByEmail(String email);
}
