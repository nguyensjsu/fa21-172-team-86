/*
    This will be moved to spring-frontend (along with User and UserController)
*/


package com.example.springuser.Security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
/*    
                                *Add other templates later*

        https://docs.spring.io/spring-security/site/docs/current/api/org/springframework/security/config/annotation/web/builders/HttpSecurity.html#authorizeRequests()

        .defaultSuccessUrl(String, boolean)
            - Specifies where users will go after authenticating successfully if they have not visited a secured page prior to authenticating
            - true if the defaultSuccessUrl should be used after authentication despite if a protected page had been previously visited
*/    
    /*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService) ;
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                /*
                .antMatchers("/user").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/catalog").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/checkout").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/admin").access( "hasRole('ADMIN')" )
                .antMatchers("/reset-pw").access( "hasRole('ADMIN')" )
                */
            .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/login")
                    .defaultSuccessUrl("/user",true)
                    .usernameParameter("email")
            .and()
                .logout()
                    .logoutUrl("/logout")
                    .logoutSuccessUrl("/") ;
        /*
        http.formLogin()
            .loginPage("/login.html")
            .defaultSuccessUrl("/user.html",true) 
            .usernameParameter("email") ;
        */
    }
    /*
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring()
                .antMatchers("/index", "/login", "/register") ;
    }
    

    @Bean
    public UserDetailsService customUserDetailService(){
        return new CustomUserDetailService();
    }
    */

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
}