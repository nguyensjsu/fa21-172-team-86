package main.java.com.example.springusers;

import java.beans.JavaBean;

import org.springframework.data.jpa.repository.JpaRepository;

@Bean
public interface UserRepository extends JpaRepository<User, String> {
    User findByEmail( String email ) ;
}
