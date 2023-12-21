package com.estagiojpa.estagio.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.estagiojpa.estagio.dtos.EstagioDTO;
import com.estagiojpa.estagio.entities.Estagio;
import com.estagiojpa.estagio.repositories.AlunoRepository;
import com.estagiojpa.estagio.repositories.EmpresaRepository;
import com.estagiojpa.estagio.repositories.EstagioRepository;
import com.estagiojpa.estagio.repositories.OrientadorRepository;
import com.estagiojpa.estagio.services.execptions.DatabaseException;
import com.estagiojpa.estagio.services.execptions.ResourceNotFoundException;

@Service
public class EstagioService {

    @Autowired
    private EstagioRepository repository;
    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private OrientadorRepository orientadorRepository;
    @Autowired
    private EmpresaRepository empresaRepository;

    @Transactional(readOnly = true)
    public Page<EstagioDTO> findAllPaged(Pageable pageable) {
        Page<Estagio> page = repository.findAll(pageable);
        return page.map(EstagioDTO::new);
    }

    @Transactional(readOnly = true)
    public EstagioDTO findById(Long id) {
        Estagio estagio = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estagio not found with id: " + id));
        return new EstagioDTO(estagio);
    }

    @Transactional
    public EstagioDTO insert(EstagioDTO dto) {
        Estagio estagio = new Estagio();
        copyDtoToEntity(dto, estagio);
        estagio = repository.save(estagio);
        return new EstagioDTO(estagio);
    }

    @Transactional
    public EstagioDTO update(Long id, EstagioDTO dto) {
        Estagio estagio = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Estagio not found with id: " + id));

        copyDtoToEntity(dto, estagio);
        estagio = repository.save(estagio);
        return new EstagioDTO(estagio);
    }

    public void delete(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException("Estagio not found with id: " + id);
        } catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
    }

    private void copyDtoToEntity(EstagioDTO dto, Estagio entity) {
        entity.setInicioEstagio(dto.getInicioEstagio());
        entity.setFimEstagio(dto.getFimEstagio());
        entity.setCargaHoraria(dto.getCargaHoraria());
        entity.setStatus(dto.getStatus());
        
        entity.setAluno(alunoRepository.getOne(dto.getAluno().getId()));
        entity.setOrientador(orientadorRepository.getOne(dto.getOrientador().getId()));
        entity.setEmpresa(empresaRepository.getOne(dto.getEmpresa().getId()));
    }
}