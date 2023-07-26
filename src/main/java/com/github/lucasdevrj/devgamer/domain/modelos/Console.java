package com.github.lucasdevrj.devgamer.domain.modelos;

public class Console {
    private int codigo;
    private String nome;
    private float preco;
    private String descricao;

    public Console(int codigo, String nome, float preco, String descricao) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public float getPreco() {
        return preco;
    }

    public String getDescricao() {
        return descricao;
    }
}
