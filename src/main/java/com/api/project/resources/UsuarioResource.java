package com.api.project.resources;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.api.project.domain.dto.UsuarioDTO;
import com.api.project.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioResource {
	
	private static final String ID = "/{id}";

	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = ID)
	public ResponseEntity<UsuarioDTO> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(mapper.map(service.findById(id), UsuarioDTO.class)); 
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioDTO>> findAll() {
		return ResponseEntity.ok()
				.body(service.findAll().stream().map(x -> mapper.map(x, UsuarioDTO.class)).collect(Collectors.toList()));
	}
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> save(@RequestBody UsuarioDTO usuarioDto) {
		return ResponseEntity.created(ServletUriComponentsBuilder
				.fromCurrentRequest().path(ID)
				.buildAndExpand(service.create(usuarioDto).getId())
				.toUri()).build();
	}
	
	@PutMapping(value = ID)
	public ResponseEntity<UsuarioDTO> update(@PathVariable Integer id, @RequestBody UsuarioDTO usuarioDto) {
		usuarioDto.setId(id);
		return ResponseEntity.ok().body(mapper.map(service.update(usuarioDto), UsuarioDTO.class));
	}
	
	@DeleteMapping(value = ID)
	public ResponseEntity<UsuarioDTO> delete(@PathVariable Integer id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
