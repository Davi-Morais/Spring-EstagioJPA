package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.AlunoDTO;
import com.estagiojpa.estagio.dtos.EmpresaDTO;
import com.estagiojpa.estagio.entities.Aluno;
import com.estagiojpa.estagio.entities.Empresa;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.repositories.EmpresaRepository;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;

@Service
public class EmpresaService {

    @Autowired
    private EmpresaRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;

    @Transactional(readOnly = true)
    public Page<EmpresaDTO> findAllPaged(Pageable pageable) {
        Page<Empresa> page = repository.findAll(pageable);
        return page.map(EmpresaDTO::new);
    }

    @Transactional(readOnly = true)
    public EmpresaDTO findById(Long id) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa not found with id: " + id));
        return new EmpresaDTO(empresa);
    }

    @Transactional
    public EmpresaDTO insert(EmpresaDTO dto) {
        Empresa empresa = new Empresa();
        copyDtoToEntity(dto, empresa);
        empresa = repository.save(empresa);
        return new EmpresaDTO(empresa);
    }

    @Transactional
    public EmpresaDTO update(Long id, EmpresaDTO dto) {
        Empresa empresa = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Empresa not found with id: " + id));

        copyDtoToEntity(dto, empresa);
        empresa = repository.save(empresa);
        return new EmpresaDTO(empresa);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Empresa not found with id: " + id);
        }
    }

    private void copyDtoToEntity(EmpresaDTO dto, Empresa entity) {
        entity.setNome(dto.getNome());
        entity.setCnpj(dto.getCnpj());
        
        entity.getAlunos().clear();
		for (AlunoDTO alunoDto : dto.getAlunos()) {
			Aluno aluno = alunoRepository.getOne(alunoDto.getId());
			entity.getAlunos().add(aluno);
	    }
    }
}
