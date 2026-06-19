package br.com.cotiinformatica.apiusuarios.dtos;

import java.time.LocalDateTime;

public record AutenticarUsuarioRequest(
        String email,
        String senha
) {
}
