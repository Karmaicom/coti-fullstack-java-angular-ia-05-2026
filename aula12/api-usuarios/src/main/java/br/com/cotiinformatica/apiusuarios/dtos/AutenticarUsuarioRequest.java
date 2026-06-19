package br.com.cotiinformatica.apiusuarios.dtos;

import java.time.LocalDateTime;

public record AutenticarUsuarioRequest(
        Integer id,
        String nome,
        String email,
        String senha,
        String perfil,
        LocalDateTime dataHoraAcesso,
        String accessToken
) {
}
