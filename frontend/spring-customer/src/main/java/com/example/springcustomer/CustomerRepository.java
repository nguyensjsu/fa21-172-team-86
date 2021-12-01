package com.example.springcustomer;

import org.springframework.data.jpa.repository.JpaRepository;

/*
Finding by email is more unique then finding by ID
Customer can always register with the same email with different ID's
*/

interface CustomerRepository extends JpaRepository <Customer, String> {
    Customer findByEmail(String email);
}
