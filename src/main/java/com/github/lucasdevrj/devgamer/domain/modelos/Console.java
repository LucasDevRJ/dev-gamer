package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.RegrasDeNegocioException;

public class Console {
    private int codigo;
    private String nome;
    private float preco;
    private String descricao;

    public Console(DadosConsole dados) {
        if (codigo <= 0) {
            throw new RegrasDeNegocioException("Digite um código maior que zero!!");
        }
        if (nome.isEmpty()) {
            throw new RegrasDeNegocioException("Digite o nome do console!!");
        }
        if (preco <= 0.0) {
            throw new RegrasDeNegocioException("Digite o preço do console!!");
        }
        if (descricao.isEmpty()) {
            throw new RegrasDeNegocioException("Digite a descrição do console!!");
        }
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
