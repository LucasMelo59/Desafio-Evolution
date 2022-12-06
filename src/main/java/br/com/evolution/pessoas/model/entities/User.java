package br.com.evolution.pessoas.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.lang.NonNull;

import java.util.ArrayList;
import java.util.List;
@Entity
@Getter
@Setter
public class User {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank
    private String cpf;
    @NotBlank
    private String nome;
    @NotBlank
    private String email;
    @NotBlank
    private String cep;
    private String longradouro;
    private String complemento;
    private String bairro;
    private String uf;
    private List<ContatoUser> contatos = new ArrayList<>();


}
