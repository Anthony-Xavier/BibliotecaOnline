package com.xavier.biblioteca.service;

import com.xavier.biblioteca.model.Autor;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {

    @Autowired
    AutorRepository autorRepository;

    //Cadastrar autor
    public Autor cadastrarAutor(Autor autor){
        return autorRepository.save(autor);
    }

    // Listar livros de um autor
    public List<Livro> listarLivrosPorAutor(Long id){
        Autor autor = autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
        return autor.getLivros();
    }

    //Listar todos os autores
    public List<Autor> listarAutores() {
        return autorRepository.findAll();
    }

    // Buscar autor por ID
    public Autor buscarAutorPorId(Long id) {
        return autorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Autor não encontrado"));
    }
}
