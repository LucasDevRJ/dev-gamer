package com.github.lucasdevrj.devgamer;

import java.util.Scanner;

public class Principal {
    public static Scanner entrada = new Scanner(System.in);
    public static void main(String[] args) {
        exibeMenu();
    }

    public static void exibeMenu() {
        String menu = """
                1 - Acessar Menu Console
                2 - Acessar Menu Jogo
                3 - Sair
                """;
        System.out.println(menu);
        System.out.print("Digite a opção desejada: ");
        int opcao = entrada.nextInt();

        switch (opcao) {
                case 1:
                    MenuConsole.exibeMenu();
                break;

                case 2:
                    MenuJogo.exibeMenu();
                break;

                case 3:
                    System.out.println("Programa finalizado.");
                break;

                default:
                    System.out.println("Opção inválida!");
        }
    }
}
