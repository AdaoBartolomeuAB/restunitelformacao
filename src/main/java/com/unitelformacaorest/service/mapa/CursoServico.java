package com.unitelformacaorest.service.mapa;

import com.unitelformacaorest.dto.curso.CursoPost;
import com.unitelformacaorest.dto.curso.CursoPut;
import com.unitelformacaorest.entidade.Curso;

import java.util.List;

public interface CursoServico {

    void eliminar(Long id);

    void salvar(Curso curso);

    void atualizar(Curso curso, CursoPut cursoPut);

    void alterarEstadoParaIndisponivel(Curso curso);

    void alterarEstadoParadisponivel(Curso curso);

    Curso procurarPorId(Long id);

    List<Curso> pesquisarPorNomeOuFormadorOuArea(String campo);

    List<Curso> listarTodos();

    List<Curso> listarDisponiveis();

}
