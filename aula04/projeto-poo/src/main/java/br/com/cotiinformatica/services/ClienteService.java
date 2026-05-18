package br.com.cotiinformatica.services;

import br.com.cotiinformatica.entities.Cliente;

import java.io.FileWriter;
import java.io.PrintWriter;

public class ClienteService {

    public void salvarDados(Cliente cliente) {
        try {

            var fileWriter = new FileWriter("c:\\temp\\cliente_" + cliente.id, true);
            var printWriter = new PrintWriter(fileWriter);

            printWriter.write("<?xml version='1.0' encoding='UTF-8'?>");
            printWriter.write("<clientes>");
                printWriter.write("<id>" + cliente.id + "</id>");
                printWriter.write("<nome>" + cliente.nome + "</nome>");
                printWriter.write("<email>" + cliente.email + "</email>");
            printWriter.write("</cliente>");

            printWriter.close();

            System.out.println("\nDados do cliente gravados com sucesso em XML!");

        } catch (Exception e) {
            System.out.println("\nFalha ao tentar salvar o cliente.");
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
