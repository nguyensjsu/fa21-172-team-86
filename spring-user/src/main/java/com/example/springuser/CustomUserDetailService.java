/*

package com.example.springuser;

import com.example.springuser.Models.User;
import com.example.springuser.Repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


    https://www.baeldung.com/spring-security-authentication-with-a-database
    Tells spring security to look up user information
    In this case, I want to look up the user by email (or username)


@Service
public class CustomUserDetailService implements UserDetailsService {
    
    @Autowired
    private UserRepository userRepo;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepo.findByEmail(email) ;

        //Check to see if they exist
        if (user == null) {
            System.out.println("Email not found!") ;
            throw new UsernameNotFoundException("Email not found!") ;
        }

        return new CustomUserDetails(user) ;
    }

    
}

*/