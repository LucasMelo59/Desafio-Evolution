package br.com.evolution.pessoas.service;

import br.com.evolution.pessoas.model.entities.User;

import java.util.Optional;

public interface UserService {

    public User cadastrar(User user);

    public Optional<User> detalhar(int id);

    public Optional<User> atualizar(int id, User user );

    public void remover(int id);
}
