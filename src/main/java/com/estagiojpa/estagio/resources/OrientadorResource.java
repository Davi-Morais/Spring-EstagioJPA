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

import com.estagiojpa.estagio.dtos.OrientadorDTO;
import com.estagiojpa.estagio.services.OrientadorService;


@RestController
@RequestMapping(value = "/orientadores")
public class OrientadorResource {
    @Autowired
	private OrientadorService service;


    @GetMapping
	public ResponseEntity<Page<OrientadorDTO>> findAll(
        @RequestParam(value = "orientadorId", defaultValue = "0") Long orientadorId,
        @RequestParam(value = "name", defaultValue = "") String nome,
        Pageable pageable) {
		
		Page<OrientadorDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}


    @GetMapping(value = "/{id}")
	public ResponseEntity<OrientadorDTO> findById(@PathVariable Long id) {
		OrientadorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}

    @PostMapping
	public ResponseEntity<OrientadorDTO> insert(@Valid @RequestBody OrientadorDTO dto) {
		dto = service.insert(dto);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}

    @PostMapping(value = "/{idOrientador}/{idAluno}")
	public ResponseEntity<Integer> insert(@PathVariable Long idOrientador, @PathVariable Long idAluno) {
		
        service.insertAluno(idOrientador, idAluno);
		return ResponseEntity.ok().body(1);
	}

    @PutMapping(value = "/{id}")
	public ResponseEntity<OrientadorDTO> update(@PathVariable Long id, @Valid @RequestBody OrientadorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}

    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
