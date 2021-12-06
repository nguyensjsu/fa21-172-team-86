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
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Example;
import org.springframework.amqp.annotation.RabbitListener;
import org.springframework.amqp.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
public class MangaOrderController {
    private String SPRING_PAYMENTS_URI = "http://localhost:8082";

    @Autowired
    private MangaOrderRepository mangas;
    @Autowired 
    private ShoppingCartRepository shopRepo;
    @Autowired
    private CartItemRepository itemRepo;

    public ArrayList<CartItem> getItems(ShoppingCart addCart) {
        ArrayList<CartItem> items = itemRepo.findByCart(addCart);
        return items;
    }

    public double calSubtotal(ShoppingCart addCart) {
        List<CartItem> items = itemRepo.findByCart(addCart);
        double subtotal = 0;

        for (CartItem item : items) {
            subtotal += item.getManga().getPrice() * item.getAmount();
        }

        return subtotal;
    }

    public String emptyCart(String email) {
        ShoppingCart cart = shopRepo.findByEmail(email);
        System.out.println(cart);

        ArrayList<CartItem> items = getItems(cart);
        for (CartItem item : items) {
            itemRepo.deleteById(item.getItemID());
            log.info("Deleted Item " + item.getItemID());
        }
        
        return "Cart is empty";
    }

    @Autowired
	private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RabbitListener receiver() {
        return new RabbitListener();
    }
    
    @Autowired
    private RabbitListener receiver;

    class Ping {
        private String test;

        public Ping(String msg) {
            this.test = msg;
        }

        public String getTest() {
            return this.test;
        }
    }
    
    @GetMapping("/ping")
    public Ping ping() {
        return new Ping("Spring-Manga is alive!");
    }

    // https://www.baeldung.com/spring-response-entity

    @PostMapping("/catalog")
    public ResponseEntity postAction(@RequestParam(value="mangaID") String mangaID, @RequestParam(value="amt") String amt, @RequestParam(value="email") String email) {
        log.info( "Manga ID: " + mangaID);
        log.info( "Amount: " + amt);

        ShoppingCart cart = new ShoppingCart();
        
        if(shopRepo.findByEmail(email) == null) {
            cart = new ShoppingCart(email);
            shopRepo.save(cart);
        } else {
            cart = shopRepo.findByEmail(email);
        }

        log.info("Cart ID : " + cart.getCartId());

        Manga cartManga = mangas.findByMangaID(Long.valueOf(mangaID));
        CartItem itemList = new CartItem();
        itemList.setCart(cart);
        itemList.setManga(cartManga);
        itemList.setAmount(Integer.valueOf(amt));

        itemRepo.save(itemList);

        HttpHeaders headers = new HttpHeaders();
        headers.set("status", HttpStatus.OK + "");
        System.out.println("Before set " + headers.toString());
        ResponseEntity response = new ResponseEntity(headers, HttpStatus.OK);
        System.out.println("After set " + response.getHeaders().toString());

        log.info("Cart Item: " + itemList);
        return response;
    }

    
    @GetMapping(value = "/shoppingcart")
    public ResponseEntity<ArrayList<CartItem>> getCart(@RequestParam(value="email") String email, @ModelAttribute("shoppingcart") ShoppingCart cart, Model model) {
        System.out.println("Active shopping cart!");
        ArrayList<CartItem> items = getItems(shopRepo.findByEmail(email));
        ResponseEntity<ArrayList<CartItem>> response = new ResponseEntity(items, HttpStatus.OK);
        log.info("Response: " + response.toString());

        return response;
    }

    
    @PostMapping("/shoppingcart")
    public ResponseEntity<String> postCart(@RequestParam(value="action") String action, @RequestParam(value="email") String email, Model model) {
        log.info( "Action: " + action);
        List<CartItem> items = getItems(shopRepo.findByEmail(email));
        
        if(action.equals("checkout")) {
            String subtotal = String.valueOf(calSubtotal(shopRepo.findByEmail(email)));

            ResponseEntity<String> response = restTemplate.postForEntity(SPRING_PAYMENTS_URI + "/shoppingcart?email=" + email.toString() + ",total=" + subtotal, action, String.class);
        } else if(action.equals("clear")) {
            for (CartItem item : items) {
                itemRepo.deleteById(item.getItemID());
                log.info("Removed Item " + item.getItemID());
            }
        } else {
            itemRepo.deleteById(Long.valueOf(action));
        }

        HttpHeaders headers = new HttpHeaders();
        headers.set("status", HttpStatus.OK + "");
        ResponseEntity<String> response = new ResponseEntity(headers, HttpStatus.OK);

        return response;
    }

    @Component
    public class RabbitListener {
        private RabbitTemplate rabbitTemplate;
        private RestTemplate restTemplate;

        @Bean
        public Queue hello() {
            return new Queue("confirmation");
        }

        @Autowired
        private Queue queue;
        
        @RabbitListener(queues = "confirmation")
        public void receive(String msg) throws Exception {
            System.out.println(" [X] Received: " + msg);
            System.out.println(emptyCart(msg.replaceAll("", "")));
        }

    }

}