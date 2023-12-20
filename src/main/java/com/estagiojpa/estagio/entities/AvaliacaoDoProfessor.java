package com.estagiojpa.estagio.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name = "tb_avaliacao_do_professor")
public class AvaliacaoDoProfessor implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orientador_id", referencedColumnName = "id")
    private Orientador orientador;

    @Column(nullable = false)
    private String assiduidade;

    @Column(nullable = false)
	private String disciplina;
    
    @Column(nullable = false)
	private String sociabilidade;
    
    @Column(nullable = false)
	private String responsabilidade;
    
    @Column(nullable = false)
	private String iniciativa;

    
    public AvaliacaoDoProfessor() {
    }


    public AvaliacaoDoProfessor(Aluno aluno, Orientador orientador, String assiduidade, String disciplina,
            String sociabilidade, String responsabilidade, String iniciativa) {
        this.aluno = aluno;
        this.orientador = orientador;
        this.assiduidade = assiduidade;
        this.disciplina = disciplina;
        this.sociabilidade = sociabilidade;
        this.responsabilidade = responsabilidade;
        this.iniciativa = iniciativa;
    }


    public Long getId() {
        return id;
    }


    public void setId(Long id) {
        this.id = id;
    }


    public Aluno getAluno() {
        return aluno;
    }


    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }


    public Orientador getOrientador() {
        return orientador;
    }


    public void setOrientador(Orientador orientador) {
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


    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        AvaliacaoDoProfessor other = (AvaliacaoDoProfessor) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
