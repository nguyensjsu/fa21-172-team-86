package com.example.springmain.Repositories;

import com.example.springmain.Models.Role;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Finding by email is more unique then finding by ID
Users can always register with the same email with different ID's
*/

public interface RoleRepository extends JpaRepository<Role, Long>{
    
}
