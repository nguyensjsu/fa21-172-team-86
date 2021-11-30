package main.java.com.example.springusers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class EmployeeController {
    
    @Autowired
    private EmployeeRepository EmployeeRepo ;

    @Autowired
    private CustomerRepository CustomerRepo;


}
