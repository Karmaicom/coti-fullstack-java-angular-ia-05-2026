package br.com.cotiinformatica.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

/**
 * Classe Funcionario representa um funcionário genérico,
 * contendo atributos comuns a todos os tipos de funcionários.
 * Esta classe é serializável, permitindo que seus objetos
 * sejam convertidos em uma sequência de bytes para
 * armazenamento ou transmissão.
 */
public class Funcionario implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;
    private String nome;
    private String cpf;
    private String matricula;
    private LocalDate dataAdmissao;

    // Metodo construtor
    public Funcionario() {
        this.id = UUID.randomUUID();
    }

    // Sobrecarrega do metodo construtor contendo os demais atributos
    public Funcionario(String nome, String cpf, String matricula, LocalDate dataAdmissao) {
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.cpf = cpf;
        this.matricula = matricula;
        this.dataAdmissao = dataAdmissao;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public LocalDate getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Funcionario that = (Funcionario) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "id: " + id +
                ", nome: '" + nome + '\'' +
                ", cpf: '" + cpf + '\'' +
                ", matricula: '" + matricula + '\'' +
                ", dataAdmissao: " + dataAdmissao;
    }
}

