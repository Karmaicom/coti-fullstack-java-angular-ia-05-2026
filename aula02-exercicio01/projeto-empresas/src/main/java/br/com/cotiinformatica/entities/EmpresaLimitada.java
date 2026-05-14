package br.com.cotiinformatica.entities;

public class EmpresaLimitada extends Empresa {

    private Double capitalSocial;
    private Integer quantidadeSocios;

    public EmpresaLimitada() { }

    public EmpresaLimitada(Double capitalSocial, Integer quantidadeSocios) {
        this.capitalSocial = capitalSocial;
        this.quantidadeSocios = quantidadeSocios;
    }

    public Double getCapitalSocial() {
        return capitalSocial;
    }

    public void setCapitalSocial(Double capitalSocial) {
        this.capitalSocial = capitalSocial;
    }

    public Integer getQuantidadeSocios() {
        return quantidadeSocios;
    }

    public void setQuantidadeSocios(Integer quantidadeSocios) {
        this.quantidadeSocios = quantidadeSocios;
    }

    public Double calcularCapitalPorSocio() {
        return capitalSocial / quantidadeSocios;
    }

}
