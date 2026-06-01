package br.com.cotiinformatica.apiprodutos.dtos;

public record ProdutoRequest(
        String nome,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
