package br.com.evolution.pessoas.service.impl;

import br.com.evolution.pessoas.dto.UserDto;
import br.com.evolution.pessoas.exceptions.ObjectNotFoundException;
import br.com.evolution.pessoas.model.entities.User;
import br.com.evolution.pessoas.model.repositories.PessoaRepository;
import br.com.evolution.pessoas.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private ModelMapper mapper;
    @Override
    public User cadastrar(User user) {
        pessoaRepository.save(user);
        return user;
    }

    @Override
    public List<User> listaDeUsuarios() {
        return pessoaRepository.findAll();
    }

    @Override
    public User detalhar(int id) {
        Optional<User> obj  =  pessoaRepository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Objetvo nao encontrado"));
    }

    @Override
    public User atualizar(UserDto userDto) {
        return pessoaRepository.save(mapper.map(userDto, User.class)) ;
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
