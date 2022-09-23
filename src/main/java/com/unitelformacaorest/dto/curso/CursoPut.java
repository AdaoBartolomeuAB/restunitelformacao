package com.unitelformacaorest.dto.curso;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CursoPut {

    private String nome;

    private String duracao;

    private String area;

    private String foto;

    private String video;

    private String formador;

    private String descricao;

    private  String requisito;
}
