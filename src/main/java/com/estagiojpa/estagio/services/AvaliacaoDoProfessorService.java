package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AvaliacaoDoProfessorDTO;
import com.estagiojpa.estagio.entities.AvaliacaoDoProfessor;
import com.estagiojpa.estagio.repositories.AvaliacaoDoProfessorRepository;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.repositories.OrientadorRepository;
import com.estagiojpa.estagio.services.execptions.DatabaseException;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;

@Service
public class AvaliacaoDoProfessorService {

    @Autowired
    private AvaliacaoDoProfessorRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private OrientadorRepository orientadorRepository;

    @Transactional(readOnly = true)
    public AvaliacaoDoProfessorDTO findById(Long id) {
        AvaliacaoDoProfessor avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao do Professor not found with id: " + id));
        return new AvaliacaoDoProfessorDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDoProfessorDTO insert(AvaliacaoDoProfessorDTO dto) {
        AvaliacaoDoProfessor avaliacao = new AvaliacaoDoProfessor();
        copyDtoToEntity(dto, avaliacao);
        avaliacao = repository.save(avaliacao);
        return new AvaliacaoDoProfessorDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDoProfessorDTO update(Long id, AvaliacaoDoProfessorDTO dto) {
        AvaliacaoDoProfessor avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao do Professor not found with id: " + id));

        copyDtoToEntity(dto, avaliacao);
        avaliacao = repository.save(avaliacao);
        return new AvaliacaoDoProfessorDTO(avaliacao);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Avaliacao do Professor not found with id: " + id);
        } catch (Exception e) {
            throw new DatabaseException("Error deleting Avaliacao do Professor with id: " + id);
        }
    }

    private void copyDtoToEntity(AvaliacaoDoProfessorDTO dto, AvaliacaoDoProfessor entity) {
        entity.setAssiduidade(dto.getAssiduidade());
        entity.setDisciplina(dto.getDisciplina());
        entity.setSociabilidade(dto.getSociabilidade());
        entity.setResponsabilidade(dto.getResponsabilidade());
        entity.setIniciativa(dto.getIniciativa());

        entity.setAluno(alunoRepository.getOne(dto.getAluno().getId()));
        entity.setOrientador(orientadorRepository.getOne(dto.getOrientador().getId()));
    }
}
