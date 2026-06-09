package br.com.cotiinformatica.apiclientes.dtos;

public record ClienteRequestDTO(
        String nome,
        String email,
        String cpf,
        String telefone
) {
}
