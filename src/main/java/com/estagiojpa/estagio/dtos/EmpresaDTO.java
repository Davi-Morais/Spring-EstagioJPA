package com.estagiojpa.estagio.dtos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.entities.Empresa;

public class EmpresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String nome;
    private String cnpj;
    private List<AlunoDTO> alunos = new ArrayList<>();

    public EmpresaDTO() {
    }

    public EmpresaDTO(Long id, String nome, String cnpj) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public EmpresaDTO(Empresa entity) {
        this.id = entity.getId();
        this.nome = entity.getNome();
        this.cnpj = entity.getCnpj();
        entity.getAlunos().forEach(aluno -> this.alunos.add(new AlunoDTO(aluno)));
    }

    public EmpresaDTO(Empresa entity, Set<Aluno> alunos) {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public List<AlunoDTO> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<AlunoDTO> alunos) {
        this.alunos = alunos;
    }

    
}
