package br.com.cotiinformatica.apiprodutos.dtos;

public record ProdutoRequestDTO(
        String nome,
        String descricao,
        Double preco,
        Integer quantidade
) {
}
