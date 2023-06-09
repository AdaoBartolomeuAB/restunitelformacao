package com.unitelformacaorest.controlador;

import com.unitelformacaorest.dto.funcionario.FuncionarioGet;
import com.unitelformacaorest.dto.funcionario.FuncionarioPost;
import com.unitelformacaorest.entidade.Funcionario;
import com.unitelformacaorest.service.mapa.FuncionarioServico;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class FuncionarioControlador {

    @Autowired
    private FuncionarioServico funcionarioServico;

    @PostMapping(value = "/funcionario")
    public  ResponseEntity<FuncionarioGet> salvar(@Valid @RequestBody FuncionarioPost funcionarioPost){

        Funcionario funcionario = new Funcionario();
        BeanUtils.copyProperties(funcionarioPost,funcionario);
        funcionarioServico.salvar(funcionario);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(value = "/funcionarios")
    public ResponseEntity<List<FuncionarioGet>> listar(){

        List<FuncionarioGet> funcionarioGetList = new ArrayList<>();

        List<Funcionario> funcionarios = funcionarioServico.listarTodos();

        for (Funcionario funcionario : funcionarios){

            FuncionarioGet funcionarioGet = new FuncionarioGet();
            BeanUtils.copyProperties(funcionario,funcionarioGet);
            funcionarioGetList.add(funcionarioGet);
        }

        return new ResponseEntity<>(funcionarioGetList,HttpStatus.OK);
    }

    @GetMapping(value = "/funcionario/{idFuncionario}")
    public ResponseEntity<FuncionarioGet> procurarPorId(@PathVariable("idFuncionario") Long id ){

        Funcionario funcionario = funcionarioServico.procurarPorId(id);

        if (funcionario ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        FuncionarioGet funcionarioGet = new FuncionarioGet();

        BeanUtils.copyProperties(funcionario,funcionarioGet);

        return new ResponseEntity<>(funcionarioGet,HttpStatus.OK);
    }

    @DeleteMapping(value = "/funcionario/{idFuncionario}")
    public ResponseEntity<Void> eliminar(@PathVariable("idFuncionario") Long id ){

        Funcionario funcionario = funcionarioServico.procurarPorId(id);

        if (funcionario ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        funcionarioServico.eliminar(funcionario.getId());

        return new ResponseEntity<>(HttpStatus.OK);
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
