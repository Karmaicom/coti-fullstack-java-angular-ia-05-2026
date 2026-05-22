package br.com.cotiinformatica.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String host = "jdbc:mysql://localhost:3307/bd_produtos"
                + "?useSSL=false"
                +"&serverTimezone=America/Sao_Paulo"
                +"&allowPublicKeyRetrieval=true";
    private static final String user = "coti";
    private static final String password = "coti";

    /**
     * Devolve uma conexao aberta com o banco de dados6
     * @return
     * @throws Exception
     */
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(host, user, password);
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.out.println("ERROR: " + ex.getMessage());
        }
        return null;
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
