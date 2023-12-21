package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AlunoDTO;
import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;



@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    @Transactional(readOnly = true)
    public Page<AlunoDTO> findAllPaged(Pageable pageable) {
        Page<Aluno> page = repository.findAll(pageable);
        return page.map(AlunoDTO::new);
    }

    @Transactional(readOnly = true)
    public AlunoDTO findById(Long id) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + id));
        return new AlunoDTO(aluno);
    }

    @Transactional
    public AlunoDTO insert(AlunoDTO dto) {
        Aluno aluno = new Aluno();
        copyDtoToEntity(dto, aluno);
        aluno = repository.save(aluno);
        return new AlunoDTO(aluno);
    }

    @Transactional
    public AlunoDTO update(Long id, AlunoDTO dto) {
        Aluno aluno = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + id));

        copyDtoToEntity(dto, aluno);
        aluno = repository.save(aluno);
        return new AlunoDTO(aluno);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Aluno not found with id: " + id);
        }
    }

    private void copyDtoToEntity(AlunoDTO dto, Aluno entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        entity.setIdade(dto.getIdade());
        entity.setGenero(dto.getGenero());
    }
}

