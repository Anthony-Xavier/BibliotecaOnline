package com.xavier.biblioteca.repository;

import com.xavier.biblioteca.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
