package com.github.lucasdevrj.devgamer.domain.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ConsoleDAO {
    private Connection conexao;

    public ConsoleDAO(Connection conexao) {
        this.conexao = conexao;
    }

    public void salvar(DadosConsole dados) {
        Console console = new Console(dados);

        String sql = "INSERT INTO console(codigo, nome, preco, descricao) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement parametro = this.conexao.prepareStatement(sql);
            parametro.setInt(1, console.getCodigo());
            parametro.setString(2, console.getNome());
            parametro.setFloat(3, console.getPreco());
            parametro.setString(4, console.getDescricao());
            parametro.execute();
            parametro.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
