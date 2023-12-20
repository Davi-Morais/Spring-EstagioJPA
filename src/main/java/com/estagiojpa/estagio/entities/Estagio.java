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
@Table(name = "tb_estagio")
public class Estagio implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, name = "inicioEstagio")
    private String inicioEstagio;

    @Column(nullable = false)
    private String fimEstagio;

    @Column(nullable = false)
    private int cargaHoraria;

    @Column(nullable = false)
    private String status;


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aluno_id", referencedColumnName = "id")
    private Aluno aluno;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "orientador_id", referencedColumnName = "id")
    private Orientador orientador;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "empresa_id", referencedColumnName = "id")
    private Empresa empresa;

    public Estagio() {
    }

    public Estagio(String inicioEstagio, String fimEstagio, int cargaHoraria, String status, Aluno aluno,
            Orientador orientador, Empresa empresa) {
        this.inicioEstagio = inicioEstagio;
        this.fimEstagio = fimEstagio;
        this.cargaHoraria = cargaHoraria;
        this.status = status;
        this.aluno = aluno;
        this.orientador = orientador;
        this.empresa = empresa;
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

    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
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
        Estagio other = (Estagio) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


    
}
