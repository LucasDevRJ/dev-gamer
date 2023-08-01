package com.github.lucasdevrj.devgamer.domain.console;

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

    public void atualizar(int codigo, DadosConsole dados) {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        consoleDAO.atualizar(codigo, dados);
    }

    public void excluir(int codigo) {
        Console console = buscarCodigoConsole(codigo);

        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        consoleDAO.excluir(codigo);
    }

    public Console buscarCodigoConsole(int codigo) {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        Console console = consoleDAO.listarPorCodigo(codigo);
        if (console != null) {
            return  console;
        } else {
            throw new NullPointerException("Não existe console cadastrado com esse código!!");
        }
    }

    public Set<Console> listarConsoles() {
        Connection conexao = this.conexao.conectar();
        ConsoleDAO consoleDAO = new ConsoleDAO(conexao);
        return consoleDAO.listar();
    }
}
