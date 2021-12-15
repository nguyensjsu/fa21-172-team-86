package com.example.springmain.Repositories;

import com.example.springmain.Models.Support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long>{
    
}
