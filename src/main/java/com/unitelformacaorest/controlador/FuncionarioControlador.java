package com.unitelformacaorest.controlador;

import com.unitelformacaorest.dto.FuncionarioPost;
import com.unitelformacaorest.entidade.Funcionario;
import com.unitelformacaorest.repositorio.FuncionarioRepositorio;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FuncionarioControlador {

    @Autowired
    private FuncionarioRepositorio funcionarioRepositorio;

    @PostMapping(value = "/funcionario")
    public String procurarPorId(@RequestBody FuncionarioPost funcionarioPost){

        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioPost,funcionario);
        funcionarioRepositorio.save(funcionario);
        return "Dados salvos";
    }

    @GetMapping(value = "/funcionarios")
    public List<Funcionario> listar(){
        return listarFuncionarios();
    }

    @GetMapping(value = "/funcionario/{idFuncionario}")
    public Funcionario procurarPorId(@PathVariable("idFuncionario") long id ){

        for (Funcionario funcionario : listarFuncionarios()){
            if (funcionario.getId() == id)
                return funcionario;
        }

        return null;
    }


    @DeleteMapping(value = "/funcionario/{idFuncionario}")
    public List<Funcionario> eliminar(@PathVariable("idFuncionario") long id ){

        List<Funcionario> funcionarios = listarFuncionarios();

        for (Funcionario funcionario : funcionarios){

            if (funcionario.getId() == id)
                funcionarios.remove(funcionario);

        }

        return funcionarios;
    }


    public List<Funcionario> listarFuncionarios(){
        List<Funcionario> funcionarios = new ArrayList<>();

        Funcionario f1 = new Funcionario();
        f1.setId(1L);
        f1.setNome("Andreia");
        f1.setTelefone("9000000");
        f1.setEmail("andrea@gmail.com");

        funcionarios.add(f1);

        Funcionario f2 = new Funcionario();
        f2.setId(2L);
        f2.setNome("Dinís");
        f2.setTelefone("90000001");
        f2.setEmail("dinís@gmail.com");

        funcionarios.add(f2);

        Funcionario f3 = new Funcionario();
        f3.setId(3L);
        f3.setNome("Evandro");
        f3.setTelefone("92400101");
        f3.setEmail("evandro@unitel.co.ao");

        funcionarios.add(f3);

        return funcionarios;
    }

}
