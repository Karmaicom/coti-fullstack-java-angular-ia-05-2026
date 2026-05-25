package br.com.cotiinformatica.entities;

import java.util.UUID;

public class Professor {

    private UUID id;
    private String nome;
    private String telefone;

    public Professor() {
        this.id = UUID.randomUUID();
    }

    public Professor(String nome, String telefone) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.telefone = telefone;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Professor { " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", telefone: '" + telefone + '\'' +
                '}';
    }
}
