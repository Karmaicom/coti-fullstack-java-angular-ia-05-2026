package br.com.cotiinformatica.apiclientes.factories;

import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionFactory {

    private static String url = "jdbc:postgresql://localhost:5434/bd-api-clientes-exerc01";
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
