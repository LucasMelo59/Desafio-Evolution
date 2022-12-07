package br.com.evolution.pessoas.controller;

import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import br.com.evolution.pessoas.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> listar(){
        return null;
    }
    @PostMapping
    @Transactional
    public User newUser(@Valid User user){
    return userService.cadastrar(user);
    }

    @GetMapping("/{id}")
    public User detalhar(@PathVariable int id){
        return userService.detalhar(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));
    }


}
