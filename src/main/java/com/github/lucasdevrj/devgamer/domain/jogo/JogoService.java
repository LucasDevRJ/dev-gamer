package com.github.lucasdevrj.devgamer.domain.jogo;

import com.github.lucasdevrj.devgamer.conexao.ConexaoBancoDados;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class JogoService {
    private ConexaoBancoDados conexao;
    private Set<Jogo> jogos = new HashSet<>();

    public JogoService() {
        this.conexao = new ConexaoBancoDados();
    }

    public void cadastrar(DadosJogo dados) {
        Connection conexao = this.conexao.conectar();
        JogoDAO consoleDAO = new JogoDAO(conexao);
        consoleDAO.salvar(dados);
    }

    public void atualizar(int codigo, DadosJogo dados) {
        Connection conexao = this.conexao.conectar();
        JogoDAO jogoDAO = new JogoDAO(conexao);
        jogoDAO.atualizar(codigo, dados);
    }

    public void excluir(int codigo) {
        Jogo jogo = buscarCodigoJogo(codigo);

        Connection conexao = this.conexao.conectar();
        JogoDAO jogoDAO = new JogoDAO(conexao);
        jogoDAO.excluir(codigo);
    }

    public Jogo buscarCodigoJogo(int codigo) {
        Connection conexao = this.conexao.conectar();
        JogoDAO jogoDAO = new JogoDAO(conexao);
        Jogo jogo = jogoDAO.listarPorCodigo(codigo);
        if (jogo != null) {
            return  jogo;
        } else {
            throw new NullPointerException("Não existe jogo cadastrado com esse código!!");
        }
    }

    public Set<Jogo> listarJogos() {
        Connection conexao = this.conexao.conectar();
        JogoDAO jogoDAO = new JogoDAO(conexao);
        return jogoDAO.listar();
    }
}
