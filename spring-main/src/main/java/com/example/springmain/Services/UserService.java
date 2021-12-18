package com.example.springmain.Services;

import java.util.Optional;

import com.example.springmain.Models.Role;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    Optional<User> findByEmail(String email);

    User saveUser(User user);
    
}
