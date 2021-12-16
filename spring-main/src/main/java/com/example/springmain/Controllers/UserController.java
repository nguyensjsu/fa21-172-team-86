package com.example.springmain.Controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.UserRepository;

/*
    This controller lets the user create an account or login with their credentials.
*/

@Slf4j
@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserRepository UserRepo ;
    
    @Autowired
    private BCryptPasswordEncoder encoder;
    
    UserController(UserRepository UserRepo) {
        this.UserRepo=UserRepo ;
    }

    /*
        User registers an account

        https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/crypto/password/PasswordEncoder.html
    */
    @PostMapping("/register")
    ResponseEntity<User> registerUser(@RequestBody User user) {

        log.info( "User: " + user ) ;
        System.out.println("/register from user controller") ;

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        // Check if the email exists
        if (email != null) {
            return new ResponseEntity(user, HttpStatus.BAD_REQUEST) ;
        }

        String encodedPassword = encoder.encode( user.getPassword() );

        // Add new user to DB
        User newUser = new User() ;
        newUser.setEmail( user.getEmail() ) ;
        newUser.setFirstName( user.getFirstName() ) ;
        newUser.setLastName( user.getLastName() ) ;
        newUser.setPassword( encodedPassword ) ;
        newUser.setRole("USER") ;
        UserRepo.save(newUser) ;
        
        return new ResponseEntity(newUser, HttpStatus.OK) ;
    
    }


    /*
        User login

        Not directing to /user after logging in, but will try to fix when applying kong authentication
    */
    @PostMapping("/login")
    ResponseEntity<User> loginUser(@RequestParam("email") String email) {

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

