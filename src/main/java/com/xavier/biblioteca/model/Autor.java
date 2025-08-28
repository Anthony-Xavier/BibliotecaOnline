package com.xavier.biblioteca.model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_autor")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAutor;
    private String name;

    public Autor() {
    }
    public Autor(Long idAutor, String name) {
        this.idAutor = idAutor;
        this.name = name;
    }

    public Long getIdAutor() {
        return idAutor;
    }

    public void setIdAutor(Long idAutor) {
        this.idAutor = idAutor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
