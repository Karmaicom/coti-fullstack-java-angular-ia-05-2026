package br.com.cotiinformatica.apiusuariosfix.entities;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private LocalDateTime dataHoraCadastro;
    private Integer perfilId;

}
