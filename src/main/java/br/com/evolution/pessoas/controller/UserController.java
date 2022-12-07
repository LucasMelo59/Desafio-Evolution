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
        return userService.listaDeUsuarios();
    }
    @PostMapping
    @Transactional
    public User newUser(@Valid @RequestBody User user){
    return userService.cadastrar(user);
    }

    @GetMapping("/{id}")
    public User detalhar(@PathVariable("id") int id){
        return userService.detalhar(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Objeto não encontrado"));
    }

    @PutMapping("/{id}")
    @Transactional
    public User atualizar(@PathVariable("id") int id,@RequestBody @Valid User user){
        return userService.atualizar(id,user).orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        userService.remover(id);
    }
}
