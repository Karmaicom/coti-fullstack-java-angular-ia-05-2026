package br.com.cotiinformatica.entities;

public class EmpresaMEI extends Empresa {

    private Double faturamentoMensal;

    public EmpresaMEI() { }

    public EmpresaMEI(Double faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }

    public Double getFaturamentoMensal() {
        return faturamentoMensal;
    }

    public void setFaturamentoMensal(Double faturamentoMensal) {
        this.faturamentoMensal = faturamentoMensal;
    }

    public Double calcularLucroLiquido() {
        return faturamentoMensal * 0.8;
    }

    @Override
    public String toString() {
        return "EmpresaMEI { " +
                super.toString() +
                " FATURAMENTO MENSAL: " + faturamentoMensal;
    }
}
