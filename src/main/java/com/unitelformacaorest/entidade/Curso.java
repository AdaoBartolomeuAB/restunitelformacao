package com.unitelformacaorest.entidade;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nome;

    private String duracao;

    private String area;

    private String foto;

    private String video;

    private String formador;

    private String descricao;

    private String requisito;

    private LocalDateTime dataHoraCriacao;

    private LocalDateTime dataHoraultimaaatualizacao;

    private boolean estado;
}
