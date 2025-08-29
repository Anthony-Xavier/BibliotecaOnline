package com.xavier.biblioteca.controller;

import com.xavier.biblioteca.enums.StatusEnum;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.model.Usuario;
import com.xavier.biblioteca.repository.UsuarioRepository;
import com.xavier.biblioteca.service.LivroService;
import com.xavier.biblioteca.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService livroService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    //Cadastrar livros
    @PostMapping
    public Livro cadastrarLivro(@RequestBody Livro livro){
        return livroService.cadastrarLivro(livro);
    }

    //Cadastrar livro por id
    @GetMapping("/{id}")
    public Livro consultarLivroPorId(@PathVariable Long id) {
        return livroService.consultarLivroPorId(id);
    }

    //Listar livro por autor
    @GetMapping("/autor/{autorId}")
    public java.util.List<Livro> listarLivrosPorAutor(@PathVariable Long autorId) {
        return livroService.listarLivrosPorAutor(autorId);
    }

    //Atualizar status do livro
    @PutMapping("/{id}/status")
    public Livro atualizarStatusLivro(@PathVariable Long id, @RequestParam StatusEnum status) {
        return livroService.atualizarStatusLivto(id, status);
    }

    //Listar livros por usuário
    @GetMapping("/usuario/{usuarioId}")
    public List<Livro> listarLivrosPorUsuario(@PathVariable Long usuarioId) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return livroService.consultarLivrosPorUsuario(usuario);
    }
}
