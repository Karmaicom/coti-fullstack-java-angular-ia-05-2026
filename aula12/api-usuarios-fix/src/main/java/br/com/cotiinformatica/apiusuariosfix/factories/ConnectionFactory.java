package br.com.cotiinformatica.apiusuariosfix.factories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionFactory {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, username, password);
    }
}
