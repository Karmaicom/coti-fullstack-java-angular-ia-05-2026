package br.com.cotiinformatica;

import br.com.cotiinformatica.controllers.FuncionarioController;

public class Main {
    public static void main(String[] args) {
        var controller = new FuncionarioController();
        controller.cadastrarFuncionario();
    }
}