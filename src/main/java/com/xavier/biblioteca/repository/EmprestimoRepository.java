package com.xavier.biblioteca.repository;

import com.xavier.biblioteca.model.Emprestimo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmprestimoRepository extends JpaRepository<Emprestimo , Long> {
}
