package br.com.cotiinformatica.apiclientes.entites;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class Cliente {

    private UUID id = UUID.randomUUID();
    private String nome;
    private String cpf;
    private String email;
    private String telefone;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;
    private LocalDateTime dataExclusao;
    private Boolean ativo;

}
