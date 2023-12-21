package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.Estagio;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Long> {
    
}
