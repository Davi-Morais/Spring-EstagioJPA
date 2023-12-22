package com.estagiojpa.estagio.resources;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.estagiojpa.estagio.dtos.EmpresaDTO;
import com.estagiojpa.estagio.dtos.OrientadorDTO;
import com.estagiojpa.estagio.services.EmpresaService;

@RestController
@RequestMapping(value = "/empresas")
public class EmpresaResource {
    @Autowired
	private EmpresaService service;


    @GetMapping
	public ResponseEntity<Page<EmpresaDTO>> findAll(
        @RequestParam(value = "empresaId", defaultValue = "0") Long empresaId,
        @RequestParam(value = "name", defaultValue = "") String nome,
        Pageable pageable) {
		
		Page<EmpresaDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}
    
    @GetMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> findById(@PathVariable Long id) {
		EmpresaDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

    @PostMapping
	public ResponseEntity<EmpresaDTO> insert(@Valid @RequestBody EmpresaDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

    @PostMapping(value = "/{idEmpresa}/{idAluno}")
	public ResponseEntity<Integer> insert(@PathVariable Long idEmpresa, @PathVariable Long idAluno) {
		
        service.insertAluno(idEmpresa, idAluno);
		return ResponseEntity.ok().body(1);
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<EmpresaDTO> update(@PathVariable Long id, @Valid @RequestBody EmpresaDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
