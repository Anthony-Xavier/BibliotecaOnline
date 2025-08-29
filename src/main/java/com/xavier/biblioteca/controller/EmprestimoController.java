package com.xavier.biblioteca.controller;

import com.xavier.biblioteca.model.Emprestimo;
import com.xavier.biblioteca.service.EmprestimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {

    @Autowired
    private EmprestimoService emprestimoService;

    //crar emprestimo
    @PostMapping
    public Emprestimo crarEmpresimo(@RequestParam Long usarioId, @RequestParam Long livroId, @RequestParam String dataDevolucao){
        LocalDate devolucao = LocalDate.parse(dataDevolucao);
        return emprestimoService.criarEmprestimo(usarioId, livroId, devolucao);
    }

    //Registrar devolução do livro
    @PostMapping("/{id}/devolucao")
    public Emprestimo registrarDevolucao(@RequestParam Long id){
        return emprestimoService.registrarDevolucao(id);
    }

    // Listar empréstimos de um usuário
    @GetMapping("/usuario/{id}")
    public List<Emprestimo> listarPorUsuario(@PathVariable Long id) {
        return emprestimoService.listarEmprestimosPorUsuario(id);
    }

    // Listar empréstimos de um livro
    @GetMapping("/livro/{id}")
    public List<Emprestimo> listarPorLivro(@PathVariable Long id) {
        return emprestimoService.listarEmprestimosPorLivro(id);
    }
}
