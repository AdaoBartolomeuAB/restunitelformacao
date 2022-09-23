package com.unitelformacaorest.service;

import com.unitelformacaorest.dto.curso.CursoPost;
import com.unitelformacaorest.dto.curso.CursoPut;
import com.unitelformacaorest.entidade.Curso;
import com.unitelformacaorest.repositorio.CursoRepositorio;
import com.unitelformacaorest.service.mapa.CursoServico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class CursoServicoImpl implements CursoServico {

    @Autowired
    private CursoRepositorio cursoRepositorio;

    @Override
    public Curso procurarPorId(Long id) {
        return cursoRepositorio.findById(id).orElse(null);
    }

    @Override
    public void eliminar(Long id) {
        cursoRepositorio.deleteById(id);
    }

    @Override
    public void salvar(Curso curso) {

        curso.setDataHoraCriacao(LocalDateTime.now());
        curso.setEstado(false);
        cursoRepositorio.save(curso);
    }

    @Override
    public void atualizar(Curso curso, CursoPut cursoPut) {

        if (cursoPut.getArea()!=null){
            curso.setArea(cursoPut.getArea());
        }

        if (cursoPut.getDescricao()!=null){
            curso.setDescricao(cursoPut.getDescricao());
        }

        if (cursoPut.getNome()!=null){
            curso.setNome(cursoPut.getNome());
        }

        if (cursoPut.getFoto()!=null){
            curso.setFoto(cursoPut.getFoto());
        }

        if (cursoPut.getFormador()!=null){
            curso.setFormador(cursoPut.getFormador());
        }


        if (cursoPut.getVideo()!=null){
            curso.setVideo(cursoPut.getVideo());
        }

        if (cursoPut.getRequisito()!=null){
            curso.setRequisito(cursoPut.getRequisito());
        }

        if (cursoPut.getDuracao()!=null){
            curso.setDuracao(cursoPut.getDuracao());
        }

        curso.setDataHoraultimaaatualizacao(LocalDateTime.now());
        cursoRepositorio.save(curso);
    }

    @Override
    public void alterarEstadoParaIndisponivel(Curso curso) {
        curso.setEstado(false);
        cursoRepositorio.save(curso);
    }

    @Override
    public void alterarEstadoParadisponivel(Curso curso) {
        curso.setEstado(true);
        cursoRepositorio.save(curso);
    }

    @Override
    public List<Curso> pesquisarPorNomeOuFormadorOuArea(String campo) {
        return cursoRepositorio.findAllByNomeContainingOrAreaContainingOrFormadorContaining(campo,campo,campo);
    }

    @Override
    public List<Curso> listarTodos() {
        return cursoRepositorio.findAll();
    }

    @Override
    public List<Curso> listarDisponiveis() {
        return cursoRepositorio.findAllByEstadoTrue();
    }
}
