package br.com.cotiinformatica.controller;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

import java.util.Scanner;

public class ProdutoController {

    private Scanner scanner = new Scanner(System.in);
    private ProdutoRepository repository = new ProdutoRepository();

    public void inserirProduto() {
        try {
            System.out.println("===== CADASTRO DE PRODUTO =====");

            var produto = new Produto();

            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Digite a quantidade do produto: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            System.out.println(repository.inserir(produto));
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
