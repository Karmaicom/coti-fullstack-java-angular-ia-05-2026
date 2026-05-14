package br.com.cotiinformatica.entities;

import java.util.UUID;

public class Empresa {

    private UUID id;
    private String razaoSocial;
    private String cnpj;

    public Empresa() { }

    public Empresa(UUID id, String razaoSocial, String cnpj) {
        this.id = id;
        this.razaoSocial = razaoSocial;
        this.cnpj = cnpj;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", RAZAO SOCIAL: '" + razaoSocial + '\'' +
                ", CNPJ: '" + cnpj;
    }
}
