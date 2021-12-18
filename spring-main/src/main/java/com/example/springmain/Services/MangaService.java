package com.example.springmain.Services;

import java.util.Optional;

import com.example.springmain.Models.Manga;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface  MangaService {
    Optional<Manga> findById(Long id);

    Page<Manga> findAllProductsPageable(Pageable pageable);
}
