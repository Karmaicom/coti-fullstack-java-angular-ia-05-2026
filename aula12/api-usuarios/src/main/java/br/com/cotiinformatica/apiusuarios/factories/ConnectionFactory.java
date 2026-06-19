package br.com.cotiinformatica.apiusuarios.factories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionFactory {

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.user}")
    private String user;

    @Value("${datasource.pass}")
    private String pass;

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, pass);
    }

}
