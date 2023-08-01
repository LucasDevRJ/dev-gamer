package com.github.lucasdevrj.devgamer.domain.console;

import com.github.lucasdevrj.devgamer.excecoes.RegrasDeNegocioException;

public class Console {
    private int codigo;
    private String nome;
    private float preco;
    private String descricao;

    public Console(DadosConsole dados) {
        this.setCodigo(dados.codigo());
        this.setNome(dados.nome());
        this.setPreco(dados.preco());
        this.setDescricao(dados.descricao());
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        if (codigo <= 0) {
            throw new RegrasDeNegocioException("Digite um código maior que zero!!");
        } else {
            this.codigo = codigo;
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        if (nome.isEmpty()) {
            throw new RegrasDeNegocioException("Digite o nome do console!!");
        } else {
            this.nome = nome;
        }
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco <= 0.0) {
            throw new RegrasDeNegocioException("Digite o preço do console!!");
        } else {
            this.preco = preco;
        }
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        if (descricao.isEmpty()) {
            throw new RegrasDeNegocioException("Digite a descrição do console!!");
        } else {
            this.descricao = descricao;
        }
    }

    @Override
    public String toString() {
        String informacoes = """
                Código: %d | Nome: %s | Preço: R$ %.2f | Descrição: %s
                """.formatted(this.codigo, this.nome, this.preco, this.descricao);
        return informacoes;
    }
}
