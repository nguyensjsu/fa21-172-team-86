package com.example.springmain.Repositories;

import com.example.springmain.Models.PaymentsCommand;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<PaymentsCommand, Long> {

}