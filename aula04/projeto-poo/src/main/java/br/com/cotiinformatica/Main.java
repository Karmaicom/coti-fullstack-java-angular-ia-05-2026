package br.com.cotiinformatica;

import br.com.cotiinformatica.controllers.ClienteController;

public class Main {
    public static void main(String[] args) {
        var controller = new ClienteController();
        controller.cadastrarCliente();
    }
}