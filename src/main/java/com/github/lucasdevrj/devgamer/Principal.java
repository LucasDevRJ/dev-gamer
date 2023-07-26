package com.github.lucasdevrj.devgamer;

import com.github.lucasdevrj.devgamer.domain.modelos.ConsoleService;
import com.github.lucasdevrj.devgamer.domain.modelos.DadosConsole;

import java.util.Scanner;

public class Principal {
    private static Scanner entrada = new Scanner(System.in).useDelimiter("\n");
    private static ConsoleService service = new ConsoleService();
    public static void main(String[] args) {
        exibeMenu();
    }

    public static void exibeMenu() {
        String menu = """
                1 - Cadastrar Console
                2 - Atualizar Consoles
                3 - Excluir Console
                4 - Listar Consoles
                5 - Sair
                """;
        System.out.println(menu);
        System.out.print("Digite a opção desejada: ");
        int opcao = entrada.nextInt();

        switch (opcao) {
            case 1:
                cadastrarConsole();
        }
    }

    private static void cadastrarConsole() {
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

        entrada.next();
    }
}
