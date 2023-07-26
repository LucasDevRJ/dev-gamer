package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.conexao.ConexaoBancoDados;

import java.sql.Connection;
import java.util.HashSet;
import java.util.Set;

public class ConsoleService {
    private ConexaoBancoDados conexao;
    private Set<Console> consoles = new HashSet<>();

    public ConsoleService() {
        this.conexao = new ConexaoBancoDados();
    }

    public void cadastrar(DadosConsole dados) {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        consoleDAO.salvar(dados);
    }

    public Set<Console> listarConsoles() {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        return consoleDAO.listar();
    }
}
