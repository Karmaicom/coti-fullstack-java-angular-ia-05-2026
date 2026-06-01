package br.com.cotiinformatica.apiprodutos.intefaces;

import br.com.cotiinformatica.apiprodutos.dtos.ProdutoResponseDTO;
import br.com.cotiinformatica.apiprodutos.entities.Produto;

import java.util.List;

public interface IProdutoRepository {

    void inserirProduto(Produto produto) throws Exception;
    List<ProdutoResponseDTO> obterPorNome(String nome) throws Exception;
}
