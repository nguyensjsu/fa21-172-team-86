
package com.example.springmain.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Manga;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;
import com.example.springmain.Repositories.ShoppingCartRepository;
import com.example.springmain.Services.MangaService;
import com.example.springmain.Services.ShoppingCartService;
import com.example.springmain.Services.UserService;
import com.example.springmain.Models.ShoppingCart;
import com.example.springmain.Repositories.MangaRepository;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/")
public class ShoppingCartController {

    @GetMapping("/checkout")
    public String showCart(Model model) {
        //List<CartItem> cartItems = cartService

        model.addAttribute("pageTitle", "Shopping Cart");
        return "checkout";
    }

    @GetMapping("/catalog")
    public String showCatalog(Model model) {
        return "catalog";
    }
}