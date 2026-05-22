package br.com.cotiinformatica.controller;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.repositories.ProdutoRepository;

import java.util.List;
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
            System.out.println(repository.consultar());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public List<Produto> consultar() {
        try {
            return repository.consultar();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    public Produto consultarPorId() {
        try {
            System.out.print("Informe o id do produto: ");
            var id = Integer.parseInt(scanner.nextLine());

            return repository.consultarPorId(id);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

    public void atualizarProduto() {
        try {
            System.out.println("===== ATUALIZAR PRODUTO =====");

            var produto = new Produto();

            System.out.print("Informe o id do produto: ");
            produto.setId(Integer.parseInt(scanner.nextLine()));

            System.out.print("Digite o nome do produto: ");
            produto.setNome(scanner.nextLine());

            System.out.print("Digite o preço do produto: ");
            produto.setPreco(Double.parseDouble(scanner.nextLine()));

            System.out.print("Digite a quantidade do produto: ");
            produto.setQuantidade(Integer.parseInt(scanner.nextLine()));

            System.out.println(repository.atualizar(produto));
            System.out.println(repository.consultar());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void excluirProduto() {
        try {
            System.out.println("===== EXCLUIR PRODUTO =====");

            System.out.print("Informe o id do produto: ");
            var id = Integer.parseInt(scanner.nextLine());

            System.out.println(repository.excluir(id));
            System.out.println(repository.consultar());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
