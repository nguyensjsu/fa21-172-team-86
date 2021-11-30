package com.example.springemployee;

import org.springframework.data.jpa.repository.JpaRepository;

@repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {    
}
