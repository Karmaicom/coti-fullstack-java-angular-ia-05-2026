package br.com.cotiinformatica.apiprodutos.intefaces;

import br.com.cotiinformatica.apiprodutos.entities.Produto;

public interface IProdutoRepository {

    void inserirProduto(Produto produto) throws Exception;
    void alterarProduto(Produto produto) throws Exception;
    void excluirProduto() throws Exception;
    void consultarProduto(Produto produto) throws Exception;
    void listarProdutos() throws Exception;

}
