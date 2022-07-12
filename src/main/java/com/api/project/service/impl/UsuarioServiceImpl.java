
package com.api.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.project.domain.Usuario;
import com.api.project.domain.dto.UsuarioDTO;
import com.api.project.repositories.UsuarioRepository;
import com.api.project.service.UsuarioService;
import com.api.project.service.exceptions.DataIntegratyViolationException;
import com.api.project.service.exceptions.ObjectNotFoundException;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public Usuario findById(Integer id) {
		Optional<Usuario> usuario = repository.findById(id);
		return usuario.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	@Override
	public List<Usuario> findAll() {
		return repository.findAll();
	}

	@Override
	public Usuario create(UsuarioDTO usuarioDto) {
		findByEmail(usuarioDto);
		return repository.save(mapper.map(usuarioDto, Usuario.class));
	}
	
	private void findByEmail(UsuarioDTO usuarioDTO) {
		Optional<Usuario> usuario = repository.findByEmail(usuarioDTO.getEmail());
		if (usuario.isPresent()) {
			throw new DataIntegratyViolationException("E-mail já cadastrado no sistema");
		}
	}


}
