package com.example.springuser;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletRequest;
import javax.sound.sampled.SourceDataLine;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserRepository UserRepo ;

    UserController(UserRepository UserRepo) {
        this.UserRepo=UserRepo ;
    }

    
    @GetMapping("/index")
    public String homePage(Model model) {
        return "index" ;
    }

    //Haven't tested yet, need to implement mysql first
    @RolesAllowed("USER", "ADMIN")
    @GetMapping("/user/index")
    public String userHomePage(Model model) {
        return "index" ;
    }

    @GetMapping("/register") 
    public String registerPage(@Valid @ModelAttribute("user") User user, Model model) {

        return "register" ;
    }

    @GetMapping("/login")
    public String loginPage(@Valid @ModelAttribute("user") User user, Model model) {
        return "login" ;
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, @RequestParam(value="action", required=true) String action, Model model) {

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        // Check if the email exists
        if (email != null) {
            System.out.println("Email already exists! Please log in to continue.") ;
            model.addAttribute("message", "Email already exists! Please log in to continue.") ;

        } else {

            // Add new user to DB
            User newUser = new User() ;
            newUser.setEmail( user.getEmail() ) ;
            newUser.setFirstName( user.getFirstName() ) ;
            newUser.setLastName( user.getLastName() ) ;
            newUser.setPassword( user.getPassword() ) ;
            newUser.setRole("User");
            UserRepo.save(newUser) ;
            
            System.out.println("Account Registered! Please log in to continue.") ;
            model.addAttribute("message", "Account Registered! Please log in to continue.") ;
        }

        return "register" ;
    }

    @PostMapping("/login")
    public String loginUser(@Valid @ModelAttribute("user") User user, @RequestParam(value="action", required=true) String action, Model model) {

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        //Check if the user is registered
        if( email == null ) {
            System.out.println("Email does not exist! Please register an account.") ;
            model.addAttribute("message", "Email does not exist! Please register an account.") ;
        
        // Need to finish this
        } else {

        }
    }
}

