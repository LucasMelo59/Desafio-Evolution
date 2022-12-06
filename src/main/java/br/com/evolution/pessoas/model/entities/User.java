package br.com.evolution.pessoas.model.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
    @NonNull
    private String cpf;
    private String nome;
    private String email;
    private String cep;
    private String longradouro;
    private String complemento;
    private String bairro;
    private String uf;
    private List<ContatoUser> contatos = new ArrayList<>();

    public User( @NonNull String cpf, String nome, String email, String cep, String longradouro, String complemento, String bairro, String uf, List<ContatoUser> contatos) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
        this.cep = cep;
        this.longradouro = longradouro;
        this.complemento = complemento;
        this.bairro = bairro;
        this.uf = uf;
        this.contatos = contatos;
    }
}
