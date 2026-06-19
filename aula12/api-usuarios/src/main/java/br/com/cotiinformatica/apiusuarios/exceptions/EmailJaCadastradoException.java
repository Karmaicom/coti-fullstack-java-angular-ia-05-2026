package br.com.cotiinformatica.apiusuarios.exceptions;

public class EmailJaCadastradoException extends RuntimeException {

    /**
     * Implementar um metodo para retornar a mensagem
     * de erro padrao desta classe de excessão
     */
    @Override
    public String getMessage() {
        return "O email informado já está cadastrado. Por favor, informe outro email!";
    }

}
