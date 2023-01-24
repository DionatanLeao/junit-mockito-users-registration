package com.api.project.service.impl;

import com.api.project.domain.Usuario;
import com.api.project.domain.dto.UsuarioDTO;
import com.api.project.repositories.UsuarioRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@SpringBootTest
class UsuarioServiceImplTest {

    public static final int ID = 1;
    public static final String NAME = "Usuario 1";
    public static final String NAME_EMAIL = "usuario1@email.com";
    public static final String PASSWORD = "123";

    @InjectMocks
    private UsuarioServiceImpl service;

    @Mock
    private UsuarioRepository repository;

    @Mock
    private ModelMapper mapper;

    private Usuario usuario;
    private UsuarioDTO usuarioDTO;
    private Optional<Usuario> optionalUsuario;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void findById() {
        when(repository.findById(anyInt())).thenReturn(optionalUsuario);

        Usuario response = service.findById(ID);

        assertNotNull(response);

        assertEquals(Usuario.class, response.getClass());
        assertEquals(ID, response.getId());
        assertEquals(NAME, response.getName());
        assertEquals(NAME_EMAIL, response.getEmail());
    }

    @Test
    void findAll() {
    }

    @Test
    void create() {
    }

    @Test
    void update() {
    }

    @Test
    void delete() {
    }

    private void startUser() {
        usuario = new Usuario(ID, NAME, NAME_EMAIL, PASSWORD);
        usuarioDTO = new UsuarioDTO(ID, NAME, NAME_EMAIL, PASSWORD);
        optionalUsuario = Optional.of(new Usuario(ID, NAME, NAME_EMAIL, PASSWORD));
    }
}