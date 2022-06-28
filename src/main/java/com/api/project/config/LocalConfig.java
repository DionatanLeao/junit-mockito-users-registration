package com.api.project.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.api.project.domain.Usuario;
import com.api.project.repositories.UsuarioRepository;

@Configuration
@Profile("local")
public class LocalConfig {
	
	@Autowired
	private UsuarioRepository repository;
	
	@Bean
	public void startDB() {
		Usuario u1 = new Usuario(null, "Teste 1", "teste1@email.com", "123");
		Usuario u2 = new Usuario(null, "Teste 2", "teste2@email.com", "123");
		
		repository.saveAll(List.of(u1, u2));
	}

}
