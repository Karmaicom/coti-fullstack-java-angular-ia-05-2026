import entities.Produto;
import utils.ProdutoUtils;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("SISTEMA DE CADASTRO DE PRODUTOS");
        System.out.println("Preencha os dados do produto: ");

        // Criando um objeto para usarmos a classe Scanner do Java
        var scanner = new Scanner(System.in);

        // Criando um objeto da classe Produto
        var produto = new Produto();

        // Gerando um ID único para o produto
        produto.id = java.util.UUID.randomUUID();

        // Solicitando os dados do produto
        System.out.print("Nome: ");
        produto.nome = scanner.nextLine();

        System.out.print("Preço: ");
        produto.preco = scanner.nextDouble();

        System.out.print("Quantidade: ");
        produto.quantidade = scanner.nextInt();

        System.out.print("Data de Validade (YYYY-MM-DD): ");
        produto.dataValidade = LocalDate.parse(scanner.next());

        produto.vencido = ProdutoUtils.verificarVencimento(produto.dataValidade);
        produto.total = produto.preco * produto.quantidade;

        // Salvando o produto no arquivo
        produto.salvarProduto();
    }

}
