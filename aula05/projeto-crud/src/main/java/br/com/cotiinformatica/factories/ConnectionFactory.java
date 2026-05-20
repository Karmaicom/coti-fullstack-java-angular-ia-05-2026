package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static final String host = "jdbc:mysql://localhost:3307/bd_produtos"
                + "?useSSL=false"
                +"&serverTimezone=America/Sao_Paulo"
                +"&allowPublicKeyRetrieval=true";
    private static final String user = "coti";
    private static final String password = "coti";

    /**
     * Devolve uma conexao aberta com o banco de dados
     * @return
     * @throws Exception
     */
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(host, user, password);
    }

    /**
     * Fechar a conexao com o banco de dados
     * @param connection
     * @throws Exception
     */
    public static void closeConnection(Connection connection) throws Exception {
        connection.close();
    }
}
