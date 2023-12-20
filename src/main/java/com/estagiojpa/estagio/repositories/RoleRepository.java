package com.estagiojpa.estagio.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.estagiojpa.estagio.entities.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    
}
