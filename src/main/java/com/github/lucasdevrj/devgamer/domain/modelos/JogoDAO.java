package com.github.lucasdevrj.devgamer.domain.modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

public class JogoDAO {
    private Connection conexao;
    public JogoDAO(Connection conexao) {
        this.conexao = conexao;
    }
    public void salvar(DadosJogo dados) {
        Jogo jogo = new Jogo(dados);

        String sql = "INSERT INTO jogo(codigo, nome, plataforma, preco) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement parametro = this.conexao.prepareStatement(sql);
            parametro.setInt(1, jogo.getCodigo());
            parametro.setString(2, jogo.getNome());
            parametro.setString(3, jogo.getPlataforma());
            parametro.setFloat(4, jogo.getPreco());
            parametro.execute();
            parametro.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }

    public void excluir(int codigo) {
        String sql = "DELETE FROM jogo WHERE codigo = ?";

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

    public Set<Jogo> listar() {
        PreparedStatement parametro;
        ResultSet resultSet;
        Set<Jogo> jogos = new HashSet<Jogo>();
        String sql = "SELECT * FROM jogo";

        try {
            parametro = this.conexao.prepareStatement(sql);
            resultSet = parametro.executeQuery();

            while (resultSet.next()) {
                int codigo = resultSet.getInt(1);
                String nome = resultSet.getString(2);
                String plataforma = resultSet.getString(3);
                float preco = resultSet.getFloat(4);

                DadosJogo dadosJogo = new DadosJogo(codigo, nome, plataforma, preco);
                Jogo jogo = new Jogo(dadosJogo);
                jogos.add(jogo);
            }
            parametro.close();
            resultSet.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
        return jogos;
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

    public void atualizar(int codigo, DadosConsole dados) {
        PreparedStatement parametro;
        Console console = new Console(dados);
        String sql = "UPDATE console SET nome = ?, preco = ?, descricao = ? WHERE codigo = ?";

        try {
            this.conexao.setAutoCommit(false);
            parametro = this.conexao.prepareStatement(sql);

            parametro.setString(1, dados.nome());
            parametro.setFloat(2, dados.preco());
            parametro.setString(3, dados.descricao());
            parametro.setInt(4, dados.codigo());

            parametro.execute();
            this.conexao.commit();
            parametro.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
