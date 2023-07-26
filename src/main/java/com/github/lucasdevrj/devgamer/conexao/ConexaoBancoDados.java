package com.github.lucasdevrj.devgamer.conexao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {
    public Connection conectar() {
        try {
            return criaFonteDados().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //método para limitar as conexões com o banco
    private HikariDataSource criaFonteDados() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl("jdbc:mysql://localhost:3306/dev_gamer");
        config.setUsername("root");
        config.setPassword("root");
        config.setMaximumPoolSize(10);

        return new HikariDataSource(config);
    }
}