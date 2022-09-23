package com.unitelformacaorest.repositorio;

import com.unitelformacaorest.entidade.Funcionario;
import org.springframework.data.repository.CrudRepository;

public interface FuncionarioRepositorio extends CrudRepository<Funcionario,Long> {
}
