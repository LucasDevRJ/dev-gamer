package com.github.lucasdevrj.devgamer;

import com.github.lucasdevrj.devgamer.menus.MenuConsole;
import com.github.lucasdevrj.devgamer.menus.MenuJogo;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Principal {
    private static Scanner entrada = new Scanner(System.in);
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
        int opcao = 0;
        try {
            opcao = entrada.nextInt();
        } catch (InputMismatchException erro) {
            throw new InputMismatchException("Digite somente números!!");
        }

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
                    exibeMenu();
        }
    }
}
