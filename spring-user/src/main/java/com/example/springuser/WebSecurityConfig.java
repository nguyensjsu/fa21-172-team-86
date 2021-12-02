/*
    This will be moved to spring-frontend (along with User and UserController)
*/


package main.java.com.example.springuser;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.Configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
    //Not done yet
    @Override
    protected void configureAuth(final AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().passwordEncoder( passwordEncoder() )
            . dataSource()
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http
            .authorizeRequests()                        //Setup Roles
            .antMatchers("/admin*").hasRole("ADMIN")    //Maps to admin
            .antMatchers("/user*").hasRole("USER")      //Maps to user
            .anyRequest().authenticated()               //Allows form
            .and()                                      //authentication
            .formLogin()
            .loginPage("/login.html")
            .and()
            .logout()
            .logoutSuccessUrl("/index.html") ;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder() ;
    }
}
