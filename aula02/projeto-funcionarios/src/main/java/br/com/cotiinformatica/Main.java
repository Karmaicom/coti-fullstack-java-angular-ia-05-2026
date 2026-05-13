package br.com.cotiinformatica;

import br.com.cotiinformatica.entities.FuncionarioCLT;

import javax.swing.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Main {
    static void main() {

        var formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        var funcionarioCLT = new FuncionarioCLT();
        funcionarioCLT.setNome(JOptionPane.showInputDialog("Digite o nome do funcionário:"));
        funcionarioCLT.setCpf(JOptionPane.showInputDialog("Digite o CPF do funcionário:"));
        funcionarioCLT.setMatricula(JOptionPane.showInputDialog("Digite a matrícula do funcionário:"));
        funcionarioCLT.setDataAdmissao(LocalDate.parse(JOptionPane.showInputDialog("Digite a data de admissão do funcionário (dd/MM/yyyy):"), formatter));
        funcionarioCLT.setSalarioBase(Double.parseDouble(JOptionPane.showInputDialog("Digite o salário base do funcionário:")));
        funcionarioCLT.setValorBeneficios(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor dos benefícios do funcionário:")));
        funcionarioCLT.setValorDescontos(Double.parseDouble(JOptionPane.showInputDialog("Digite o valor dos descontos do funcionário:")));

        System.out.println(funcionarioCLT);

        System.out.println("Salário Bruto do funcionario " + funcionarioCLT.getNome() + ": " + funcionarioCLT.calcularSalarioBruto());
        System.out.println("Salário Líquido do funcionario " + funcionarioCLT.getNome() + ": " + (funcionarioCLT.calcularSalarioBruto() - funcionarioCLT.getValorDescontos()));
    }
}
