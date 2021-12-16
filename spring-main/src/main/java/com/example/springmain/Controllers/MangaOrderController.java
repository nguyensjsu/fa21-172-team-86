
package com.example.springmain.Controllers;

import com.example.springmain.Models.*;
import com.example.springmain.Repositories.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;



import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class MangaOrderController {
   
    @Autowired
    private ShoppingCartRepository shoppingCartRepo ;

    @Autowired
    private CartItemRepository cartItemRepo ;

    @Autowired
    private MangaRepository mangaRepo ;

    @PostMapping("/add")
    // Quantity not added
    // localhost:8080 + "/catalog/add?mangaId=" + manga.getId() + "&email=" + "user.getEmail()" + ""
    public String addToCart(@ModelAttribute User user, @ModelAttribute Manga manga, Model model) {
        ShoppingCart cart = shoppingCartRepo.findByEmail( user.getEmail()) ;

        //Check to see if cart exists
        if(cart == null) {
            cart = new ShoppingCart(user.getEmail()) ;
            shoppingCartRepo.save(cart) ;
        }

        Manga mangas = mangaRepo.findByMangaID(Long.valueOf(manga.getMangaID())) ;
        CartItem newManga = new CartItem() ;
        newManga.setShoppingCart(cart) ;
        newManga.setManga(mangas) ;
        //newManga.setQuantity(quantity) ;
        cartItemRepo.save(newManga) ;

        log.info("Item added to cart: ", newManga) ;
        return "catalog" ;
    }

}

