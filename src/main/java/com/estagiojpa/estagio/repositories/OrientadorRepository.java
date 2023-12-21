package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.Orientador;

@Repository
public interface OrientadorRepository extends JpaRepository<Orientador, Long> {
    
}
