package br.com.evolution.pessoas.service.impl;

import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import br.com.evolution.pessoas.service.UserService;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private PessoaRepository pessoaRepository;
    @Override
    public User cadastrar(User user) {
        User newUser = new User(user.getCpf(), user.getNome(), user.getEmail(), user.getCep(),user.getLongradouro(), user.getComplemento(), user.getBairro(), user.getUf(), user.getContatos());
        pessoaRepository.save(newUser);
        return newUser;
    }

    @Override
    public Optional<User> detalhar(int id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Optional<User> atualizar(int id, User user) {
        return Optional.empty();
    }

    @Override
    public void remover(int id) {

    }
}
