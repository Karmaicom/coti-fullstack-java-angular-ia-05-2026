package br.com.cotiinformatica.apiprodutos.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String url = "jdbc:postgresql://localhost:5433/bd-api-produtos";
    private static String usuario = "coti";
    private static String senha = "Coti@2026";

    public static Connection getConnection() {
        try {
            var connection = DriverManager.getConnection(url, usuario, senha);
            return connection;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
            return null;
        }
    }

}
