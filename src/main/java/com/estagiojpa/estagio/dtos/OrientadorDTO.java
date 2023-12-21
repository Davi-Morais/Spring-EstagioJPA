package com.estagiojpa.estagio.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.Set;

import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.entities.Orientador;

public class OrientadorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String email;
    private List<AlunoDTO> alunos = new ArrayList<>();

    public OrientadorDTO() {
    }

    public OrientadorDTO(Long id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public OrientadorDTO(Orientador entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.email = entity.getEmail();
        entity.getAlunos().forEach(aluno -> this.alunos.add(new AlunoDTO(aluno)));
    }

    public OrientadorDTO(Orientador entity, Set<Aluno> alunos) {
		this(entity);
		alunos.forEach(aluno -> this.alunos.add(new AlunoDTO(aluno)));
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

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }

    
    
}
