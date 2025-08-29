package com.xavier.biblioteca.service;

import com.xavier.biblioteca.enums.StatusEnum;
import com.xavier.biblioteca.model.Emprestimo;
import com.xavier.biblioteca.model.Livro;
import com.xavier.biblioteca.model.Usuario;
import com.xavier.biblioteca.repository.EmprestimoRepository;
import com.xavier.biblioteca.repository.LivroRepository;
import com.xavier.biblioteca.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class EmprestimoService {

    @Autowired
    EmprestimoRepository emprestimoRepository;

    @Autowired
    UsuarioRepository  usuarioRepository;

    @Autowired
    LivroRepository livroRepository;


    // Criar empréstimo
    @Transactional
    public Emprestimo criarEmprestimo(Long usuarioId, Long livroId, LocalDate dataDevolucao) {
        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        if(livro.getStatus() != StatusEnum.LIVRE){
            throw  new RuntimeException("Livro não disponível para empréstimo");
        }

        livro.setStatus(StatusEnum.EMPRESTADO);
        livroRepository.save(livro);

        Emprestimo emprestimo = new Emprestimo();
        emprestimo.setUsuario(usuario);
        emprestimo.setLivro(livro);
        emprestimo.setDataEmprestimo(LocalDate.now());
        emprestimo.setDataDevolucao(dataDevolucao);

        return emprestimoRepository.save(emprestimo);
    }

    //Registrar devolução do livro
    @Transactional
    public Emprestimo registrarDevolucao(Long emprestimoId) {
        Emprestimo emprestimo = emprestimoRepository.findById(emprestimoId)
                .orElseThrow(() -> new RuntimeException("Empréstimo não encontrado"));

        if (emprestimo.getDataDevolucao() != null || emprestimo.getLivro().getStatus() == StatusEnum.LIVRE) {
            throw new RuntimeException("Livro já foi devolvido");
        }

        emprestimo.setDataDevolucao(LocalDate.now());
        Livro livro = emprestimo.getLivro();
        livro.setStatus(StatusEnum.LIVRE);
        livroRepository.save(livro);

        return emprestimoRepository.save(emprestimo);
    }

    // Listar empréstimos de um usuário
    public List<Emprestimo> listarEmprestimosPorUsuario(Long idUsuario) {
        Usuario usuario = usuarioRepository.findById(idUsuario)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        return usuario.getEmprestimos();
    }

    // Listar empréstimos de um livro
    public List<Emprestimo> listarEmprestimosPorLivro(Long livroId) {
        Livro livro = livroRepository.findById(livroId)
                .orElseThrow(() -> new RuntimeException("Livro não encontrado"));

        return emprestimoRepository.findByLivro(livro);
    }
}
