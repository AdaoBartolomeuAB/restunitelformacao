package com.unitelformacaorest.repositorio;

import com.unitelformacaorest.entidade.Funcionario;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario,Long> {

    List<Funcionario> findAll();
}
