package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AvaliacaoDaEmpresaDTO;
import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.entities.AvaliacaoDaEmpresa;
import com.estagiojpa.estagio.entities.Empresa;
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
    public Page<AvaliacaoDaEmpresaDTO> findAllPaged(Pageable pageable) {
        Page<AvaliacaoDaEmpresa> page = repository.findAll(pageable);
        return page.map(AvaliacaoDaEmpresaDTO::new);
    }


    @Transactional(readOnly = true)
    public AvaliacaoDaEmpresaDTO findById(Long id) {
        AvaliacaoDaEmpresa avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao da Empresa not found with id: " + id));
        return new AvaliacaoDaEmpresaDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDaEmpresaDTO insert(AvaliacaoDaEmpresaDTO dto, Long idAluno, Long idEmpresa) {
        AvaliacaoDaEmpresa avaliacao = new AvaliacaoDaEmpresa();

        Aluno aluno = alunoRepository.findById(idAluno)
                .orElseThrow(() -> new ResourceNotFoundException("Aluno not found with id: " + idAluno));
        Empresa empresa = empresaRepository.findById(idEmpresa)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa not found with id: " + idEmpresa));


        avaliacao.setRendimento(dto.getRendimento());
        avaliacao.setConhecimentos(dto.getConhecimentos());
        avaliacao.setCumprimentos(dto.getCumprimentos());
        avaliacao.setAprendizagem(dto.getAprendizagem());
        avaliacao.setDesempenho(dto.getDesempenho());

        avaliacao.setAluno(aluno);
        avaliacao.setEmpresa(empresa);

        avaliacao = repository.save(avaliacao);
        return new AvaliacaoDaEmpresaDTO(avaliacao);
    }

    @Transactional
    public AvaliacaoDaEmpresaDTO update(Long id, AvaliacaoDaEmpresaDTO dto) {
        AvaliacaoDaEmpresa avaliacao = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Avaliacao da Empresa not found with id: " + id));


        avaliacao.setRendimento(dto.getRendimento());
        avaliacao.setConhecimentos(dto.getConhecimentos());
        avaliacao.setCumprimentos(dto.getCumprimentos());
        avaliacao.setAprendizagem(dto.getAprendizagem());
        avaliacao.setDesempenho(dto.getDesempenho());


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

    /* private void copyDtoToEntity(AvaliacaoDaEmpresaDTO dto, AvaliacaoDaEmpresa entity) {
        entity.setRendimento(dto.getRendimento());
        entity.setConhecimentos(dto.getConhecimentos());
        entity.setCumprimentos(dto.getCumprimentos());
        entity.setAprendizagem(dto.getAprendizagem());
        entity.setDesempenho(dto.getDesempenho());

        entity.setAluno(alunoRepository.getOne(dto.getAluno().getId()));
        entity.setEmpresa(empresaRepository.getOne(dto.getEmpresa().getId()));
    } */
}