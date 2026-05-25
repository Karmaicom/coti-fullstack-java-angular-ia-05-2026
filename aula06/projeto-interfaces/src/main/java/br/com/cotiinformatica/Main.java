package br.com.cotiinformatica;

import br.com.cotiinformatica.controllers.AlunoController;
import br.com.cotiinformatica.controllers.ProfessorController;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var scanner = new Scanner(System.in);

        System.out.println("(1) Cadastrar aluno");
        System.out.println("(2) Cadastrar professor");

        System.out.print("Informe a opção desejada: ");
        var opcao = Integer.parseInt(scanner.nextLine());

        switch (opcao)
        {
            case 1:
                var controllerAluno = new AlunoController();
                controllerAluno.cadastrar();
                break;
            case 2:
                var controllerProfessor = new ProfessorController();
                controllerProfessor.cadastrar();
                break;
            default:
                System.out.println("\nOpção inválida.");
        }

    }
}