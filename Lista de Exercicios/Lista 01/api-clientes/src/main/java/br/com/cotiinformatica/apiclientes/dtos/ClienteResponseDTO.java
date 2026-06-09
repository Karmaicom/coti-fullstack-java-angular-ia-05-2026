package br.com.cotiinformatica.apiclientes.dtos;

import java.time.LocalDateTime;

public record ClienteResponseDTO(
        String nome,
        String email,
        String cpf,
        String telefone,
        LocalDateTime dataCadastro,
        LocalDateTime dataAtualizacao,
        LocalDateTime dataExclusao,
        Boolean ativo
) {
}
