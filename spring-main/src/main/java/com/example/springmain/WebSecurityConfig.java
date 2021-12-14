
/*
package com.example.springmain;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.util.UrlPathHelper;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
*/
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
/*
    @Autowired
    private DataSource dataSource;

    @Bean
    public UserDetailsService userDetailsService()
    {
        return new CustomUserDetailService();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider()
    {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
        
        return authProvider;
    }

    
    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").authenticated()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                /*
                .antMatchers("/user").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/catalog").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/checkout").access( "hasAnyRole('USER','ADMIN')" )
                .antMatchers("/admin").access( "hasRole('ADMIN')" )
                .antMatchers("/reset-pw").access( "hasRole('ADMIN')" )
                */
 /*        
            .and()
                .formLogin()
                    .permitAll()
                    .loginPage("/login")
                    .defaultSuccessUrl("/user",true)
                    .usernameParameter("email")
                    //.failureForwardUrl("/fail_login")
            .and()
                .logout()
                    /*
                    .logoutSuccessHandler(new LogoutSuccessHandler(){

                        @Override
                        public void onLogoutSuccess(HttpServletRequest request,
                                                    HttpServletResponse response,
                                                    Authentication authentication) throws IOException, ServletException
                                                    {
                                                        System.out.println("User " + authentication.getName() + " has logged out.");
                                                        UrlPathHelper helper = new UrlPathHelper();
                                                        String context = helper.getContextPath(request);

                                                        response.sendRedirect(context + "/login");
                                                    }
                    })
                    */
                    /*
                    .clearAuthentication(true)
                    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                    .logoutSuccessUrl("/login")
                    .invalidateHttpSession(true) 
                    .deleteCookies("JSESSIONID")
                    .permitAll();
                    
        /*
        http.formLogin()
            .loginPage("/login.html")
            .defaultSuccessUrl("/user.html",true) 
            .usernameParameter("email") ;
        */
        /*
    }
}

*/