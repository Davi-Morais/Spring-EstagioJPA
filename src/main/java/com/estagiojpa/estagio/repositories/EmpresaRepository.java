package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {
    
}
