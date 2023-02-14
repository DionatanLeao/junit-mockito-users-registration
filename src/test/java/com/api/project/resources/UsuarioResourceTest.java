package com.api.project.resources;

import com.api.project.domain.Usuario;
import com.api.project.domain.dto.UsuarioDTO;
import com.api.project.service.impl.UsuarioServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class UsuarioResourceTest {

    private static final int ID = 1;
    private static final String NOME = "Usuario 1";
    private static final String NOME_EMAIL = "usuario1@email.com";
    private static final String PASSWORD = "123";
    private static final int INDEX = 0;

    @InjectMocks
    private UsuarioResource resource;

    @Mock
    private UsuarioServiceImpl service;

    @Mock
    private ModelMapper mapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
    }

    @Test
    void findAll() {
    }

    @Test
    void save() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        usuario = new Usuario(ID, NOME, NOME_EMAIL, PASSWORD);
        usuarioDTO = new UsuarioDTO(ID, NOME, NOME_EMAIL, PASSWORD);
    }
}