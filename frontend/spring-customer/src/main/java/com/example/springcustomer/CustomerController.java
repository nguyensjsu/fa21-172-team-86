package main.java.com.example.springcustomer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class CustomerController {

    @Autowired
    public CustomerRepository CustomerRepo ;

}

