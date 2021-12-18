
package com.example.springmain.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Manga;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;
import com.example.springmain.Repositories.ShoppingCartRepository;
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


import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//@RequestMapping("/")
public class ShoppingCartController {


    @Autowired
    private ShoppingCartRepository shoppingCartRepo ;

    @Autowired
    private CartItemRepository cartItemRepo ;

    @Autowired
    private ShoppingCartService shoppingCartService;

    @Autowired
    private UserService userService; 

    /*
    @GetMapping
    public Integer getTotal(@ModelAttribute User user, Model model) {
        ShoppingCart cart = shoppingCartRepo.findByEmail(user.getEmail()) ;

        List<CartItem> mangas = cartItemRepo.findByShoppingCart(cart) ;
        int total = 0;
        for(CartItem manga: mangas) {
            total += manga.getQuantity() * manga.getManga().getPrice() ;
        }

        return total ;
    }
    @PostMapping("/clear")
    public String clearCart(@ModelAttribute User user, Model model) {
        //Find user's shopping cart
        ShoppingCart cart = shoppingCartRepo.findByEmail( user.getEmail()) ;

        //Get list of manga from user shopping car
        List<CartItem> manga = cartItemRepo.findByShoppingCart(cart) ;

        //Get manga id and remove from the list
        for(CartItem item : manga) {
            cartItemRepo.deleteById(item.getId());
        }

        return "catalog" ;
    }
    
    */

    //show cart and items. edit this.

    @GetMapping("/checkout")
    public String showCart(Model model
                            //,@AuthenticationPrincipal Authentication authentication
                            ){
        return "checkout";
    }

    //add Manga to check out. To do must edit
    @GetMapping("/checkout/addManga/{MangaId}")
    public String addMangaById(Model model)
    {
        
        return "Added product " + "";
    }

    //get manga by MangaId. To do must edit
    @GetMapping("/catalog/{MangaId}")
    public String getManga(Model model)
    {
        return "Manga returned: ";
    }

}