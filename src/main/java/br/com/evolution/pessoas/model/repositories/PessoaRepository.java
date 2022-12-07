package br.com.evolution.pessoas.model.repositories;

import br.com.evolution.pessoas.model.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PessoaRepository extends JpaRepository<User, Integer> {
}
