package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.entities.Funcionario;
import br.com.cotiinformatica.services.FuncionarioService;

import java.util.Scanner;

public class FuncionarioController {

    /**
     * Metodo para obter os dados do cliente
     */
    public void cadastrarFuncionario() {

        var scanner = new Scanner(System.in);
        var funcionario = new Funcionario();
        var service = new FuncionarioService();

        System.out.println("INFORME OS DADOS DO FUNCIONARIO:\n");

        System.out.print("NOME..................: ");
        funcionario.setNome(scanner.nextLine());

        System.out.print("SALARIO...............: ");
        funcionario.setSalario(Double.parseDouble(scanner.nextLine()));

        service.salvarDados(funcionario);
    }

}
