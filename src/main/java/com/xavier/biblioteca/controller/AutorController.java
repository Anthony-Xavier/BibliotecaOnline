package com.xavier.biblioteca.controller;

import com.xavier.biblioteca.model.Autor;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.service.AutorService;
import jakarta.annotation.security.PermitAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autores")
public class AutorController {

    @Autowired
    public AutorService autorService;

    // Cadastrar autor
    @PostMapping
    public Autor cadastrarAutor(@RequestBody Autor autor){
        return autorService.cadastrarAutor(autor);
    }

    // Listar livros de um autor
    @GetMapping("/{id}/livros")
    public List<Livro> listarLivrosPorAutor(@PathVariable Long id){
        return autorService.listarLivrosPorAutor(id);
    }

    //Listar todos os autores
    @GetMapping
    public List<Autor> listarAutores(){
        return autorService.listarAutores();
    }

    // Buscar autor por ID
    @GetMapping("/{id}")
    public Autor buscarAutorPorId(@PathVariable Long id) {
        return autorService.buscarAutorPorId(id);
    }
}
