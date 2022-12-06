package br.com.evolution.pessoas.model.repositories;

import br.com.evolution.pessoas.model.entities.User;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<User, Integer> {
}
