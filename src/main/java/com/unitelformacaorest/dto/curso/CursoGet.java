package com.unitelformacaorest.dto.curso;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class CursoGet {

    private Long id;

    private String nome;

    private String duracao;

    private String area;

    private String foto;

    private String video;

    private String formador;

    private String descricao;

    private  String requisito;

    private LocalDateTime dataHoraCriacao;

    private LocalDateTime dataHoraultimaaatualizacao;

    private boolean estado;
}
