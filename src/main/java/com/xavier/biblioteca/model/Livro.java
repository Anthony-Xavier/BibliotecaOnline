package com.xavier.biblioteca.model;

import com.xavier.biblioteca.enums.StatusEnum;
import jakarta.persistence.*;

@Entity
@Table(name = "tb_livro")

public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLivro;

    private String titulo;
    private Integer anoPublicacao;
    private String genero;
    private StatusEnum status;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    private Autor autor;

    public class livro {
    }

    public Livro(Long idLivro, String titulo, Integer anoPublicacao, String genero, StatusEnum statusm,Autor autor) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.status = status;
        this.autor = autor;
    }

    public Long getIdLivro() {
        return idLivro;
    }

    public void setIdLivro(Long idLivro) {
        this.idLivro = idLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoPublicacao() {
        return anoPublicacao;
    }

    public void setAnoPublicacao(Integer anoPublicacao) {
        this.anoPublicacao = anoPublicacao;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public StatusEnum getStatus() {
        return status;
    }

    public void setStatus(StatusEnum status) {
        this.status = status;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
}
