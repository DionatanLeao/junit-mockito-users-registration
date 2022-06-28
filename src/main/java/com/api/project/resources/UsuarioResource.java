package com.api.project.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.domain.Usuario;
import com.api.project.service.UsuarioService;

@RestController
@RequestMapping("/user")
public class UsuarioResource {
	
	@Autowired
	private UsuarioService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(service.findById(id)); 
	}
}
