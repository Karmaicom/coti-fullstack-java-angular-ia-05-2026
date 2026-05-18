package br.com.cotiinformatica.entities;

import java.util.UUID;

public class Cliente {

    public UUID id;
    public String nome;
    public String email;

    public Cliente() {
        id = UUID.randomUUID();
    }

}
