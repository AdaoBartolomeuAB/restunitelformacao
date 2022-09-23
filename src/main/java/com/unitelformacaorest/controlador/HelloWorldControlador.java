package com.unitelformacaorest.controlador;


import com.unitelformacaorest.dto.HelloWorld;
import com.unitelformacaorest.dto.Mensagem;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping(value = "/api")
@Api(tags = {"Cursos"})
public class HelloWorldControlador {

    @GetMapping(value = "/hello/world")
    public String helloWorld(){
        return "Hello World";
    }

    @GetMapping(value = "/hello/world/nome")
    public Mensagem helloWorldNome(@RequestBody HelloWorld helloWorld){
        Mensagem mensagem = new Mensagem();
        mensagem.setMensagem("Hello World "+helloWorld.getNome());
        mensagem.setData(LocalDate.now());
        return mensagem;
    }

}
