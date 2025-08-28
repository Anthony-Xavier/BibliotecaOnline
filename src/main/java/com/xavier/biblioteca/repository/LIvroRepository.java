package com.xavier.biblioteca.repository;

import com.xavier.biblioteca.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LIvroRepository extends JpaRepository<Livro, Long> {
}
