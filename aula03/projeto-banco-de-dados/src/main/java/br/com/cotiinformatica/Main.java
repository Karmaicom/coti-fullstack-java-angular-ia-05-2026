package br.com.cotiinformatica;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.entities.Endereco;
import br.com.cotiinformatica.repositories.ClienteRepository;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var cliente = new Cliente();
        cliente.setId(UUID.randomUUID());

        cliente.setEndereco(new Endereco());
        cliente.getEndereco().setId(UUID.randomUUID());

        System.out.print("Nome do cliente.....: ");
        cliente.setNome(scanner.nextLine());

        System.out.print("CPF.................: ");
        cliente.setCpf(scanner.nextLine());

        System.out.print("Logradouro..........: ");
        cliente.getEndereco().setLogradouro(scanner.nextLine());

        System.out.print("Numero..............: ");
        cliente.getEndereco().setNumero(scanner.nextLine());

        System.out.print("Complemento.........: ");
        cliente.getEndereco().setComplemento(scanner.nextLine());

        System.out.print("Bairro..............: ");
        cliente.getEndereco().setBairro(scanner.nextLine());

        System.out.print("Cidade..............: ");
        cliente.getEndereco().setCidade(scanner.nextLine());

        System.out.print("UF..................: ");
        cliente.getEndereco().setUf(scanner.nextLine());

        System.out.print("CEP.................: ");
        cliente.getEndereco().setCep(scanner.nextLine());

        var repository = new ClienteRepository();
        repository.salvarDados(cliente);

        System.out.println("Cliente " + cliente.getNome() + " salvo com sucesso!");
    }
}