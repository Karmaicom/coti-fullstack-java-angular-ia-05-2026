package br.com.cotiinformatica.apiusuarios.dtos;

public record CriarUsuarioResponse(
        String mensagem,
        String nomeUsuario,
        String emailUsuario,
        String perfilUsuario
) {
}
