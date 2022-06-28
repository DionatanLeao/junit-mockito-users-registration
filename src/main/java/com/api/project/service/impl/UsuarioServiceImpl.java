
package com.api.project.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.domain.Usuario;
import com.api.project.repositories.UsuarioRepository;
import com.api.project.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	@Override
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElse(null);
	}

}
