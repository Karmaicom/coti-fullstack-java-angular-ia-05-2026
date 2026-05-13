package br.com.cotiinformatica.entities;

import java.time.LocalDate;
import java.util.UUID;

public class FuncionarioCLT extends Funcionario {

    private Double salarioBase;
    private Double valorBeneficios;
    private Double valorDescontos;

    public FuncionarioCLT() { }

    /**
     * Construtor da classe FuncionarioCLT, que inicializa os atributos herdados
     * @param nome
     * @param cpf
     * @param matricula
     * @param dataAdmissao
     * @param salarioBase
     * @param valorBeneficios
     * @param valorDescontos
     */
    public FuncionarioCLT(String nome, String cpf, String matricula, LocalDate dataAdmissao, Double salarioBase, Double valorBeneficios, Double valorDescontos) {
        super(nome, cpf, matricula, dataAdmissao);
        this.salarioBase = salarioBase;
        this.valorBeneficios = valorBeneficios;
        this.valorDescontos = valorDescontos;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Double getValorBeneficios() {
        return valorBeneficios;
    }

    public void setValorBeneficios(Double valorBeneficios) {
        this.valorBeneficios = valorBeneficios;
    }

    public Double getValorDescontos() {
        return valorDescontos;
    }

    public void setValorDescontos(Double valorDescontos) {
        this.valorDescontos = valorDescontos;
    }

    /**
     * @return O salário bruto do funcionário, calculado como a soma do salário base e dos benefícios.
     */
    public Double calcularSalarioBruto() {
        return salarioBase + valorBeneficios;
    }

    /**
     * @return o salário líquido do funcionário, subtraindo os descontos do salário bruto.
     */
    public Double calcularSalarioLiquido() {
        return this.calcularSalarioBruto() - valorDescontos;
    }

    @Override
    public String toString() {
        return "FuncionarioCLT { " +
                super.toString() +
                ", SALARIO BASE: " + salarioBase +
                ", VALOR BENEFICIOS: " + valorBeneficios +
                ", VALOR DESCONTOS: " + valorDescontos +
                '}';
    }
}


