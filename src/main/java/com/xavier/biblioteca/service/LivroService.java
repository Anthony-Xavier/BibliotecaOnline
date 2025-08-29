package com.xavier.biblioteca.service;

import com.xavier.biblioteca.enums.StatusEnum;
import com.xavier.biblioteca.model.Emprestimo;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.model.Usuario;
import com.xavier.biblioteca.repository.EmprestimoRepository;
import com.xavier.biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private EmprestimoRepository emprestimoRepository; // para consultas por usuário

    //Cadastro de livros
    public Livro cadastrarLivro(Livro livro) {
        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("Título é obrigatório");
        }
        return livroRepository.save(livro);
    }

    //Atulização de livros livre/emprestado
    public Livro atualizarStatusLivto(Long id, StatusEnum status){
        Livro livro = livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
        livro.setStatus(status);
        return livroRepository.save(livro);
    }

    //Listar livros por autor
    public List<Livro> listarLivrosPorAutor(Long autorId){
        return livroRepository.findByAutorId(autorId);
    }

    //Consultar livro por ID
    public Livro consultarLivroPorId(Long id) {
        return livroRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));
    }

    public List<Livro> consultarLivrosPorUsuario(Usuario usuario) {
        List<Emprestimo> emprestimos = emprestimoRepository.findByUsuario(usuario);
        return emprestimos.stream()
                .map(Emprestimo::getLivro)
                .toList();
    }
}
