package br.com.cotiinformatica.apiprodutos.dtos;

import java.time.LocalDateTime;

public record ProdutoResponseDTO(
        Integer id,
        String nome,
        String descricao,
        Double preco,
        Integer quantidade,
        //LocalDateTime dataCadastro,
        //LocalDateTime dataAtualizacao,
        //LocalDateTime dataExclusao,
        Boolean ativo,
        Double total
) {
}
