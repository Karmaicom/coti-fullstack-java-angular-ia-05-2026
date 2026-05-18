package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.entities.Cliente;

import java.util.Scanner;

public class ClienteController {

    /**
     * Metodo para obter os dados do cliente
     */
    public void cadastrarCliente() {

        var scanner = new Scanner(System.in);
        var cliente = new Cliente();

        System.out.println("INFORME OS DADOS DO CLIENTE:\n");

        System.out.print("NOME..................: ");
        cliente.nome = scanner.nextLine();

        System.out.print("EMAIL.................: ");
        cliente.email = scanner.nextLine();
    }

}
