/*
package com.example.springmain.Controllers;

import com.example.springmain.Models.*;
import com.example.springmain.Repositories.*;

import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

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
import org.springframework.amqp.core.Queue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/")
public class MangaOrderController {
    @Autowired
	private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @GetMapping("/catalog")
    public String getCatalog (@RequestParam(value="email") String email, @ModelAttribute("order") MangaOrder order, Model model) {
        System.out.println("Catalog");
        System.out.println("Email : " + email);
        order.setUser(email);
        model.addAttribute("email", email);
        return "catalog";
    }

    @PostMapping("/catalog")
    public String addToCart(@ModelAttribute("order") MangaOrder order, @RequestParam(value="action", required=true) String action, Model model, HttpServletRequest request) {
        log.info( "Action : " + action);
        System.out.println("Order : " + order.getUser());
        String email = order.getUser();
        System.out.println(email);

        ResponseEntity<MangaOrder> response = restTemplate.postForEntity(SPRING_MANGA_URI + "/catalog?mangaID=" + action + " ammount=" + order.getAmount(action) + " email=" + email, order, MangaOrder.class);

        return getCatalog(email, order, model);
    }


}
*/
