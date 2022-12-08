package br.com.evolution.pessoas.controller;

import br.com.evolution.pessoas.dto.UserDto;
import br.com.evolution.pessoas.exceptions.ObjectNotFoundException;
import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import br.com.evolution.pessoas.service.UserService;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/pessoas")
public class UserController {

    @Autowired
    private ModelMapper mapper;
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
    public ResponseEntity<UserDto> detalhar(@PathVariable(value = "id") int id){
        return ResponseEntity.ok().body(mapper.map(userService.detalhar(id), UserDto.class));
    }

    @PutMapping(value = "/{id}")
    @Transactional
    public ResponseEntity<UserDto> atualizar(@PathVariable Integer id ,@RequestBody @Valid UserDto userDto){
        userDto.setId(id);
        User newUser = userService.atualizar(userDto);
        return ResponseEntity.ok().body(mapper.map(newUser, UserDto.class));
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") int id){
        userService.remover(id);
    }
}
