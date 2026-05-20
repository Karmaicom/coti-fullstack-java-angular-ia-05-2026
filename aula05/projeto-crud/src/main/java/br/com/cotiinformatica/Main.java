package br.com.cotiinformatica;

import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        var bundleMessages = ResourceBundle.getBundle("messages");
        System.out.println(bundleMessages.getString("mensagem.boasvindas"));
    }
}