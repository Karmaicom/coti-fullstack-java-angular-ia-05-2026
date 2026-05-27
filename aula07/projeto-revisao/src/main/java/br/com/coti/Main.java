package br.com.coti;

import br.com.coti.controllers.FuncionarioController;

public class Main {
    static void main() {
        var controller = new FuncionarioController();
        System.out.println(controller.listaFuncionario());
    }
}
