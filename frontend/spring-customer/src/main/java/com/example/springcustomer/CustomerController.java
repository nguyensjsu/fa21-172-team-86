package com.example.springcustomer;

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
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Controller
@RequestMapping("/")
public class CustomerController {
    
    @Autowired
    private CustomerRepository CustomerRepo ;

    CustomerController(CustomerRepository CustomerRepo) {
        this.CustomerRepo=CustomerRepo;
    }

    
    @GetMapping("/index")
    public String homePage(Model model) {
        return "index";
    }

    
    @GetMapping("/register") 
    public String registerPage(@Valid @ModelAttribute("customer") Customer      customer, Model model) {

        return "register";
    }

    @PostMapping("/register")
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer      customer, @RequestParam(value="action", required=true) String action, Model model) {

        Customer email = CustomerRepo.findByEmail(customer.getEmail());

        // Check if the email exists
        if (email != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "This Email already exists! Please try again.");
        } else {
            Customer newCustomer = new Customer() ;
            newCustomer.setEmail(customer.getEmail()) ;
            newCustomer.setFirstName(customer.getFirstName()) ;
            newCustomer.setLastName(customer.getLastName()) ;
            newCustomer.setPassword(customer.getPassword()) ;

            CustomerRepo.save(newCustomer) ;
            model.addAttribute("message", "Account Registered! Please log in to continue.");
        }
        
        return "register";
    }
}

