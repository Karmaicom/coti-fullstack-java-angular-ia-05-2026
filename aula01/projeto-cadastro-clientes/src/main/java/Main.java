package main.java;

import main.java.entites.Cliente;

import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

        // Formatar data
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        cliente.id = UUID.randomUUID(); // gerando o ID do cliente
        cliente.dataHoraCadastro = LocalDateTime.now(); // gerando a data e hora atual

        System.out.print("Informe o nome do cliente.........: ");
        cliente.nome = scanner.nextLine();

        System.out.print("Informe o email...................: ");
        cliente.email = scanner.nextLine();

        System.out.print("Informe o telefone................: ");
        cliente.telefone = scanner.nextLine();

        System.out.print("Informe o cpf.....................: ");
        cliente.cpf = scanner.nextLine();

        System.out.print("Informe a data de nascimento......: ");
        cliente.dataNascimento = LocalDate.parse(scanner.nextLine(), formatador);

        System.out.print("Informe a sua profissao...........: ");
        cliente.profissao = scanner.nextLine();

        // Exportar os dados do cliente para um arquivo
        cliente.salvarDados();

    }

}
