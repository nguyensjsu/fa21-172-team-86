package com.example.springmain.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.User;
import com.example.springmain.Services.ShoppingCartServices;
import com.example.springmain.Services.UserCustomerServices;

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

    @Autowired
    private UserCustomerServices customerServices;
    /*
    @GetMapping("/cart")
    public String showShoppingCart(@Valid @ModelAttribute("user") User user, 
                                    Model model,
                                    @AuthenticationPrincipal Authentication authentication)    
    {
        List<CartItem> cartItems = cartServices.listCartItems(user);
        model.addAttribute("cartItems", cartItems)
            
        return "cart";
    }
    */
    @GetMapping("/checkout")
    public String checkOutCart(@Valid @ModelAttribute("user") User user, Model model){
        return "checkout";
    }
}