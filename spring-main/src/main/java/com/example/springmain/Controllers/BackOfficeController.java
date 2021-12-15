package com.example.springmain.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.Valid;

import com.example.springmain.Models.User;
import com.example.springmain.Repositories.UserRepository;

@RequestMapping("/admin")
public class BackOfficeController {
    
    // Replace User repo with User URI that links to its database
    @Autowired 
    private UserRepository UserRepo ;
    
    @Autowired
    private BCryptPasswordEncoder encoder;

    @GetMapping("/")
    public String adminPage(User user, Model model) {
        //Check if user role is admin
        if ( !user.getRole().equals("ADMIN") ) {
            return "user";
        }
        return "admin" ;
    }

    @GetMapping("/reset-pw")
    public String resetPassword(User user, Model model) {
        //Check if user role is admin
        if ( !user.getRole().equals("ADMIN") ) {
            return "user";
        }

        return "reset-pw" ;
    }


    
    //    Admin can reset customer's password
    
    @PostMapping("/reset-pw")
    public String resetUserPassword( @ModelAttribute ("user") User user, @RequestParam(value="action", required=true) String action, Model model ) {

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        if( email == null ) {
            System.out.println("Email does not exist! Please try again.") ;
            model.addAttribute("message", "Email does not exist! Please try again.") ;
            return "reset-pw" ;
        }

        if( encoder.matches( user.getPassword(), email.getPassword() ) ) {
            System.out.println("The passwords match! Please try again.") ;
            model.addAttribute("message", "The passwords match! Please try again.") ;
            return "reset-pw" ;
        }

        email.setPassword( user.getPassword() ) ;
        UserRepo.save(email) ;

        System.out.println("Password changes!") ;
        model.addAttribute("message", "Password changed!") ;

        return "reset-pw" ;
    }

    
    //    User login

    //    Not directing to /user after logging in, but will try to fix when applying kong authentication
    
    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("user") User user, 
                            @RequestParam(value="action", required=true) 
                            String action, Model model) {

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        //Check if the user is registered
        if( email == null ) {
            System.out.println("Email does not exist! Please register an account.") ;
            model.addAttribute("message", "Email does not exist! Please register an account.") ;
            return "login" ;
        }
        //Check password
        if( !encoder.matches( user.getPassword(), email.getPassword() ) ) {
            System.out.println("Incorrect password! Please try again.") ;
            model.addAttribute("message", "Incorrect password! Please try again.") ;
            return "login" ;
        }

        if ( email.getRole().equals("ADMIN") ) {
            return "admin" ;
        }

        return "user" ;
    }

}