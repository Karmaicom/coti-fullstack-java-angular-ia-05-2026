package br.com.cotiinformatica.controllers;

import br.com.cotiinformatica.entities.Professor;
import br.com.cotiinformatica.interfaces.BaseController;
import br.com.cotiinformatica.repositories.ProfessorRepository;

import java.util.Scanner;

public class ProfessorController implements BaseController {

    @Override
    public void cadastrar() {
        System.out.println("\nCadastro de professor: ");

        var scanner = new Scanner(System.in);
        var professor = new Professor();

        System.out.print("Nome do professor: ");
        professor.setNome(scanner.nextLine());

        System.out.print("Telefone: ");
        professor.setTelefone(scanner.nextLine());

        try {
            var repository = new ProfessorRepository();
            repository.inserir(professor);
            System.out.println("Professor cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }
}
