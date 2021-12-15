package com.example.springfrontend;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import javax.validation.Valid;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;


@Slf4j
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
    public String registerPage(@Valid @ModelAttribute("user") User user, Model model) {

        return "register" ;
    }

    @GetMapping("/login")
    public String loginPage(@Valid @ModelAttribute("user") User user, Model model) {
        return "login" ;
    }
}
