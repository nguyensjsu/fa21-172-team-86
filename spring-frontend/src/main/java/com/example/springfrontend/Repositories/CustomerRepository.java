package com.example.springemployee.Repositories;

import com.example.springemployee.Models.Customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer>{
    
}
