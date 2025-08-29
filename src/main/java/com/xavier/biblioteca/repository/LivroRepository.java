package com.xavier.biblioteca.repository;

import com.xavier.biblioteca.model.Emprestimo;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByAutorId(Long autorId);
}
