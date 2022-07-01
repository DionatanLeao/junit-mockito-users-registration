package com.api.project.service;

import java.util.List;

import com.api.project.domain.Usuario;

public interface UsuarioService {
	
	Usuario findById(Integer id);
	
	List<Usuario> findAll();
}
