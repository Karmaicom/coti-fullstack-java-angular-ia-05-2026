package br.com.cotiinformatica.apiprodutos.controllers;

import br.com.cotiinformatica.apiprodutos.dtos.ProdutoRequest;
import br.com.cotiinformatica.apiprodutos.entities.Produto;
import br.com.cotiinformatica.apiprodutos.intefaces.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.SpringServletContainerInitializer;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private IProdutoRepository repository;

    @Autowired
    public ProdutoController(IProdutoRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/listar")
    public String listar(){
        return "Listagem de produtos obtida com sucesso!";
    }

    @PostMapping("/criar")
    public String criar(@RequestBody ProdutoRequest produtoRequest) {
        try {
            var produto = new Produto();
            produto.setNome(produtoRequest.nome());
            produto.setDescricao(produtoRequest.descricao());
            produto.setPreco(produtoRequest.preco());
            produto.setQuantidade(produtoRequest.quantidade());

            repository.inserirProduto(produto);

            return "Produto criado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return "Erro ao tentar inserir produto!";
        }

    }

    @PutMapping("/alterar")
    public String alterar() {
        return "Produto alterado com sucesso!";
    }

    @DeleteMapping("/excluir")
    public String excluir(String id) {
        return "Produto excluído com sucesso!";
    }

}
