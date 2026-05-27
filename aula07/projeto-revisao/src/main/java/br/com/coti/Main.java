package br.com.coti;

import br.com.coti.controllers.FuncionarioController;

import java.util.Scanner;

public class Main {
    static void main() {
        var controller = new FuncionarioController();
        var scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("\n===== MENU CRUD =====");
            System.out.println("1 - Cadastrar");
            System.out.println("2 - Listar");
            System.out.println("3 - Buscar por ID");
            System.out.println("4 - Atualizar");
            System.out.println("5 - Excluir");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine(); // limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("Opção: Cadastrar");
                    controller.cadastrarFuncionario(); //chamar metodo de cadastro
                    break;

                case 2:
                    System.out.println("Opção: Listar");
                    System.out.println(controller.listaFuncionarios()); // chamar metodo de listagem
                    break;

                case 3:
                    System.out.println("Opção: Buscar por ID");
                    // chamar metodo de busca
                    // buscarPorId();
                    break;

                case 4:
                    System.out.println("Opção: Atualizar");
                    // chamar metodo de atualização
                    // atualizar();
                    break;

                case 5:
                    System.out.println("Opção: Excluir");
                    // chamar metodo de exclusão
                    // excluir();
                    break;

                case 0:
                    System.out.println("Sistema finalizado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    break;
            }

        } while (opcao != 0);

        scanner.close();
    }
}
