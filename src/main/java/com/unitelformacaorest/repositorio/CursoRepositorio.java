package com.unitelformacaorest.repositorio;

import com.unitelformacaorest.entidade.Curso;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CursoRepositorio extends CrudRepository<Curso,Long> {

    List<Curso> findAllByNomeContainingOrAreaContainingOrFormadorContaining(String nome, String area, String formador);

    List<Curso> findAll();

    List<Curso> findAllByEstadoTrue();

}
