package com.unitelformacaorest.dto.funcionario;


import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class FuncionarioPost {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo telefone não pode ser nulo")
    private String telefone;

    @NotBlank(message = "O campo email não pode ser nulo")
    private String email;
}
