package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AvaliacaoDaEmpresaDTO;
import com.estagiojpa.estagio.entities.AvaliacaoDaEmpresa;
import com.estagiojpa.estagio.repositories.AvaliacaoDaEmpresaRepository;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.repositories.EmpresaRepository;
import com.estagiojpa.estagio.services.execptions.DatabaseException;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;

@Service
public class AvaliacaoDaEmpresaService {

    @Autowired
    private AvaliacaoDaEmpresaRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public AvaliacaoDaEmpresaDTO findById(Long id) {
        AvaliacaoDaEmpresa avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao da Empresa not found with id: " + id));
        return new AvaliacaoDaEmpresaDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDaEmpresaDTO insert(AvaliacaoDaEmpresaDTO dto) {
        AvaliacaoDaEmpresa avaliacao = new AvaliacaoDaEmpresa();
        copyDtoToEntity(dto, avaliacao);
        avaliacao = repository.save(avaliacao);
        return new AvaliacaoDaEmpresaDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDaEmpresaDTO update(Long id, AvaliacaoDaEmpresaDTO dto) {
        AvaliacaoDaEmpresa avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao da Empresa not found with id: " + id));

        copyDtoToEntity(dto, avaliacao);
        avaliacao = repository.save(avaliacao);
        return new AvaliacaoDaEmpresaDTO(avaliacao);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Avaliacao da Empresa not found with id: " + id);
        } catch (Exception e) {
            throw new DatabaseException("Error deleting Avaliacao da Empresa with id: " + id);
        }
    }

    private void copyDtoToEntity(AvaliacaoDaEmpresaDTO dto, AvaliacaoDaEmpresa entity) {
        entity.setRendimento(dto.getRendimento());
        entity.setConhecimentos(dto.getConhecimentos());
        entity.setCumprimentos(dto.getCumprimentos());
        entity.setAprendizagem(dto.getAprendizagem());
        entity.setDesempenho(dto.getDesempenho());

        entity.setAluno(alunoRepository.getOne(dto.getAluno().getId()));
        entity.setEmpresa(empresaRepository.getOne(dto.getEmpresa().getId()));
    }
}