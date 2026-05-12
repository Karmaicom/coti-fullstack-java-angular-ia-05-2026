package main.java.entites;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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
    public LocalDate dataNascimento;
    public String profissao;
    public LocalDateTime dataHoraCadastro;

    // Metodo para salvar os dados do cliente em um arquivo
    public void salvarDados() {
        try {

            DateTimeFormatter formatadorNascimento = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter formatadorCadastro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

            // Definindo o local e o nome do arquivo
            var fileWriter =
                    new FileWriter(
                            "c:\\temp\\clientes.txt",
                            true);

            // Escrever no arquivo
            var printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + id);
            printWriter.println("Nome: " + nome);
            printWriter.println("E-mail: " + email);
            printWriter.println("Telefone: " + telefone);
            printWriter.println("CPF: " + cpf);
            printWriter.println("Data de nascimento: " + formatadorNascimento.format(dataNascimento));
            printWriter.println("Profissão: " + profissao);
            printWriter.println("Data de cadastro: " + formatadorCadastro.format(dataHoraCadastro));
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
