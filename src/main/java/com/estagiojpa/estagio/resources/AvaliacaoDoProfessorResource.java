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

import com.estagiojpa.estagio.dtos.AvaliacaoDoProfessorDTO;
import com.estagiojpa.estagio.services.AvaliacaoDoProfessorService;

@RestController
@RequestMapping(value = "/avaliacao/professor")
public class AvaliacaoDoProfessorResource {
    @Autowired
	private AvaliacaoDoProfessorService service;


    @GetMapping
	public ResponseEntity<Page<AvaliacaoDoProfessorDTO>> findAll(
        @RequestParam(value = "estagioId", defaultValue = "0") Long avaliacaoId,
        @RequestParam(value = "name", defaultValue = "") String nome,
        Pageable pageable) {
		
		Page<AvaliacaoDoProfessorDTO> list = service.findAllPaged(pageable);		
		return ResponseEntity.ok().body(list);
	}

    @GetMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoDoProfessorDTO> findById(@PathVariable Long id) {
		AvaliacaoDoProfessorDTO dto = service.findById(id);
		return ResponseEntity.ok().body(dto);
	}


    @PostMapping(value = "/{idAluno}/{idOrientador}")
	public ResponseEntity<AvaliacaoDoProfessorDTO> insert(@Valid @RequestBody AvaliacaoDoProfessorDTO dto,
                                            @PathVariable Long idAluno,
                                            @PathVariable Long idOrientador) {
		dto = service.insert(dto, idAluno, idOrientador);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(dto.getId()).toUri();
		return ResponseEntity.created(uri).body(dto);
	}


    @PutMapping(value = "/{id}")
	public ResponseEntity<AvaliacaoDoProfessorDTO> update(@PathVariable Long id, @Valid @RequestBody AvaliacaoDoProfessorDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}


    @DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
