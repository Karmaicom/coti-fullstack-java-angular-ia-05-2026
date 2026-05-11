package main.java.entites;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Classe de modelo de dados para cliente
 */
public class Cliente {

    // Atributos do cliente
    public UUID id;
    public String nome;
    public String email;
    public String telefone;
    public String cpf;
    public LocalDateTime dataHoraCadastro;

    // Metodo para salvar os dados do cliente em um arquivo
    public void salvarDados() {
        try {

            // Definindo o local e o nome do arquivo
            var fileWriter =
                    new FileWriter(
                            "c:\\temp",
                            true);

            // Escrever no arquivo
            var printWriter = new PrintWriter(fileWriter);

            printWriter.println(id);
            printWriter.println(nome);
            printWriter.println(email);
            printWriter.println(telefone);
            printWriter.println(cpf);
            printWriter.println(dataHoraCadastro);
            printWriter.println("*************************");

            // Fechar o arquivo
            fileWriter.close();
            printWriter.close();

            System.out.println("\nDados gravados com sucesso!");

        } catch (Exception e) {
            System.out.println("Falha ao gravar o arquivo: " + e.getMessage());
        }
    }


}
