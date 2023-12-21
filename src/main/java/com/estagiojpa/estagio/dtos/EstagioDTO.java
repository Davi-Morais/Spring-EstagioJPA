package com.estagiojpa.estagio.dtos;

import java.io.Serializable;

import com.estagiojpa.estagio.entities.Estagio;

public class EstagioDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String inicioEstagio;
    private String fimEstagio;
    private int cargaHoraria;
    private String status;
    private AlunoDTO aluno;
    private OrientadorDTO orientador;
    private EmpresaDTO empresa;

    public EstagioDTO() {
    }

    public EstagioDTO(Long id, String inicioEstagio, String fimEstagio, int cargaHoraria, String status,
            AlunoDTO aluno, OrientadorDTO orientador, EmpresaDTO empresa) {
        this.id = id;
        this.inicioEstagio = inicioEstagio;
        this.fimEstagio = fimEstagio;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.aluno = aluno;
        this.orientador = orientador;
        this.empresa = empresa;
    }

    public EstagioDTO(Estagio entity) {
        this.id = entity.getId();
        this.inicioEstagio = entity.getInicioEstagio();
        this.fimEstagio = entity.getFimEstagio();
        this.cargaHoraria = entity.getCargaHoraria();
        this.status = entity.getStatus();
        this.aluno = new AlunoDTO(entity.getAluno());
        this.orientador = new OrientadorDTO(entity.getOrientador());
        this.empresa = new EmpresaDTO(entity.getEmpresa());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInicioEstagio() {
        return inicioEstagio;
    }

    public void setInicioEstagio(String inicioEstagio) {
        this.inicioEstagio = inicioEstagio;
    }

    public String getFimEstagio() {
        return fimEstagio;
    }

    public void setFimEstagio(String fimEstagio) {
        this.fimEstagio = fimEstagio;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public EmpresaDTO getEmpresa() {
        return empresa;
    }

    public void setEmpresa(EmpresaDTO empresa) {
        this.empresa = empresa;
    }
}