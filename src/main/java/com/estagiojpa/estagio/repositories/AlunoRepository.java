package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.Aluno;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Long> {
    
}
