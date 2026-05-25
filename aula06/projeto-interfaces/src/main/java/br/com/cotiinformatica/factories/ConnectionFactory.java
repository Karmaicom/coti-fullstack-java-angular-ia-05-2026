package br.com.cotiinformatica.factories;

import br.com.cotiinformatica.interfaces.IConnectionFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class ConnectionFactory implements IConnectionFactory {

    private ResourceBundle bundle;

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(
                bundle.getString("database.postgres.url"),
                bundle.getString("database.postgres.username"),
                bundle.getString("database.postgres.password"));
    }
}
