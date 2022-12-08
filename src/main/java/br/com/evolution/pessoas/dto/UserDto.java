package br.com.evolution.pessoas.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

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

}
