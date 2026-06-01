package br.com.cotiinformatica.apiprodutos.controllers;

import br.com.cotiinformatica.apiprodutos.dtos.ProdutoRequestDTO;
import br.com.cotiinformatica.apiprodutos.dtos.ProdutoResponseDTO;
import br.com.cotiinformatica.apiprodutos.entities.Produto;
import br.com.cotiinformatica.apiprodutos.intefaces.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/produtos")
public class ProdutoController {

    private IProdutoRepository repository;

    @Autowired
    public ProdutoController(IProdutoRepository repository) {
        this.repository = repository;
    }

    /**
     * Metodo End point para consultar produto por nome
     * @param nome
     * @return
     */
    @GetMapping("/listar/{nome}")
    public List<ProdutoResponseDTO> obterPorNome(@PathVariable String nome) {
        try {
            return repository.obterPorNome(nome);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.getMessage());
            return null;
        }
    }

    /**
     * Metodo para cadastrar um produto no banco de dados
     * @param produtoRequest
     * @return
     */
    @PostMapping("/criar")
    public String criar(@RequestBody ProdutoRequestDTO produtoRequest) {
        try {
            var produto = new Produto();
            produto.setNome(produtoRequest.nome());
            produto.setDescricao(produtoRequest.descricao());
            produto.setPreco(produtoRequest.preco());
            produto.setQuantidade(produtoRequest.quantidade());

            repository.inserirProduto(produto);

            return "Produto cadastrado com sucesso!";
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return "Erro ao tentar inserir produto!";
        }
    }

}
