package com.estagiojpa.estagio.services;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AlunoDTO;
import com.estagiojpa.estagio.dtos.OrientadorDTO;
import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.entities.Orientador;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.repositories.OrientadorRepository;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;

@Service
public class OrientadorService {

    @Autowired
    private OrientadorRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public Page<OrientadorDTO> findAllPaged(Pageable pageable) {
        Page<Orientador> page = repository.findAll(pageable);
        return page.map(OrientadorDTO::new);
    }

    @Transactional(readOnly = true)
    public OrientadorDTO findById(Long id) {
        Orientador orientador = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orientador not found with id: " + id));
        return new OrientadorDTO(orientador);
    }

    @Transactional
    public OrientadorDTO insert(OrientadorDTO dto) {
        Orientador orientador = new Orientador();
        copyDtoToEntity(dto, orientador);
        orientador = repository.save(orientador);
        return new OrientadorDTO(orientador);
    }

    @Transactional
    public OrientadorDTO insertAluno(Long idOrientador, Long idAluno) {
        Orientador orientador = repository.findById(idOrientador)
                .orElseThrow(() -> new ResourceNotFoundException("Orientador not found with id: " + idOrientador));
        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + idAluno));

        Set<Aluno> alunos =  orientador.getAlunos();
        alunos.add(aluno);

        orientador.setAlunos(alunos);

        orientador = repository.save(orientador);
        return new OrientadorDTO(orientador);
    }

    @Transactional
    public OrientadorDTO update(Long id, OrientadorDTO dto) {
        Orientador orientador = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Orientador not found with id: " + id));

        orientador.setNome(dto.getNome());
        orientador.setEmail(dto.getEmail());


        orientador = repository.save(orientador);
        return new OrientadorDTO(orientador);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Orientador not found with id: " + id);
        }
    }

    private void copyDtoToEntity(OrientadorDTO dto, Orientador entity) {
        entity.setNome(dto.getNome());
        entity.setEmail(dto.getEmail());
        
        entity.getAlunos().clear();
		for (AlunoDTO alunoDto : dto.getAlunos()) {
			Aluno aluno = alunoRepository.getOne(alunoDto.getId());
			entity.getAlunos().add(aluno);
	    }
    }
}