package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.Cliente;

import java.sql.DriverManager;


public class ClienteRepository {

    public void salvarDados(Cliente cliente) {
        try {
            // Abrir conexao com o banco de dados
            var connection = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5433/bd-clientes",
                    "coti",
                    "Coti@2026");

            // Salva dados do cliente no banco de dados
            var statement = connection.prepareStatement(
                    "insert into cliente(id, nome, cpf)" +
                            " values(?, ?, ?)");

            statement.setObject(1, cliente.getId());
            statement.setString(2, cliente.getNome());
            statement.setString(3, cliente.getCpf());

            // Salva dados do endereco no banco de dados
            var statementEndereco = connection.prepareStatement(
                    "insert into endereco(id, logradouro, numero, complemento, bairro, cidade, uf, cep, cliente_id)" +
                            " values(?, ?, ?, ?, ?, ?, ?, ?, ?)"
            );

            statementEndereco.setObject(1, cliente.getEndereco().getId());
            statementEndereco.setObject(2, cliente.getEndereco().getLogradouro());
            statementEndereco.setObject(3, cliente.getEndereco().getNumero());
            statementEndereco.setObject(4, cliente.getEndereco().getComplemento());
            statementEndereco.setObject(5, cliente.getEndereco().getBairro());
            statementEndereco.setObject(6, cliente.getEndereco().getCidade());
            statementEndereco.setObject(7, cliente.getEndereco().getUf());
            statementEndereco.setObject(8, cliente.getEndereco().getCep());
            statementEndereco.setObject(9, cliente.getId());

            // Executando o comando insert, para gravar os dados no banco de dados
            statement.execute();
            statementEndereco.execute();

            // Fechando a conexao com o banco de dados
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("ERROR: " + e.getMessage());
        }
    }

}
