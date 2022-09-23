package com.unitelformacaorest.service.mapa;

import com.unitelformacaorest.entidade.Funcionario;

import java.util.List;

public interface FuncionarioServico {

    void salvar(Funcionario funcionario);

    void eliminar(Long id);

    List<Funcionario> listarTodos();

    Funcionario procurarPorId(Long id);
}
