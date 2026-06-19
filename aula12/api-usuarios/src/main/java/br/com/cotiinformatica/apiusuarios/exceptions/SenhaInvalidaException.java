package br.com.cotiinformatica.apiusuarios.exceptions;

public class SenhaInvalidaException extends RuntimeException {

    /**
     * Implementar um metodo para retornar a mensagem
     * de erro padrao desta classe de excessão
     */
    @Override
    public String getMessage() {
        return "A senha deve ter pelo menos uma letra maiuscula, uma letra minuscula, um numero, um simbolo e no minimo 8 caracteres.";
    }


}
