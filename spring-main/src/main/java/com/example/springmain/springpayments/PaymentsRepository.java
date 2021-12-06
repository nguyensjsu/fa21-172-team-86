package com.example.springpayments;

import org.springframework.data.jpa.repository.JpaRepository;

interface PaymentsRepository extends JpaRepository<PaymentsCommand, Long> {

}