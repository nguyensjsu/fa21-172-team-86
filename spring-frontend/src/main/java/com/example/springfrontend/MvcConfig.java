package com.example.springemployee;
<<<<<<< Updated upstream:backend/spring-employee/src/main/java/com/example/springemployee/MvcConfig.java
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.context.annotation.Configuration;
=======

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
>>>>>>> Stashed changes:spring-frontend/src/main/java/com/example/springfrontend/MvcConfig.java

@Configuration
public class MvcConfig implements WebMvcConfigurer {
    
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/login").setViewName("login");
    }
}
