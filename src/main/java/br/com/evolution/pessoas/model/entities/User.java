package br.com.evolution.pessoas.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Entity(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotNull(message = "preenche o cpf")
    private String cpf;
    @NotNull(message = "preenche o cpf")
    private String nome;
    @NotNull(message = "preenche o cpf")
    private String email;
    private String cep;
    private String longradouro;
    private String complemento;
    private String bairro;
    private String uf;

//    private List<ContatoUser> contatos;
}
