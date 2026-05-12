package utils;

import java.time.LocalDate;

public class ProdutoUtils {

    public static boolean verificarVencimento(LocalDate dataValidade) {
        var dataAtual = java.time.LocalDate.now();
        return dataValidade.isBefore(dataAtual);
    }

}
