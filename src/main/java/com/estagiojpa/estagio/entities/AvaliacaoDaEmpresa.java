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
@Table(name = "tb_avaliacao_da_empresa")
public class AvaliacaoDaEmpresa implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    @Column(nullable = false)
    private String rendimento;

    @Column(nullable = false)
	private String conhecimentos;
    
    @Column(nullable = false)
	private String cumprimentos;
    
    @Column(nullable = false)
	private String aprendizagem;
    
    @Column(nullable = false)
	private String desempenho;

    public AvaliacaoDaEmpresa() {
    }

    public AvaliacaoDaEmpresa(Aluno aluno, Empresa empresa, String rendimento, String conhecimentos, String cumprimentos,
            String aprendizagem, String desempenho) {
        this.aluno = aluno;
        this.empresa = empresa;
        this.rendimento = rendimento;
        this.conhecimentos = conhecimentos;
        this.cumprimentos = cumprimentos;
        this.aprendizagem = aprendizagem;
        this.desempenho = desempenho;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public String getRendimento() {
        return rendimento;
    }

    public void setRendimento(String rendimento) {
        this.rendimento = rendimento;
    }

    public String getConhecimentos() {
        return conhecimentos;
    }

    public void setConhecimentos(String conhecimentos) {
        this.conhecimentos = conhecimentos;
    }

    public String getCumprimentos() {
        return cumprimentos;
    }

    public void setCumprimentos(String cumprimentos) {
        this.cumprimentos = cumprimentos;
    }

    public String getAprendizagem() {
        return aprendizagem;
    }

    public void setAprendizagem(String aprendizagem) {
        this.aprendizagem = aprendizagem;
    }

    public String getDesempenho() {
        return desempenho;
    }

    public void setDesempenho(String desempenho) {
        this.desempenho = desempenho;
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
        AvaliacaoDaEmpresa other = (AvaliacaoDaEmpresa) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }
}
