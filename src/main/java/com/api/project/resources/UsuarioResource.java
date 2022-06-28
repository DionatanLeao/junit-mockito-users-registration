package com.api.project.resources;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.project.domain.Usuario;

@RestController
@RequestMapping("/user")
public class UsuarioResource {
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Integer id) {
		return ResponseEntity.ok().body(new Usuario(1, "Dionatan Leão", "dionatan@email.com", "123")); 
	}
}
