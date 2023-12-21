package com.estagiojpa.estagio.dtos;

import java.io.Serializable;

import com.estagiojpa.estagio.entities.AvaliacaoDaEmpresa;

public class AvaliacaoDaEmpresaDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private AlunoDTO aluno;
    private EmpresaDTO empresa;
    private String rendimento;
    private String conhecimentos;
    private String cumprimentos;
    private String aprendizagem;
    private String desempenho;

    public AvaliacaoDaEmpresaDTO() {
    }

    public AvaliacaoDaEmpresaDTO(Long id, AlunoDTO aluno, EmpresaDTO empresa, String rendimento, String conhecimentos,
            String cumprimentos, String aprendizagem, String desempenho) {
        this.id = id;
        this.aluno = aluno;
        this.empresa = empresa;
        this.rendimento = rendimento;
        this.conhecimentos = conhecimentos;
        this.cumprimentos = cumprimentos;
        this.aprendizagem = aprendizagem;
        this.desempenho = desempenho;
    }

    public AvaliacaoDaEmpresaDTO(AvaliacaoDaEmpresa entity) {
        this.id = entity.getId();
        this.aluno = new AlunoDTO(entity.getAluno());
        this.empresa = new EmpresaDTO(entity.getEmpresa());
        this.rendimento = entity.getRendimento();
        this.conhecimentos = entity.getConhecimentos();
        this.cumprimentos = entity.getCumprimentos();
        this.aprendizagem = entity.getAprendizagem();
        this.desempenho = entity.getDesempenho();
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

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
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
}
