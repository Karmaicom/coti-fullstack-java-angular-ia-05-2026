package br.com.coti.controllers;

import br.com.coti.entities.Funcionario;
import br.com.coti.enums.TipoContrato;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class FuncionarioController {

    public void cadastrarFuncionario() {
        var scanner = new Scanner(System.in);
        var funcionario = new Funcionario();

        System.out.println("\nCadastro de funcionario:\n");

        System.out.print("Informe o nome: ");
        funcionario.setNome(scanner.nextLine());

        System.out.print("Matricula: ");
        funcionario.setMatricula(scanner.nextLine());

        System.out.print("CPF: ");
        funcionario.setCpf(scanner.nextLine());

        System.out.print("Data de admissão: ");
        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        funcionario.setDataAdmissao(LocalDate.parse(scanner.nextLine(), formatter));

        System.out.println("\nTipos de contrato: ");
        System.out.println("\t(1) Estágio");
        System.out.println("\t(2) CLT");
        System.out.println("\t(3) Terceirizado");
        System.out.println("\t(4) Temporário");

        System.out.print("\nInforme a opção: ");
        var opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao) {
            case 1:
                funcionario.setTipoContrato(TipoContrato.ESTAGIO);
                break;
            case 2:
                funcionario.setTipoContrato(TipoContrato.CLT);
                break;
            case 3:
                funcionario.setTipoContrato(TipoContrato.TERCEIRIZADO);
                break;
            case 4:
                funcionario.setTipoContrato(TipoContrato.TEMPORARIO);
                break;
            default:
                System.out.println("Opção inválida!");
        }
    }

}
