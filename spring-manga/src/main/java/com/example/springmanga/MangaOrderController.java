package com.example.springmanga;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.validation.Errors;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Example;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class MangaOrderController {

    @Autowired
	private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Autowired
    private MangaOrderRepository mangas;

    @Autowired 
    private ShoppingCartRepository cartRepo;
    @Autowired
    private CartItemRepository itemRepo;

    private String SPRING_PAYMENTS_URI = "http://localhost:8082";

    public ArrayList<CartItem> getItems(ShoppingCart cartIn) {
        ArrayList<CartItem> items = itemRepo.findByCart(cartIn);
        return items;
    }

    public float calculateSubtotal(ShoppingCart cartIn) {
        List<CartItem> items = itemRepo.findByCart(cartIn);
        float subtotal = 0;

        for (CartItem item : items) {
            subtotal += item.getBook().getPrice() * item.getQuantity();
        }

        return subtotal;
    }

    class Ping {
        private String test;

        public Ping(String msg) {
            this.test = msg;
        }

        public String getTest() {
            return this.test;
        }
    }
    
    // For testing Kong 
    @GetMapping("/ping")
    public Ping ping() {
        return new Ping("Spring-Manga is alive!");
    }

    @PostMapping("/catalog")
    public ResponseEntity postAction(@RequestParam(value="mangaID") String mangaID,
                             @RequestParam(value="qty") String qty, @RequestParam(value="email") String email) {
        log.info( "Manga ID: " + mangaID);
        log.info( "Quantity: " + qty);
        //log.info("Cart ID: " + cart.getCartId());

        ShoppingCart cart = new ShoppingCart();
        
        if(cartRepo.findByEmail(email) == null) {
            cart = new ShoppingCart(email);
            cartRepo.save(cart);
        } else {
            cart = cartRepo.findByEmail(email);
        }

        log.info("Cart ID : " + cart.getCartId());

        Manga cartManga = mangas.findByBookID(Long.valueOf(mangaID));
        CartItem cartItem = new CartItem();
        cartItem.setCart(cart);
        cartItem.setBook(cartManga);
        cartItem.setQuantity(Integer.valueOf(qty));
        itemRepo.save(cartItem);

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("status", HttpStatus.OK + "");
        
        System.out.println("Before response creation " + responseHeaders.toString());
        ResponseEntity response = new ResponseEntity(responseHeaders, HttpStatus.OK);
        System.out.println("after response creation " + response.getHeaders().toString());

        log.info("Cart Item: " + cartItem);
        return response;
    }

    
    @GetMapping(value = "/shoppingcart")
    public ResponseEntity<ArrayList<CartItem>> getCart(@RequestParam(value="email") String email, @ModelAttribute("shoppingcart") ShoppingCart cart,
                             Model model) {
        System.out.println("Accessing shopping cart");
        
        ArrayList<CartItem> items = getItems(cartRepo.findByEmail(email));
    
        ResponseEntity<ArrayList<CartItem>> response = new ResponseEntity(items, HttpStatus.OK);
 
        log.info("Response: " + response.toString());

        return response;
    }

    
    @PostMapping("/shoppingcart")
    public ResponseEntity<String> postCart(@RequestParam(value="action") String action,
                            @RequestParam(value="email") String email, 
                            Model model) {
        
        log.info( "Action: " + action);
        List<CartItem> items = getItems(cartRepo.findByEmail(email));
        
        if(action.equals("checkout")) {
            String subtotal = String.valueOf(calculateSubtotal(cartRepo.findByEmail(email)));
            ResponseEntity<String> response = restTemplate.postForEntity(SPRING_PAYMENTS_URI + "/shoppingcart?email=" + email.toString() + "&total=" + subtotal, action, String.class);
        } else if(action.equals("clear")) {
            for (CartItem item : items) {
                itemRepo.deleteById(item.getItemID());
                log.info("Removed Item " + item.getItemID());
            }
        } else {
            itemRepo.deleteById(Long.valueOf(action));
        }

        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.set("status", HttpStatus.OK + "");
        
        ResponseEntity<String> response = new ResponseEntity(responseHeaders, HttpStatus.OK);

        return response;
    }
}