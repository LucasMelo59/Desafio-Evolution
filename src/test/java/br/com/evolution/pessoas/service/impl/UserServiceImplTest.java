package br.com.evolution.pessoas.service.impl;

import br.com.evolution.pessoas.dto.UserDto;
import br.com.evolution.pessoas.exceptions.ObjectNotFoundException;
import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class UserServiceImplTest {
    @InjectMocks
    private UserServiceImpl service;
    @Mock
    private PessoaRepository repository;
    @Mock
    private ModelMapper mapper;

    private User user;
    private UserDto userDto;
    private Optional<User> optionalUser;
    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        startUser();
    }

    @Test
    void whenCreateThenReturnSucess() {
        when(repository.save(any())).thenReturn(user);
        User response = service.cadastrar(userDto);

        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(1, response.getId());

    }

    @Test
    void whenUpdateThenReturnSucess() {
    when(repository.save(any())).thenReturn(user);

    User response =  service.atualizar(userDto);

    assertNotNull(response);
    assertEquals(User.class, response.getClass());
    assertEquals(1, response.getId());
    }

    @Test
    void whenFindByIdReturnAAnUserInstance() {
        when(repository.findById(Mockito.anyInt())).thenReturn(optionalUser);
        User response = service.detalhar(1);
        assertNotNull(response);
        assertEquals(User.class, response.getClass());
        assertEquals(1, response.getId());
    }

    void whenFindByIdReturnAnObjectNotFoundExcep(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));

        try{
            service.detalhar(1);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
        }
    }

    @Test
    void whenFiddAllThenReturnAnListOfUsers() {
        when(repository.findAll()).thenReturn(List.of(user));
        List<User> response  = service.listaDeUsuarios();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals(User.class, response.get(0).getClass());
    }

    @Test
    void deleteWithSuccess() {
        when(repository.findById(anyInt())).thenReturn(optionalUser);
        doNothing().when(repository).deleteById(anyInt());
        service.remover(1);
        verify(repository, times(1)).deleteById(anyInt());
    }

    @Test
    void deleteWithObjectNotFoundException(){
        when(repository.findById(anyInt())).thenThrow(new ObjectNotFoundException("Objeto não encontrado"));
        try{
            service.remover(2);
        } catch (Exception ex) {
            assertEquals(ObjectNotFoundException.class, ex.getClass());
        }
    }

    private void startUser(){
        user = new User(1, "213123123", "gug21" , "teste@22", "6039393" , "q1231231" , "213213123" , "123213", "CE" );
        userDto = new UserDto(1, "213123123", "gug21" , "teste@22", "6039393" , "q1231231" , "213213123" , "123213", "CE" );
        optionalUser = Optional.of(new User(1, "213123123", "gug21" , "teste@22", "6039393" , "q1231231" , "213213123" , "123213", "CE" ));
    }
}