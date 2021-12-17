package com.example.springmain.Services;

import com.example.springmain.Models.Role;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepo;

    //Edit this
    public void setRole(User user, String role){
        user.setRole(role);
    }
    
}
