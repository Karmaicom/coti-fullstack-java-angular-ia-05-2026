package br.com.cotiinformatica;

import br.com.cotiinformatica.controller.ProdutoController;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        var bundleMessages = ResourceBundle.getBundle("messages");
        System.out.println(bundleMessages.getString("mensagem.boasvindas"));

        var controller = new ProdutoController();
        //controller.inserirProduto();
        //System.out.println(controller.consultar());
        //controller.atualizarProduto();
        controller.excluirProduto();
    }
}