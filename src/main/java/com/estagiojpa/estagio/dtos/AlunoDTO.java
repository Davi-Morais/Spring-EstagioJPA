package com.estagiojpa.estagio.dtos;

import java.io.Serializable;

import com.estagiojpa.estagio.entities.Aluno;

public class AlunoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private int idade;
    private char genero;

    public AlunoDTO() {
    }

    public AlunoDTO(Long id, String nome, String email, int idade, char genero) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.genero = genero;
    }

    public AlunoDTO(Aluno entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        this.idade = entity.getIdade();
        this.genero = entity.getGenero();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }
}
