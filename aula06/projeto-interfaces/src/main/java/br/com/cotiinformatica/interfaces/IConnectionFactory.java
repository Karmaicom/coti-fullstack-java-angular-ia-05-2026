package br.com.cotiinformatica.interfaces;

import java.sql.Connection;
import java.sql.SQLException;

public interface IConnectionFactory {

    public Connection getConnection() throws SQLException;

}
