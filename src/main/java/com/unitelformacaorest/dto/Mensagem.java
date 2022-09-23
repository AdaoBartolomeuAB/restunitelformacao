package com.unitelformacaorest.dto;


import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Mensagem {

    private String mensagem;

    private LocalDate data;
}
