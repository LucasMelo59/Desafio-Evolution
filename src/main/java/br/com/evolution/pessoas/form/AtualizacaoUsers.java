package br.com.evolution.pessoas.form;

import jakarta.validation.constraints.NotNull;

public class AtualizacaoUsers {
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
}
