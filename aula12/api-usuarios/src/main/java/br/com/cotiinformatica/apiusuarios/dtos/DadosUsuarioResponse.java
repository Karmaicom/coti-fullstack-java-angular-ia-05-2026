package br.com.cotiinformatica.apiusuarios.dtos;

public record DadosUsuarioResponse(
        Integer id,
        String nome,
        String email,
        String perfil
) {
}
