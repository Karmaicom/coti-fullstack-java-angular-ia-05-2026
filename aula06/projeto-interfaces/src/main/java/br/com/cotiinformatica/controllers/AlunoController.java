package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.entities.Aluno;
import br.com.cotiinformatica.interfaces.BaseController;
import br.com.cotiinformatica.repositories.AlunoRepository;

import java.util.Scanner;

public class AlunoController implements BaseController {

    @Override
    public void cadastrar() {
        System.out.println("\nCadastro de aluno: ");

        var scanner = new Scanner(System.in);
        var aluno = new Aluno();

        System.out.print("Nome do aluno: ");
        aluno.setNome(scanner.nextLine());

        System.out.print("Matricula: ");
        aluno.setMatricula(scanner.nextLine());

        System.out.print("Email: ");
        aluno.setEmail(scanner.nextLine());

        try {
            var repository = new AlunoRepository();
            repository.inserir(aluno);
            System.out.println("Aluno cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }

    }

}
