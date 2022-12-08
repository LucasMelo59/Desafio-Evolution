package br.com.evolution.pessoas.service;

import br.com.evolution.pessoas.dto.UserDto;
import br.com.evolution.pessoas.model.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public User cadastrar(UserDto userDto);

    public List<User> listaDeUsuarios();

    public User detalhar(int id);

    public User atualizar(UserDto userDto);

    public void remover(int id);
}
