package com.example.springmain.Controllers;

import java.util.List;

import javax.validation.Valid;

import com.example.springmain.Models.CartItem;
import com.example.springmain.Models.Manga;
import com.example.springmain.Models.User;
import com.example.springmain.Repositories.CartItemRepository;
import com.example.springmain.Repositories.ShoppingCartRepository;
import com.example.springmain.Models.ShoppingCart;
import com.example.springmain.Repositories.MangaRepository;

import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
@RequestMapping("/catalog")
public class ShoppingCartController {


    @Autowired
    private MangaRepository mangaRepo ;

    @Autowired
    private ShoppingCartRepository shoppingCartRepo ;

    @Autowired
    private CartItemRepository cartItemRepo ;
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
    
    @GetMapping("/checkout")
    public String checkOutCart(User user, Model model){
        return "checkout";
    }
    */

    @PostMapping("/clear")
    ResponseEntity<String> clearCart(@RequestParam("email") String email) {
        //Find user's shopping cart
        ShoppingCart cart = shoppingCartRepo.findByEmail(email) ;

        //Get list of manga from user shopping car
        List<CartItem> manga = cartItemRepo.findByShoppingCart(cart) ;

        //Get manga id and remove from the list
        for(CartItem item : manga) {
            cartItemRepo.deleteById(item.getId());
        }

        return new ResponseEntity("Cart is cleared", HttpStatus.OK) ;
    }

    @PostMapping("/add")
    // localhost:8080 + "/catalog/add?mangaId=" + manga.getId() + "&email=" + "user.getEmail()" + ""
    ResponseEntity<CartItem> addToCart(@RequestParam("mangaId") String mangaId, @RequestParam("email") String email, @RequestParam("quantity") int quantity) {
        ShoppingCart cart = shoppingCartRepo.findByEmail(email) ;

        //Check to see if cart exists
        if(shoppingCartRepo.findByEmail(email) == null) {
            cart = new ShoppingCart(email) ;
            shoppingCartRepo.save(cart) ;
        }

        Manga manga = mangaRepo.findByMangaID(Long.valueOf(mangaId)) ;
        CartItem newManga = new CartItem() ;
        newManga.setShoppingCart(cart) ;
        newManga.setManga(manga) ;
        newManga.setQuantity(quantity) ;
        cartItemRepo.save(newManga) ;

        log.info("Item added to cart: ", newManga) ;
        return new ResponseEntity(newManga, HttpStatus.OK) ;
    }

}