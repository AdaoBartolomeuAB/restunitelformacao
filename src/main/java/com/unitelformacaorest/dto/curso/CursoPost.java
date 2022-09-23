package com.unitelformacaorest.dto.curso;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class CursoPost {

    @NotBlank(message = "O campo nome não pode ser nulo")
    private String nome;

    @NotBlank(message = "O campo duração não pode ser nulo")
    private String duracao;

    @NotBlank(message = "O campo área não pode ser nulo")
    private String area;

    @NotBlank(message = "O campo foto não pode ser nulo")
    private String foto;

    @NotBlank(message = "O campo video não pode ser nulo")
    private String video;

    @NotBlank(message = "O campo formador não pode ser nulo")
    private String formador;

    @NotBlank(message = "O campo descricao não pode ser nulo")
    private String descricao;

    @NotBlank(message = "O campo requisito não pode ser nulo")
    private  String requisito;

}
