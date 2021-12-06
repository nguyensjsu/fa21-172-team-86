/*
package com.example.springmain.Controllers;

import com.example.springmain.Models.*;
import com.example.springmain.Repositories.*;

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
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.core.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/")
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
}
*/
