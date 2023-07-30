package com.github.lucasdevrj.devgamer;

import com.github.lucasdevrj.devgamer.domain.modelos.Console;
import com.github.lucasdevrj.devgamer.domain.modelos.ConsoleService;
import com.github.lucasdevrj.devgamer.domain.modelos.DadosConsole;

import java.util.Scanner;
import java.util.Set;

public class MenuJogo {
    private static Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    private static ConsoleService service = new ConsoleService();
    public static void main(String[] args) {
        exibeMenu();
    }

    public static void exibeMenu() {
        String menu = """
                1 - Cadastrar Jogo
                2 - Atualizar Jogo
                3 - Excluir Jogo
                4 - Listar Jogos
                5 - Sair
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

            case 4:
                listarConsoles();
                break;

            case 3:
                excluirConsole();
                break;
        }
        exibeMenu();
    }

    private static void cadastrarJogo() {
        System.out.print("Digite o código do console: ");
        int codigo = entrada.nextInt();

        System.out.print("Digite o nome do console: ");
        String nome = entrada.next();

        System.out.print("Digite o preço do console: ");
        float preco = entrada.nextFloat();

        System.out.print("Digite a descrição do console: ");
        String descricao = entrada.next();

        DadosConsole dadosConsole = new DadosConsole(codigo, nome, preco, descricao);

        service.cadastrar(dadosConsole);

        System.out.println("Console cadastrado com sucesso!\n");
    }

    private static void atualizarJogo() {
        System.out.print("Digite o código do console: ");
        int codigo = entrada.nextInt();

        service.buscarCodigoConsole(codigo);

        System.out.print("Digite o nome do console: ");
        String novoNome = entrada.next();

        System.out.print("Digite o preço do console: ");
        float novoPreco = entrada.nextFloat();

        System.out.print("Digite a descrição do console: ");
        String novaDescricao = entrada.next();

        DadosConsole dadosConsole = new DadosConsole(codigo, novoNome, novoPreco, novaDescricao);

        service.atualizar(codigo, dadosConsole);

        System.out.println("Console atualizado com sucesso!\n");
    }

    private static void excluirConsole() {
        System.out.print("Digite o código do console: ");
        int codigo = entrada.nextInt();

        service.excluir(codigo);

        System.out.println("Console excluído com sucesso!\n");
    }

    private static void listarConsoles() {
        Set<Console> consoles = service.listarConsoles();
        if (!consoles.isEmpty()) {
            System.out.println("Consoles cadastrados");
            consoles.stream().forEach(System.out::print);
        } else {
            System.err.println("Não existem consoles cadastrados!!\n");
        }
        System.out.println();
    }
}
