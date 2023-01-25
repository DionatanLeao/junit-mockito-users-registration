package com.api.project.service.impl;

import com.api.project.domain.Usuario;
import com.api.project.domain.dto.UsuarioDTO;
import com.api.project.repositories.UsuarioRepository;
import com.api.project.service.exceptions.ObjectNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
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
    public static final String NOME = "Usuario 1";
    public static final String NOME_EMAIL = "usuario1@email.com";
    public static final String PASSWORD = "123";
    public static final String OBJETO_NAO_ENCONTRADO = "Objeto não encontrado";

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
        assertEquals(NOME, response.getName());
        assertEquals(NOME_EMAIL, response.getEmail());
    }

    @Test
    void findByIdObjectNotFoundException() {
        when(repository.findById(anyInt()))
                .thenThrow(new ObjectNotFoundException(OBJETO_NAO_ENCONTRADO));


        try {
            Usuario response = service.findById(ID);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
            assertEquals(OBJETO_NAO_ENCONTRADO, ex.getMessage());
        }
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
        usuario = new Usuario(ID, NOME, NOME_EMAIL, PASSWORD);
        usuarioDTO = new UsuarioDTO(ID, NOME, NOME_EMAIL, PASSWORD);
        optionalUsuario = Optional.of(new Usuario(ID, NOME, NOME_EMAIL, PASSWORD));
    }
}