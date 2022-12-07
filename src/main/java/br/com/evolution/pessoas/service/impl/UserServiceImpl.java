package br.com.evolution.pessoas.service.impl;

import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import br.com.evolution.pessoas.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private PessoaRepository pessoaRepository;
    @Override
    public User cadastrar(User user) {
        pessoaRepository.save(user);
        return user;
    }

    @Override
    public List<User> listaDeUsuarios() {
        return (List<User>) pessoaRepository.findAll();
    }

    @Override
    public Optional<User> detalhar(int id) {
        return pessoaRepository.findById(id);
    }

    @Override
    public Optional<User> atualizar(int id, User user) {
        Optional<User> users = pessoaRepository.findById(id);
        users.ifPresent( t -> {
            t = user;
            pessoaRepository.save(t);
        });
        return users;
    }

    @Override
    public void remover(int id) {
        Optional<User> remover = pessoaRepository.findById(id);
        if(remover.isPresent()){
            pessoaRepository.deleteById(id);
        } else {
         throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
    }
}
