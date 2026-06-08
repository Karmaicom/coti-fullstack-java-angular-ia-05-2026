package br.com.cotiinformatica.apiprodutos.intefaces;

import br.com.cotiinformatica.apiprodutos.entities.Produto;

import java.util.List;

public interface IProdutoRepository {

    void inserirProduto(Produto produto) throws Exception;
    List<Produto> obterPorNome(String nome) throws Exception;
    Produto buscarPorId(Integer id) throws Exception;
    boolean excluir(Integer id) throws Exception;
    boolean atualizar(Integer id, Produto produto) throws Exception;
}
