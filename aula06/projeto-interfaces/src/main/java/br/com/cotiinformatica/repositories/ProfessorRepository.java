package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.Professor;
import br.com.cotiinformatica.factories.ConnectionFactory;
import br.com.cotiinformatica.interfaces.IRepository;

public class ProfessorRepository implements IRepository<Professor> {

    @Override
    public void inserir(Professor entity) throws Exception {
        var connection = new ConnectionFactory().getConnection();

        var query = "insert into professor(id, nome, telefone)" +
                " values(?, ?, ?)";
        var statement = connection.prepareStatement(query);
        statement.setObject(1, entity.getId());
        statement.setString(2, entity.getNome());
        statement.setString(3, entity.getTelefone());

        statement.execute();
        connection.close();
    }
}
