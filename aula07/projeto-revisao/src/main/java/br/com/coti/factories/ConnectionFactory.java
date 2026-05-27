package br.com.coti.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ResourceBundle;

public class ConnectionFactory {

    private static final ResourceBundle bundle = ResourceBundle.getBundle("messages");

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(
                bundle.getString("database.postgres.url"),
                bundle.getString("database.postgres.username"),
                bundle.getString("database.postgres.password"));
    }

}
