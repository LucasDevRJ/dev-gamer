package com.github.lucasdevrj.devgamer.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
    public static void main(String[] args) {
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/dev_gamer?user=root&password=root");
            System.out.println("Conexão com o banco de dados");
            conexao.close();
        } catch (SQLException erro) {
            System.out.println("Erro: " + erro.getMessage());
        }
    }
}
