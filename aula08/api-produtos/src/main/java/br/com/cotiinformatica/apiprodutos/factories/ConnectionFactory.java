package br.com.cotiinformatica.apiprodutos.factories;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

    private static String url = "jdbc:prostgres://localhost:5433/bd-api-produtos";
    private static String usuario = "coti";
    private static String senha = "COti@2026";

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(url, usuario, senha);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
