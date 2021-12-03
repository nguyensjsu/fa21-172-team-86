package com.example.springmanga;

import org.springframework.data.jpa.repository.JpaRepository;

interface StarbucksOrderRepository extends JpaRepository<MangaOrder, Long> {
	
}