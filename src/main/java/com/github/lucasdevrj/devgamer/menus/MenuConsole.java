package com.github.lucasdevrj.devgamer.menus;

import com.github.lucasdevrj.devgamer.Principal;
import com.github.lucasdevrj.devgamer.domain.console.Console;
import com.github.lucasdevrj.devgamer.domain.console.ConsoleService;
import com.github.lucasdevrj.devgamer.domain.console.DadosConsole;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

public class MenuConsole {
    private static Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    private static ConsoleService service = new ConsoleService();

    public static void exibeMenu() {
        String menu = """
                1 - Cadastrar Console
                2 - Atualizar Consoles
                3 - Excluir Console
                4 - Listar Consoles
                5 - Voltar
                """;
        System.out.println(menu);
        System.out.print("Digite a opção desejada: ");
        int opcao = 0;
        try {
            opcao = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        switch (opcao) {
                case 1:
                    cadastrarConsole();
                break;

                case 2:
                    atualizarConsole();
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

            default:
                System.out.println("Opção inválida!");
        }
    }

    private static void cadastrarConsole() {
        System.out.print("Digite o código do console: ");
        int codigo = 0;

        try {
            codigo = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        System.out.print("Digite o nome do console: ");
        String nome = entrada.next();

        System.out.print("Digite o preço do console: ");
        float preco = 0.0f;

        try {
            preco = entrada.nextFloat();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

        System.out.print("Digite a descrição do console: ");
        String descricao = entrada.next();

        DadosConsole dadosConsole = new DadosConsole(codigo, nome, preco, descricao);

        service.cadastrar(dadosConsole);

        System.out.println("Console cadastrado com sucesso!\n");
        exibeMenu();
    }

    private static void atualizarConsole() {
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
        exibeMenu();
    }

    private static void excluirConsole() {
        System.out.print("Digite o código do console: ");
        int codigo = entrada.nextInt();

        service.excluir(codigo);

        System.out.println("Console excluído com sucesso!\n");
        exibeMenu();
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
        exibeMenu();
    }
}
