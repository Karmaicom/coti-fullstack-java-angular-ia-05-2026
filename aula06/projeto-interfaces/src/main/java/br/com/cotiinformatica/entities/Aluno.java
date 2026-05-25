package br.com.cotiinformatica.entities;

import java.util.UUID;

public class Aluno {

    private UUID id;
    private String nome;
    private String matricula;
    private String email;

    public Aluno() {
        this.id = UUID.randomUUID();
    }

    public Aluno(String nome, String matricula, String email) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.matricula = matricula;
        this.email = email;
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

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Aluno { " +
                "id: " + id +
                ", nome: '" + nome + '\'' +
                ", matricula: '" + matricula + '\'' +
                ", email: '" + email + '\'' +
                '}';
    }
}
