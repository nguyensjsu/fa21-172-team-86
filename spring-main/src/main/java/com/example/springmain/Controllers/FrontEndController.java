/*
package com.example.springmain.Controllers;

import com.example.springmain.Models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class FrontEndController {

    private String USER_URI = "http://localhost:8080/users" ;
    
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/index")
    public String homePage(Model model) {
        return "index" ;
    }

    @GetMapping("/user")
    public String customerHomePage(User user) {
        return "user" ;
    }

    @GetMapping("/register") 
    public String registerPage(@ModelAttribute User user, Model model) {
        log.info("User: " + user.getEmail() + " registering") ;
        
    
        return "register" ;
    }

    @GetMapping("/login")
    public String loginPage(User user, Model model) {
        return "login" ;
    }

    @GetMapping("/catalog")
    public String catalogPage(Model model) {
        return "catalog" ;
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user, Model model) {
        log.info("User: " + user.getEmail() + " registering") ;

        ResponseEntity<User> response = restTemplate.postForEntity(USER_URI + "/register?email" + user.getEmail() + "&password=" + user.getPassword(), user, User.class) ;

        System.out.println("frontend register") ; 
        System.out.println("Printing response: " + response.toString()) ;
        System.out.println("Printing response header: " + response.getHeaders().toString()) ;
        System.out.println("Printing response body: " + response.getBody().toString()) ;
        return "register" ;
    }
}
*/