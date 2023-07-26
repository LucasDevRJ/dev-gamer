package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.conexao.ConexaoBancoDados;

import java.sql.Connection;

public class ConsoleService {
    private ConexaoBancoDados conexao;

    public ConsoleService() {
        this.conexao = new ConexaoBancoDados();
    }

    public void cadastrar(DadosConsole dados) {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        consoleDAO.salvar(dados);
    }
}
