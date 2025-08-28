package com.xavier.biblioteca.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;

    private String name;

    @OneToMany(mappedBy = "autor")
    private List<Livro> livros;

    public Autor() {
    }
    public Autor(String name) {
        this.name = name;
    }

    public Long getIdAutor() { return idAutor; }
    public String getNome() { return name; }
    public void setNome(String nome) { this.name = name; }
    public List<Livro> getLivros() { return livros; }
    public void setLivros(List<Livro> livros) { this.livros = livros; }
}
