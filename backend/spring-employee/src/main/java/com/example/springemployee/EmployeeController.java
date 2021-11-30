package main.java.com.example.springemployee;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

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
