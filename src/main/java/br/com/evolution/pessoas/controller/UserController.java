package br.com.evolution.pessoas.controller;

import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    private PessoaRepository pessoaRepository;
    @PostMapping
    public User newUser(User user){

    return null;
    }

}
