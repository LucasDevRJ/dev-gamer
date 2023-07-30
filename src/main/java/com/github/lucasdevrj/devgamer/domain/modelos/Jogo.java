package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.RegrasDeNegocioException;

public class Jogo {
    private int codigo;
    private String nome;
    private String plataforma;
    private float preco;

    public Jogo(DadosJogo dados) {
        this.setCodigo(dados.codigo());
        this.setNome(dados.nome());
        this.setPreco(dados.preco());
        this.setPlataforma(dados.plataforma);
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

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        this.plataforma = plataforma;
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
    @Override
    public String toString() {
        String informacoes = """
                Código: %d | Nome: %s | Preço: R$ %.2f | Descrição: %s
                """.formatted(this.codigo, this.nome, this.preco, this.descricao);
        return informacoes;
    }
}
