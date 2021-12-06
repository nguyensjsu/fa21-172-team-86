package com.example.springuser.Controllers;

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

import com.example.springuser.Models.User;
import com.example.springuser.Repositories.UserRepository;


@Slf4j
@Controller
@RequestMapping("/")
public class UserController {
    
    @Autowired
    private UserRepository UserRepo ;

    @Autowired
    private BCryptPasswordEncoder encoder ;

    UserController(UserRepository UserRepo) {
        this.UserRepo=UserRepo ;
    }

    
    @GetMapping("/index")
    public String homePage(Model model) {
        return "index" ;
    }

  
    //Haven't tested yet, need to implement mysql first
    @GetMapping("/user")
    public String customerHomePage(User user) {
        return "user" ;
    }

    @GetMapping("/register") 
    public String registerPage(@Valid @ModelAttribute("user") User user, Model model) {

        return "register" ;
    }

    @GetMapping("/login")
    public String loginPage(@Valid @ModelAttribute("user") User user, Model model) {
        return "login" ;
    }


    /*
        User registers an account

        https://docs.spring.io/spring-security/site/docs/4.2.4.RELEASE/apidocs/org/springframework/security/crypto/password/PasswordEncoder.html
    */
    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("user") User user, 
                                @RequestParam(value="action", required=true) String action, Model model) {


        log.info( "Action: " + action ) ;
        log.info( "User: " + user ) ;

        User email = UserRepo.findByEmail( user.getEmail() ) ;

        // Check if the email exists
        if (email != null) {
            System.out.println("Email already exists! Please log in to continue.") ;
            model.addAttribute("message", "Email already exists! Please log in to continue.") ;

        } else {

            String encodedPassword = encoder.encode( user.getPassword() );

            // Add new user to DB
            User newUser = new User() ;
            newUser.setEmail( user.getEmail() ) ;
            newUser.setFirstName( user.getFirstName() ) ;
            newUser.setLastName( user.getLastName() ) ;
            newUser.setPassword( encodedPassword ) ;
            newUser.setRole("USER") ;
            UserRepo.save(newUser) ;
            
            System.out.println("Account Registered! Please log in to continue.") ;
            model.addAttribute("message", "Account Registered! Please log in to continue.") ;
        }

        return "register" ;
    }


    /*
        User login

        Not directing to /user after logging in, but will try to fix when applying kong authentication
    */
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

