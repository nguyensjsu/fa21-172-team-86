package com.example.springemployee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.springemployee.Repositories.CustomerRepository;
import com.example.springemployee.Repositories.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/*

An Employee will not have a registration platform, as it's purpose is to
aid the customer. We assume that their profile has been made
from another platform.

*/

@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository EmployeeRepo ;

    @Autowired
    private CustomerRepository CustomerRepo;


}
