package com.github.lucasdevrj.devgamer.domain.modelos;

public class Console {
    private int codigo;
    private String nome;
    private float preco;
    private String descricao;

    public Console(DadosConsole dados) {
        this.codigo = dados.codigo();
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.descricao = dados.descricao();
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

    @Override
    public String toString() {
        return "Código: " + this.codigo +
                " |Nome: " + this.nome +
                " |Preço: " + this.preco +
                " |Descrição: " + this.descricao;
    }
}
