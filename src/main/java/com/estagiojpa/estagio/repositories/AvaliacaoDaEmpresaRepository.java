package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.AvaliacaoDaEmpresa;

@Repository
public interface AvaliacaoDaEmpresaRepository extends JpaRepository<AvaliacaoDaEmpresa, Long> {
    
}
