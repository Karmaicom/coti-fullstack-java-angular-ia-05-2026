package main.java;

import main.java.entites.Cliente;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.UUID;

public class Main {

    static void main(String[] args) {

        System.out.println("SISTEMA DE CADASTRO DE CLIENTES");
        System.out.println("Preencha os dados do cliente: ");

        // Criando um objeto para usarmos a classe Scanner do Java
        var scanner = new Scanner(System.in);

        // Criando um objeto para acessar o conteudo da classe cliente
        var cliente = new Cliente();

        cliente.id = UUID.randomUUID(); // gerando o ID do cliente
        cliente.dataHoraCadastro = LocalDateTime.now(); // gerando a data e hora atual

        System.out.print("\nInforme o nome do cliente.........: ");
        cliente.nome = scanner.nextLine();

        System.out.print("\nInforme o email...................: ");
        cliente.email = scanner.nextLine();

        System.out.print("\nInforme o telefone................: ");
        cliente.telefone = scanner.nextLine();

        System.out.print("\nInforme o cpf.....................: ");
        cliente.cpf = scanner.nextLine();

        //
        cliente.salvarDados();

    }

}
