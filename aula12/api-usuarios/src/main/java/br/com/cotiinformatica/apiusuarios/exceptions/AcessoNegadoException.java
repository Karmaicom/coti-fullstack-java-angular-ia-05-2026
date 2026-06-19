package br.com.cotiinformatica.apiusuarios.exceptions;

public class AcessoNegadoException extends RuntimeException {

    @Override
    public String getMessage() {
        return "Acesso negado.";
    }

}
