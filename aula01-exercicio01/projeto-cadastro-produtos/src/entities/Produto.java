package entities;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.UUID;

public class Produto {

    public UUID id;
    public String nome;
    public Double preco;
    public Integer quantidade;
    public LocalDate dataValidade;
    public Boolean vencido;
    public Double total;

    public void salvarProduto() {

        DecimalFormat df = new DecimalFormat("#.00");
        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        try {

            // Definindo local e nome do arquivo
            var fileWriter = new FileWriter("c:\\temp\\produtos.txt", true);

            // Escrevendo os dados do produto no arquivo
            var printWriter = new PrintWriter(fileWriter);

            printWriter.println("ID: " + id);
            printWriter.println("Nome: " + nome);
            printWriter.println("Preço: $" + df.format(preco));
            printWriter.println("Quantidade: " + quantidade);
            printWriter.println("Data de Validade: " + formatador.format(dataValidade));
            printWriter.println("Produto fora da validade: " + (vencido? "Sim" : "Não"));
            printWriter.println("Total: $" + df.format(total));
            printWriter.println("-----------------------------------");

            // Fechando os recursos
            printWriter.close();
            fileWriter.close();

            System.out.println("Arquivo gravado com sucesso!");

        } catch (Exception e) {
            System.out.println("Erro ao salvar o produto: " + e.getMessage());
        }

    }


}
