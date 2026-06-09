package br.com.cotiinformatica.apiclientes.repository;

import br.com.cotiinformatica.apiclientes.entites.Cliente;
import br.com.cotiinformatica.apiclientes.factories.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class ClienteRepository {

    @Autowired
    private ConnectionFactory factory;

    public void inserir(Cliente cliente) throws Exception {
        var query = """
                insert into cliente (id, nome, email, cpf, telefone)
                values (?, ?, ?, ?, ?);
                """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        statement.setObject(1, cliente.getId());
        statement.setString(2, cliente.getNome());
        statement.setString(3, cliente.getEmail());
        statement.setString(4, cliente.getCpf());
        statement.setString(5, cliente.getTelefone());

        statement.execute();
    }

    public List<Cliente> listar() throws Exception {
        var query = """
                select id, nome, email, cpf, telefone, 
                       data_cadastro, data_atualizacao, data_exclusao, ativo
                from cliente
                where ativo = 1
                order by nome;
        """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        var resultSet = statement.executeQuery();

        List<Cliente> clientes = new ArrayList<>();
        while (resultSet.next()) {
            var cliente = new Cliente();
            cliente.setId(UUID.fromString(resultSet.getString("id")));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setDataCadastro(Optional.ofNullable(resultSet.getTimestamp("data_cadastro"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setDataAtualizacao(Optional.ofNullable(resultSet.getTimestamp("data_atualizacao"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setDataExclusao(Optional.ofNullable(resultSet.getTimestamp("data_exclusao"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setAtivo(resultSet.getBoolean("ativo"));

            clientes.add(cliente);
        }

        return clientes;
    }

    public Cliente buscarPorId(UUID id) throws Exception {
        var query = """
                select id, nome, email, cpf, telefone, 
                       data_cadastro, data_atualizacao, data_exclusao, ativo
                from cliente where ativo = 1 and id = ?;
        """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        statement.setObject(1, id);
        var resultSet = statement.executeQuery();

        Cliente cliente = null;

        while (resultSet.next()) {
            cliente = new Cliente();
            cliente.setId(UUID.fromString(resultSet.getString("id")));
            cliente.setNome(resultSet.getString("nome"));
            cliente.setEmail(resultSet.getString("email"));
            cliente.setCpf(resultSet.getString("cpf"));
            cliente.setTelefone(resultSet.getString("telefone"));
            cliente.setDataCadastro(Optional.ofNullable(resultSet.getTimestamp("data_cadastro"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setDataAtualizacao(Optional.ofNullable(resultSet.getTimestamp("data_atualizacao"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setDataExclusao(Optional.ofNullable(resultSet.getTimestamp("data_exclusao"))
                    .map(Timestamp::toLocalDateTime)
                    .orElse(null));
            cliente.setAtivo(resultSet.getBoolean("ativo"));
        }

        return cliente;
    }

    public boolean excluir(UUID id) throws Exception {
        var query = """
                update cliente set ativo = 0 where id = ?;
        """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        statement.setObject(1, id);

        var result = statement.executeUpdate();

        statement.close();

        return result > 0;
    }

    public boolean atualizar(UUID id, Cliente cliente) throws Exception {
        var query = """
                update cliente set 
                    nome = ? , 
                    email = ?, 
                    cpf = ?, 
                    telefone = ?,
                    data_atualizacao = ?
                where ativo = 1 and id = ?;                
        """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        statement.setString(1, cliente.getNome());
        statement.setString(2, cliente.getEmail());
        statement.setString(3, cliente.getCpf());
        statement.setString(4, cliente.getTelefone());
        statement.setTimestamp(5, Timestamp.valueOf(LocalDateTime.now()));
        statement.setObject(6, id);

        var result = statement.executeUpdate();

        statement.close();

        return result > 0;
    }

    public boolean ativar(UUID id) throws Exception {
        var query = """
                update cliente set ativo = 1 where id = ?;
        """;

        var connection = factory.getConnection();
        var statement = connection.prepareStatement(query);
        statement.setObject(1, id);

        var result = statement.executeUpdate();

        statement.close();

        return result > 0;
    }

}
