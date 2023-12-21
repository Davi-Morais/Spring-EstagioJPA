package com.estagiojpa.estagio.dtos;

import java.io.Serializable;

import com.estagiojpa.estagio.entities.AvaliacaoDoProfessor;

public class AvaliacaoDoProfessorDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private AlunoDTO aluno;
    private OrientadorDTO orientador;
    private String assiduidade;
    private String disciplina;
    private String sociabilidade;
    private String responsabilidade;
    private String iniciativa;

    public AvaliacaoDoProfessorDTO() {
    }

    public AvaliacaoDoProfessorDTO(Long id, AlunoDTO aluno, OrientadorDTO orientador, String assiduidade,
            String disciplina, String sociabilidade, String responsabilidade, String iniciativa) {
        this.id = id;
        this.aluno = aluno;
        this.orientador = orientador;
        this.assiduidade = assiduidade;
        this.disciplina = disciplina;
        this.sociabilidade = sociabilidade;
        this.responsabilidade = responsabilidade;
        this.iniciativa = iniciativa;
    }

    public AvaliacaoDoProfessorDTO(AvaliacaoDoProfessor entity) {
        this.id = entity.getId();
        this.aluno = new AlunoDTO(entity.getAluno());
        this.orientador = new OrientadorDTO(entity.getOrientador());
        this.assiduidade = entity.getAssiduidade();
        this.disciplina = entity.getDisciplina();
        this.sociabilidade = entity.getSociabilidade();
        this.responsabilidade = entity.getResponsabilidade();
        this.iniciativa = entity.getIniciativa();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AlunoDTO getAluno() {
        return aluno;
    }

    public void setAluno(AlunoDTO aluno) {
        this.aluno = aluno;
    }

    public OrientadorDTO getOrientador() {
        return orientador;
    }

    public void setOrientador(OrientadorDTO orientador) {
        this.orientador = orientador;
    }

    public String getAssiduidade() {
        return assiduidade;
    }

    public void setAssiduidade(String assiduidade) {
        this.assiduidade = assiduidade;
    }

    public String getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(String disciplina) {
        this.disciplina = disciplina;
    }

    public String getSociabilidade() {
        return sociabilidade;
    }

    public void setSociabilidade(String sociabilidade) {
        this.sociabilidade = sociabilidade;
    }

    public String getResponsabilidade() {
        return responsabilidade;
    }

    public void setResponsabilidade(String responsabilidade) {
        this.responsabilidade = responsabilidade;
    }

    public String getIniciativa() {
        return iniciativa;
    }

    public void setIniciativa(String iniciativa) {
        this.iniciativa = iniciativa;
    }
}