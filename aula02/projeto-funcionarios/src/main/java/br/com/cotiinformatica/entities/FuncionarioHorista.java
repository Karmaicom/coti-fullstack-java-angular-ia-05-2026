package br.com.cotiinformatica.entities;

import java.time.LocalDate;

public class FuncionarioHorista extends Funcionario {

    private Double valorHora;
    private Integer horasTrabalhadas;

    /**
     * Construtor da classe FuncionarioHorista, que inicializa os atributos herdados
     * @param nome
     * @param cpf
     * @param matricula
     * @param dataAdmissao
     * @param valorHora
     * @param horasTrabalhadas
     */
    public FuncionarioHorista(String nome, String cpf, String matricula, LocalDate dataAdmissao, Double valorHora, Integer horasTrabalhadas) {
        super(nome, cpf, matricula, dataAdmissao);
        this.valorHora = valorHora;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public Double getValorHora() {
        return valorHora;
    }

    public void setValorHora(Double valorHora) {
        this.valorHora = valorHora;
    }

    public Integer getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(Integer horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    /**
     * @return O salário bruto do funcionário horista, calculado como o
     * produto do valor da hora e das horas trabalhadas.
     */
    public Double calcularSalarioBruto() {
        return valorHora * horasTrabalhadas;
    }

    @Override
    public String toString() {
        return "FUNCIONARIO HORISTA{" +
                "VALOR HORA: " + valorHora +
                ", HORAS TRABALHADAS: " + horasTrabalhadas +
                '}';
    }
}
