package br.com.cotiinformatica.apiusuarios.repositories;

import br.com.cotiinformatica.apiusuarios.entities.Usuario;
import br.com.cotiinformatica.apiusuarios.factories.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class UsuarioRepository {

    @Autowired
    private ConnectionFactory connectionFactory;

    public void inserir(Usuario usuario) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    insert into 
                        usuarios (nome, email, senha, data_hora_cadastro, perfil_id) 
                        values (?, ?, ?, ?, ?);
                """);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setTimestamp(4, Timestamp.valueOf(LocalDateTime.now()));
            statement.setInt(5, usuario.getPerfilId());
            statement.execute();
        }
    }

    public boolean atualizar(Usuario usuario) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    update usuarios 
                           set nome = ?, email = ?, senha = ?, perfil_id = ? 
                           where id = ?
                """);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            statement.setInt(4, usuario.getPerfilId());
            statement.setInt(5, usuario.getId());
            return statement.executeUpdate() > 0;
        }
    }

    public boolean excluir(Integer id) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    delete from usuarios where id = ?
                """);
            statement.setInt(1, id);
            return statement.executeUpdate() > 0;
        }
    }

    public Usuario buscarPorId(Integer id) throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    select id, nome, email, senha, data_hora_cadastro, perfil_id 
                        from perfis where id = ?
                """);
            statement.setInt(1, id);
            var resultSet = statement.executeQuery();

            Usuario usuarioFound = null;
            while(resultSet.next()) {
                usuarioFound = new Usuario();
                usuarioFound.setId(resultSet.getInt("id"));
                usuarioFound.setNome(resultSet.getString("nome"));
                usuarioFound.setEmail(resultSet.getString("email"));
                usuarioFound.setSenha(resultSet.getString("senha"));
                usuarioFound.setDataHoraCadastro(LocalDate.from(resultSet.getTimestamp("data_hora_cadastro").toLocalDateTime()));
                usuarioFound.setPerfilId(resultSet.getInt("perfil_id"));
            };

            return usuarioFound;
        }
    }

    public List<Usuario> listar() throws Exception {
        try (var connection = connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                    select id, nome from usuarios order by nome;
                """);

            var lista = new ArrayList<Usuario>();
            var resultSet = statement.executeQuery();
            while(resultSet.next()) {
                var usuarioFound = new Usuario();
                usuarioFound.setId(resultSet.getInt("id"));
                usuarioFound.setNome(resultSet.getString("nome"));
                usuarioFound.setEmail(resultSet.getString("email"));
                usuarioFound.setSenha(resultSet.getString("senha"));
                usuarioFound.setDataHoraCadastro(LocalDate.from(resultSet.getTimestamp("data_hora_cadastro").toLocalDateTime()));
                usuarioFound.setPerfilId(resultSet.getInt("perfil_id"));
            };

            return lista;
        }
    }

    public Usuario obterPorEmail(String email) throws Exception {
        try (var connection =  connectionFactory.getConnection()) {
            var statement = connection.prepareStatement("""
                select id, nome, email, senha, perfil_id
                from usuarios 
                where email = ?;
            """);
            statement.setString(1, email);

            var result = statement.executeQuery();

            Usuario usuarioFounded =  null;

            if(result.next()) {
                usuarioFounded = new Usuario();
                usuarioFounded.setId(result.getInt("id"));
                usuarioFounded.setNome(result.getString("nome"));
                usuarioFounded.setEmail(result.getString("email"));
                usuarioFounded.setSenha(result.getString("senha"));
                usuarioFounded.setPerfilId(result.getInt("perfil_id"));
            }

            return usuarioFounded;
        }
    }

}
