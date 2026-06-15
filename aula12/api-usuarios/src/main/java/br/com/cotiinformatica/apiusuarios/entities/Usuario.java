package br.com.cotiinformatica.apiusuarios.entities;

import lombok.Data;

import java.time.LocalDate;

@Data
public class Usuario {

    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private LocalDate dataHoraCadastro;
    private Integer perfilId;

}
