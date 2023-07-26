package com.github.lucasdevrj.devgamer.domain.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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

    public void excluir(int codigo) {
        String sql = "DELETE FROM console WHERE codigo = ?";

        try {
            PreparedStatement parametro = this.conexao.prepareStatement(sql);
            parametro.setInt(1, codigo);
            parametro.execute();
            parametro.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public Set<Console> listar() {
        PreparedStatement parametro;
        ResultSet resultSet;
        Set<Console> consoles = new HashSet<Console>();
        String sql = "SELECT * FROM console";

        try {
            parametro = this.conexao.prepareStatement(sql);
            resultSet = parametro.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                float preco = resultSet.getFloat(3);
                String descricao = resultSet.getString(4);

                DadosConsole dadosConsole = new DadosConsole(codigo, nome, preco, descricao);
                Console console = new Console(dadosConsole);
                consoles.add(console);
            }
            parametro.close();
            resultSet.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
        return consoles;
    }

    public Console listarPorCodigo(int codigo) {
        PreparedStatement parametro;
        ResultSet resultSet;
        Console console = null;
        String sql = "SELECT * FROM console WHERE codigo = ?";

        try {
            parametro = this.conexao.prepareStatement(sql);
            parametro.setInt(1, codigo);
            resultSet = parametro.executeQuery();

            while (resultSet.next()) {
                int codigoConsole = resultSet.getInt(1);
                String nomeConsole = resultSet.getString(2);
                float precoConsole = resultSet.getFloat(3);
                String descricaoConsole = resultSet.getString(4);

                DadosConsole dadosConsole = new DadosConsole(codigoConsole, nomeConsole, precoConsole, descricaoConsole);
                console = new Console(dadosConsole);
            }
            parametro.close();
            resultSet.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
        return console;
    }
}
