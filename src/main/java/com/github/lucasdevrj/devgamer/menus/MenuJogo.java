package com.github.lucasdevrj.devgamer.menus;

import com.github.lucasdevrj.devgamer.domain.jogo.*;
import com.github.lucasdevrj.devgamer.Principal;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MenuJogo {
    private static Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    private static JogoService service = new JogoService();

    public static void exibeMenu() {
        String menu = """
                1 - Cadastrar Jogo
                2 - Atualizar Jogo
                3 - Excluir Jogo
                4 - Listar Jogos
                5 - Voltar
                """;
        System.out.println(menu);
        System.out.print("Digite a opção desejada: ");
        int opcao = entrada.nextInt();

        switch (opcao) {
                case 1:
                    cadastrarJogo();
                break;

                case 2:
                    atualizarJogo();
                break;

                case 3:
                    excluirConsole();
                break;

                case 4:
                    listarConsoles();
                break;

                case 5:
                    Principal.exibeMenu();
                break;
        }
    }

    private static void cadastrarJogo() {
        System.out.print("Digite o código do jogo: ");
        int codigo = 0;

        try {
            codigo = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        System.out.print("Digite o nome do jogo: ");
        String nome = entrada.next();

        System.out.print("Digite a plataforma do jogo: ");
        String plataforma = entrada.next();

        System.out.print("Digite o preço do jogo: ");
        float preco = 0.0f;

        try {
            preco = entrada.nextFloat();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        DadosJogo dadosJogo = new DadosJogo(codigo, nome, plataforma, preco);

        service.cadastrar(dadosJogo);

        System.out.println("Jogo cadastrado com sucesso!\n");
        exibeMenu();
    }

    private static void atualizarJogo() {
        System.out.print("Digite o código do jogo: ");
        int codigo = 0;

        try {
            codigo = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        service.buscarCodigoJogo(codigo);

        System.out.print("Digite o nome do jogo: ");
        String novoNome = entrada.next();

        System.out.print("Digite a plataforma do jogo: ");
        String novaPlataforma = entrada.next();

        System.out.print("Digite o preço do jogo: ");
        float novoPreco = 0.0f;

        try {
            novoPreco = entrada.nextFloat();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        DadosJogo dadosJogo = new DadosJogo(codigo, novoNome, novaPlataforma, novoPreco);

        service.atualizar(codigo, dadosJogo);

        System.out.println("Jogo atualizado com sucesso!\n");
        exibeMenu();
    }

    private static void excluirConsole() {
        System.out.print("Digite o código do jogo: ");
        int codigo = 0;

        try {
            codigo = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        service.excluir(codigo);

        System.out.println("Jogo excluído com sucesso!\n");
        exibeMenu();
    }

    private static void listarConsoles() {
        Set<Jogo> jogos = service.listarJogos();
        if (!jogos.isEmpty()) {
            System.out.println("Jogos cadastrados");
            jogos.stream().forEach(System.out::print);
        } else {
            System.err.println("Não existem jogos cadastrados!!\n");
        }
        System.out.println();
        exibeMenu();
    }
}
