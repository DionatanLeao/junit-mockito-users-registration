package com.api.project.service;

import java.util.List;

import com.api.project.domain.Usuario;
import com.api.project.domain.dto.UsuarioDTO;

public interface UsuarioService {
	
	Usuario findById(Integer id);
	
	List<Usuario> findAll();
	
	Usuario create(UsuarioDTO usuarioDto);
}
