package br.com.cotiinformatica;

import br.com.cotiinformatica.controller.ProdutoController;

import java.util.ResourceBundle;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var bundleMessages = ResourceBundle.getBundle("messages");
        System.out.println(bundleMessages.getString("mensagem.boasvindas"));

        var controller = new ProdutoController();
        var scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU CRUD =====");
            System.out.println("1 - Cadastrar produto");
            System.out.println("2 - Listar produtos");
            System.out.println("3 - Buscar produto");
            System.out.println("4 - Atualizar produto");
            System.out.println("5 - Excluir produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    controller.inserirProduto();
                    break;

                case 2:
                    System.out.println(controller.consultar());
                    break;

                case 3:
                    System.out.println(controller.consultarPorId());
                    break;

                case 4:
                    controller.atualizarProduto();
                    break;

                case 5:
                    controller.excluirProduto();
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida!");
                    break;
            }

        } while (opcao != 0);
    }
}