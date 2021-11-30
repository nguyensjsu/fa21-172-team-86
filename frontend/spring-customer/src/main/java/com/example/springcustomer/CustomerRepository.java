package main.java.com.example.springcustomer;

import org.springframework.data.jpa.repository.JpaRepository;

@repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
    
}
