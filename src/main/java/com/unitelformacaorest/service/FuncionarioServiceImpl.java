package com.unitelformacaorest.service;

import com.unitelformacaorest.entidade.Funcionario;
import com.unitelformacaorest.repositorio.FuncionarioRepositorio;
import com.unitelformacaorest.service.mapa.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarioRepositorio.save(funcionario);
    }
}
