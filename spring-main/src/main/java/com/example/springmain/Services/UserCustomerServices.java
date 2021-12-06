
package com.example.springmain.Services;

import javax.transaction.Transactional;

import com.example.springmain.CustomUserDetails;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.servlet.OAuth2ClientAutoConfiguration;
import org.springframework.security.access.method.P;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserCustomerServices {
    @Autowired
    private UserRepository userRepository;

    public User getUserByEmail(String email)
    {
        return userRepository.findByEmail(email);
    }
}
