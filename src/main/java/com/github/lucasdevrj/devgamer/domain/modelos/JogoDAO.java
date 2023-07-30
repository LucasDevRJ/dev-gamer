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

    public Jogo listarPorCodigo(int codigo) {
        PreparedStatement parametro;
        ResultSet resultSet;
        Jogo jogo = null;
        String sql = "SELECT * FROM jogo WHERE codigo = ?";

        try {
            parametro = this.conexao.prepareStatement(sql);
            parametro.setInt(1, codigo);
            resultSet = parametro.executeQuery();

            while (resultSet.next()) {
                int codigoJogo = resultSet.getInt(1);
                String nomeJogo = resultSet.getString(2);
                String plataformaJogo = resultSet.getString(3);
                float precoJogo = resultSet.getFloat(4);

                DadosJogo dadosJogo = new DadosJogo(codigoJogo, nomeJogo, plataformaJogo, precoJogo);
                jogo = new Jogo(dadosJogo);
            }
            parametro.close();
            resultSet.close();
            this.conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
        return jogo;
    }

    public void atualizar(int codigo, DadosJogo dados) {
        PreparedStatement parametro;
        Jogo console = new Jogo(dados);
        String sql = "UPDATE jogo SET nome = ?, plataforma = ?, preco = ? WHERE codigo = ?";

        try {
            this.conexao.setAutoCommit(false);
            parametro = this.conexao.prepareStatement(sql);

            parametro.setString(1, dados.nome());
            parametro.setString(2, dados.plataforma());
            parametro.setFloat(3, dados.preco());
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
