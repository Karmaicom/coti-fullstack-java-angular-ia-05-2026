package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.Aluno;
import br.com.cotiinformatica.factories.ConnectionFactory;
import br.com.cotiinformatica.interfaces.IRepository;

import java.util.List;
import java.util.UUID;

public class AlunoRepository implements IRepository<Aluno> {

    @Override
    public void inserir(Aluno entity) throws Exception {
        var connection = new ConnectionFactory().getConnection();

        var query = "insert into aluno(id, nome, matricula, email)" +
                " values(?, ?, ?, ?)";
        var statement = connection.prepareStatement(query);
        statement.setObject(1, entity.getId());
        statement.setString(2, entity.getNome());
        statement.setString(3, entity.getMatricula());
        statement.setString(4, entity.getEmail());

        statement.execute();
        connection.close();
    }
}
