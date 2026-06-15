package br.com.cotiinformatica.apiusuarios.factories;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;

@Component
public class ConnectionFactory {

    @Value("${datasource.mysql.url}")
    private String url;

    @Value("${datasource.mysql.user}")
    private String user;

    @Value("${datasource.mysql.password}")
    private String password;

    public Connection getConnection() throws Exception {
        return DriverManager.getConnection(url, user, password);
    }

}
