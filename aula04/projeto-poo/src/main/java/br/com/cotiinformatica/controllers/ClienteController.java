package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.entities.Cliente;
import br.com.cotiinformatica.services.ClienteService;

import java.util.Scanner;

public class ClienteController {

    /**
     * Metodo para obter os dados do cliente
     */
    public void cadastrarCliente() {

        var scanner = new Scanner(System.in);
        var cliente = new Cliente();
        var service = new ClienteService();

        System.out.println("INFORME OS DADOS DO CLIENTE:\n");

        System.out.print("NOME..................: ");
        cliente.setNome(scanner.nextLine());

        System.out.print("EMAIL.................: ");
        cliente.setEmail(scanner.nextLine());

        service.salvarDados(cliente);
    }

}
