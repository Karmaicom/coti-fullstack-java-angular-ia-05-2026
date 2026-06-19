package br.com.cotiinformatica.apiusuarios.dtos;

import java.time.LocalDateTime;

public record AutenticarUsuarioResponse(
        Integer id,
        String nome,
        String email,
        String perfil,
        LocalDateTime dataHoraAcesso,
        String accessToken
) {
}
