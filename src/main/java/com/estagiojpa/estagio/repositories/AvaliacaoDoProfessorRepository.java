package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.AvaliacaoDoProfessor;

@Repository
public interface AvaliacaoDoProfessorRepository extends JpaRepository<AvaliacaoDoProfessor, Long> {
    
}
