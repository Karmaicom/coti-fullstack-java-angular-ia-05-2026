package br.com.cotiinformatica.apiusuarios.dtos;

public record CriarUsuarioRequest(
        String nome,
        String email,
        String senha
) {
}
