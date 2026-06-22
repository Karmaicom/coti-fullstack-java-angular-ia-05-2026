package br.com.cotiinformatica.apiusuarios.exceptions;

public class AcessoNegadoException extends RuntimeException {

    /**
     * Implementar um metodo para retornar a mensagem
     * de erro padrao desta classe de excessão
     */
    @Override
    public String getMessage() {
        return "Acesso negado.";
    }

}
