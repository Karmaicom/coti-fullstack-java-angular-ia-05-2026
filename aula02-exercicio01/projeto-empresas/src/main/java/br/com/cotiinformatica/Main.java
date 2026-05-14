package br.com.cotiinformatica;

import br.com.cotiinformatica.entities.EmpresaLimitada;
import br.com.cotiinformatica.entities.EmpresaMEI;

import java.util.Scanner;
import java.util.UUID;

public class Main {
    static void main() {
        // Criando um objeto para usarmos a classe Scanner do Java
        var scanner = new Scanner(System.in);

        System.out.println("SISTEMA DE CADASTRO DE EMPRESAS");
        System.out.println("--------------------------------------------\n");

        var empresaMEI = new EmpresaMEI();
        empresaMEI.setId(UUID.randomUUID());

        System.out.println("DADOS DA EMPRESA MEI");
        System.out.print("Informe a razao social: ");
        empresaMEI.setRazaoSocial(scanner.nextLine());

        System.out.print("Informe o cnpj: ");
        empresaMEI.setCnpj(scanner.nextLine());

        System.out.print("Informe o faturamento mensal: ");
        empresaMEI.setFaturamentoMensal(Double.parseDouble(scanner.nextLine()));

        System.out.println("\nDADOS DA EMPRESA MEI CADASTRADA");
        System.out.println(empresaMEI);

        System.out.println("Lucro liquido: " + empresaMEI.calcularLucroLiquido());

        System.out.println("--------------------------------------------\n");

        var empresaLimitada = new EmpresaLimitada();
        empresaLimitada.setId(UUID.randomUUID());

        System.out.println("DADOS DA EMPRESA LIMITADA");
        System.out.print("Informe a razao social: ");
        empresaLimitada.setRazaoSocial(scanner.nextLine());

        System.out.print("Informe o cnpj: ");
        empresaLimitada.setCnpj(scanner.nextLine());

        System.out.print("Informe o capital social: ");
        empresaLimitada.setCapitalSocial(Double.parseDouble(scanner.nextLine()));

        System.out.print("Informe a quantidade de socios: ");
        empresaLimitada.setQuantidadeSocios(Integer.parseInt(scanner.nextLine()));

        System.out.println("\nDADOS DA EMPRESA LIMITADA CADASTRADA");
        System.out.println(empresaLimitada);

        System.out.println("Capital por socio: " + empresaLimitada.calcularCapitalPorSocio());

    }
}
