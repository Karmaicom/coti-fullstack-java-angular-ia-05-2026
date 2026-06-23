package br.com.cotiinformatica.apiusuariosfix.repositories;

import br.com.cotiinformatica.apiusuariosfix.entities.Perfil;
import br.com.cotiinformatica.apiusuariosfix.factories.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PerfilRepository {

    @Autowired
    private ConnectionFactory connectionFactory;

    public void inserir(Perfil perfil) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var query = """
                        insert into perfil(nome) values(?)
                    """;
            var statment = connection.prepareStatement(query);
            statment.setString(1, perfil.getNome());
            statment.execute();
        }
    }

    public boolean atualizar(Perfil perfil) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var query = """
                        update perfis set nome = ? where id = ?;
                    """;
            var statement = connection.prepareStatement(query);
            statement.setString(1, perfil.getNome());
            statement.setInt(2, perfil.getId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean deletar(Integer id) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var query = """
                        delete from perfis where id = ?;
                    """;
            var statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public List<Perfil> listar() throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var query = """
                        select id, nome from perfis order nome;
            """;
            var statement = connection.prepareStatement(query);
            var result = statement.executeQuery();

            var lista = new ArrayList<Perfil>();
            while (result.next()) {
                Perfil perfil = new Perfil();
                perfil.setId(result.getInt("id"));
                perfil.setNome(result.getString("nome"));
                lista.add(perfil);
            }
            return lista;
        }
    }

}
