package com.example.springbackoffice.Repositories;

import com.example.springbackoffice.Models.Support;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupportRepository extends JpaRepository<Support, Long>{
    
}
