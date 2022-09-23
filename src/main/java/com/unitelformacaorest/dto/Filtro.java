package com.unitelformacaorest.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class Filtro {

    @NotBlank(message = "o campo filtro não pode ser nulo")
    private String filtro;

}
