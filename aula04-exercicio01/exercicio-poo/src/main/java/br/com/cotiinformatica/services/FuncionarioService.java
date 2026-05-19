package br.com.cotiinformatica.services;

import br.com.cotiinformatica.entities.Funcionario;

import java.io.FileWriter;
import java.io.PrintWriter;

public class FuncionarioService {

    public void salvarDados(Funcionario funcionario) {

        try {
            var fileWriter = new FileWriter("c:\\temp\\funcionario_" + funcionario.getId() + ".xml");
            var printWriter = new PrintWriter(fileWriter);

            printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
            printWriter.write("<funcionario>");
            printWriter.write("<id>" + funcionario.getId() + "</id>");
            printWriter.write("<nome>" + funcionario.getNome() + "</nome>");
            printWriter.write("<salario>" + funcionario.getSalario() + "</salario>");
            printWriter.write("</funcionario>");

            printWriter.close();
            fileWriter.close();

            System.out.println("\nDados do funcionario gravados com sucesso em XML!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
