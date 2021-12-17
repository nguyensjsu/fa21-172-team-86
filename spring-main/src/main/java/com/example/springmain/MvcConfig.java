package com.example.springmain;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfig implements WebMvcConfigurer{
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/register").setViewName("register") ;
        registry.addViewController("/catalog").setViewName("catalog") ;
        registry.addViewController("/checkout").setViewName("checkout") ;
        registry.addViewController("/login").setViewName("login") ;
    }
}
