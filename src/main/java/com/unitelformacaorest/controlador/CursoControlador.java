package com.unitelformacaorest.controlador;

import com.unitelformacaorest.dto.Filtro;
import com.unitelformacaorest.dto.curso.CursoGet;
import com.unitelformacaorest.dto.curso.CursoPost;
import com.unitelformacaorest.dto.curso.CursoPut;
import com.unitelformacaorest.entidade.Curso;
import com.unitelformacaorest.service.mapa.CursoServico;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api")
@Api(value = "Curso", description = "RestController do curso", tags = {"Cursos"})
public class CursoControlador {

    @Autowired
    private CursoServico cursoServico;

    @ApiOperation(value= "Salvar curso")
    @PostMapping(value = "/curso")
    public ResponseEntity<Void> salvar(@Valid @RequestBody CursoPost cursoPost){

        Curso curso = new Curso();
        BeanUtils.copyProperties(cursoPost,curso);
        cursoServico.salvar(curso);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value= "Atualizar curso")
    @PutMapping(value = "/curso/{id}")
    public ResponseEntity<Void> salvar(@PathVariable Long id, @RequestBody CursoPut cursoPut){

        Curso curso = cursoServico.procurarPorId(id);

        if (curso ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        cursoServico.atualizar(curso,cursoPut);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value= "Eliminar curso")
    @DeleteMapping(value = "/curso/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id ){

        Curso curso = cursoServico.procurarPorId(id);

        if (curso ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (curso.isEstado()) return new ResponseEntity<>(HttpStatus.CONFLICT);

        cursoServico.eliminar(curso.getId());

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value= "Filtro cursos por nome, formador e área")
    @GetMapping(value = "/curso/filtro")
    public ResponseEntity<List<CursoGet>> atualizar(@RequestBody Filtro filtro){

        List<CursoGet> cursoGets = new ArrayList<>();

        List<Curso> cursos = cursoServico.pesquisarPorNomeOuFormadorOuArea(filtro.getFiltro());

        for (Curso curso : cursos){

            CursoGet cursoGet = new CursoGet();
            BeanUtils.copyProperties(curso,cursoGet);
            cursoGets.add(cursoGet);
        }

        return new ResponseEntity<>(cursoGets,HttpStatus.OK);
    }

    @ApiOperation(value= "Procurar curso por id")
    @GetMapping(value = "/curso/{id}")
    public ResponseEntity<CursoGet> procurarPorId(@PathVariable Long id ){

        Curso curso = cursoServico.procurarPorId(id);

        if (curso ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        CursoGet cursoGet = new CursoGet();

        BeanUtils.copyProperties(curso,cursoGet);

        return new ResponseEntity<>(cursoGet,HttpStatus.OK);
    }

    @ApiOperation(value= "Alterar estado do curso para disponível")
    @PatchMapping(value = "/curso/{id}/estado")
    public ResponseEntity<Void> atualizarEstadoParaDisponivel(@PathVariable Long id ){

        Curso curso = cursoServico.procurarPorId(id);

        if (curso ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (curso.isEstado()) return new ResponseEntity<>(HttpStatus.CONFLICT);

        cursoServico.alterarEstadoParadisponivel(curso);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value= "Alterar estado do curso para indisponível")
    @DeleteMapping(value = "/curso/{id}/estado")
    public ResponseEntity<Void> atualizarEstadoParaInDisponivel(@PathVariable Long id ){

        Curso curso = cursoServico.procurarPorId(id);

        if (curso ==null) return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        if (!curso.isEstado()) return new ResponseEntity<>(HttpStatus.CONFLICT);

        cursoServico.alterarEstadoParaIndisponivel(curso);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @ApiOperation(value= "Listar todos os cursos")
    @GetMapping(value = "/cursos")
    public ResponseEntity<List<CursoGet>> listar(){

        List<CursoGet> cursoGets = new ArrayList<>();

        List<Curso> cursos = cursoServico.listarTodos();

        for (Curso curso : cursos){

            CursoGet cursoGet = new CursoGet();
            BeanUtils.copyProperties(curso,cursoGet);
            cursoGets.add(cursoGet);
        }

        return new ResponseEntity<>(cursoGets,HttpStatus.OK);
    }

    @ApiOperation(value= "Listar todos os cursos disponíveis")
    @GetMapping(value = "/cursos/disponiveis")
    public ResponseEntity<List<CursoGet>> listarDisponiveis(){

        List<CursoGet> cursoGets = new ArrayList<>();

        List<Curso> cursos = cursoServico.listarDisponiveis();

        for (Curso curso : cursos){

            CursoGet cursoGet = new CursoGet();
            BeanUtils.copyProperties(curso,cursoGet);
            cursoGets.add(cursoGet);
        }

        return new ResponseEntity<>(cursoGets,HttpStatus.OK);
    }
}
