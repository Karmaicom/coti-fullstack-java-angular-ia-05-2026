package br.com.cotiinformatica.apiusuarios.repositories;

import br.com.cotiinformatica.apiusuarios.entities.Perfil;
import br.com.cotiinformatica.apiusuarios.factories.ConnectionFactory;
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
            var statement = connection.prepareStatement("""
                    insert into perfis (nome) values (?)
                """);
            statement.setString(1, perfil.getNome());
            statement.execute();
        }
    }

    public boolean atualizar(Perfil perfil) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    update perfis set nome = ? where id = ?
                """);
            statement.setString(1, perfil.getNome());
            statement.setInt(2, perfil.getId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean excluir(Perfil perfil) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    delete from perfis where id = ?
                """);
            statement.setInt(1, perfil.getId());
            return statement.executeUpdate() > 0;
        }
    }

    public Perfil buscarPorId(Integer id) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    select id, nome from perfis where id = ?
                """);
            statement.setInt(1, id);
            var resultSet = statement.executeQuery();

            Perfil perfilFound = null;
            while(resultSet.next()) {
                perfilFound = new Perfil();
                perfilFound.setId(resultSet.getInt("id"));
                perfilFound.setNome(resultSet.getString("nome"));
            };

            return perfilFound;
        }
    }

    public List<Perfil> listar() throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    select id, nome from perfis order by nome;
                """);

            var lista = new ArrayList<Perfil>();
            var resultSet = statement.executeQuery();
            while(resultSet.next()) {
                var perfilFound = new Perfil();
                perfilFound.setId(resultSet.getInt("id"));
                perfilFound.setNome(resultSet.getString("nome"));
                lista.add(perfilFound);
            };

            return lista;
        }
    }

    public Perfil obterPorNome(String nome) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                select id, nome from perfis
                where nome = ?
            """);
            statement.setString(1, nome);
            var result = statement.executeQuery();

            Perfil perfil = null;

            if(result.next()) {
                perfil = new Perfil();
                perfil.setId(result.getInt("id"));
                perfil.setNome(result.getString("nome"));
            }

            return perfil;
        }
    }
}
