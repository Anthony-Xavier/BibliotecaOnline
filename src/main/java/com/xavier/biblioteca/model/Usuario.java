package com.xavier.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    private String nome;

    @OneToMany(mappedBy = "usuario")
    private List<Emprestimo> emprestimos;

    public Usuario() {
    }

    public Usuario(String nome) {
        this.nome = nome;
    }

    public Long getIdUsuario() { return idUsuario; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public List<Emprestimo> getEmprestimos() { return emprestimos; }
    public void setEmprestimos(List<Emprestimo> emprestimos) { this.emprestimos = emprestimos; }
}

