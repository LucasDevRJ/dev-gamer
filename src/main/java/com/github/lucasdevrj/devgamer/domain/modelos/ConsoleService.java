package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.conexao.ConexaoBancoDados;

import java.sql.Connection;

public class ConsoleService {
    private ConexaoBancoDados conexao;

    public ConsoleService() {
        this.conexao = new ConexaoBancoDados();
    }

    public void cadastrar(Console console) {
        Connection conexao = this.conexao.conecta();
        Console consoleCriado = new Console(console.getCodigo(), console.getNome(), console.getPreco(), console.getDescricao());

    }
}
