package main.java.com.example.springcustomer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
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
    public CustomerRepository CustomerRepo ;

    @PostMapping("/register")
    public String registerCustomer(@Valid @ModelAttribute("customer") Customer      customer, @RequestParam(value="action", required=true) String action, Model model) {

        
        return "register";
    }
}
