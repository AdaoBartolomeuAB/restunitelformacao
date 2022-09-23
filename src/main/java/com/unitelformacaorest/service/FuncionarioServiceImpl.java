package com.unitelformacaorest.service;

import com.unitelformacaorest.entidade.Funcionario;
import com.unitelformacaorest.repositorio.FuncionarioRepositorio;
import com.unitelformacaorest.service.mapa.FuncionarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @Override
    public void salvar(Funcionario funcionario) {
        funcionarioRepositorio.save(funcionario);
    }

    @Override
    public void eliminar(Long id) {
        funcionarioRepositorio.deleteById(id);
    }

    @Override
    public List<Funcionario> listarTodos() {
        return funcionarioRepositorio.findAll();
    }

    @Override
    public Funcionario procurarPorId(Long id) {
        return funcionarioRepositorio.findById(id).orElse(null);
    }
}
