package com.example.springmain.Controllers;

import com.example.springmain.Models.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
    This Controller will make API calls to the other controllers by using Rest Template.
*/

@Controller
@RequestMapping("/")
public class FrontEndController {
    
    @GetMapping("/index")
    public String homePage(Model model) {
        return "index" ;
    }

    @GetMapping("/user")
    public String customerHomePage(User user) {
        return "user" ;
    }

    @GetMapping("/register") 
    public String registerPage(User user, Model model) {

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
}