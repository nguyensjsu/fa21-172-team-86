/*
package com.example.springmain.Controllers;

import javax.validation.Valid;

import com.example.springmain.Models.User;
import com.example.springmain.Services.ShoppingCartServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class ShoppingCartController {
    @Autowired
    private ShoppingCartServices cartServices;
    
    @GetMapping("/cart")
    public String showShoppingCart(Model model, 
            @AuthenticationPrincipal Authentication authentication ){
        return "shopping_cart";
    }
<<<<<<< Updated upstream

=======
    */

    
>>>>>>> Stashed changes
    @GetMapping("/checkout")
    public String checkOut(@Valid @ModelAttribute("user") User user, Model model){
        return "checkout";
    }
}
*/