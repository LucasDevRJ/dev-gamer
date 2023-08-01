package com.github.lucasdevrj.devgamer.domain.modelos;

import com.github.lucasdevrj.devgamer.excecoes.RegrasDeNegocioException;

public class Jogo {
    private int codigo;
    private String nome;
    private String plataforma;
    private float preco;

    public Jogo(DadosJogo dados) {
        this.setCodigo(dados.codigo());
        this.setNome(dados.nome());
        this.setPreco(dados.preco());
        this.setPlataforma(dados.plataforma());
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
            throw new RegrasDeNegocioException("Digite o nome do jogo!!");
        } else {
            this.nome = nome;
        }
    }

    public String getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(String plataforma) {
        if (plataforma.isEmpty()) {
            throw new RegrasDeNegocioException("Digite a plataforma do jogo!!");
        } else {
            this.plataforma = plataforma;
        }
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        if (preco <= 0.0) {
            throw new RegrasDeNegocioException("Digite o preço do jogo!!");
        } else {
            this.preco = preco;
        }
    }
    @Override
    public String toString() {
        String informacoes = """
                Código: %d | Nome: %s | Plataforma: %s | Preço: R$ %.2f
                """.formatted(this.codigo, this.nome, this.plataforma, this.preco);
        return informacoes;
    }
}
