package com.example.springmanga;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface MangaOrderRepository extends JpaRepository<Manga, Long> {
    Manga findByisbn(String isbn);
    Manga findByMangaID(Long id);
}