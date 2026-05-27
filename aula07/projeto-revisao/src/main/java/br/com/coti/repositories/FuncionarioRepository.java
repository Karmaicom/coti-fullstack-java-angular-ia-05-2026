package br.com.coti.repositories;

import br.com.coti.entities.Funcionario;
import br.com.coti.enums.TipoContrato;
import br.com.coti.factories.ConnectionFactory;
import br.com.coti.interfaces.IRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class FuncionarioRepository implements IRepository<Funcionario> {

    public void cadastrar(Funcionario funcionario) {
        try {
            var query = """
                insert into funcionario(id, nome, matricula, cpf, dataAdmissao, tipoContrato)
                values (?, ?, ?, ?, ?, ?)
                """;

            var connection = ConnectionFactory.getConnection();

            var statement = connection.prepareStatement(query);
            statement.setObject(1, funcionario.getId());
            statement.setString(2, funcionario.getNome());
            statement.setString(3, funcionario.getMatricula());
            statement.setString(4, funcionario.getCpf());
            statement.setDate(5, java.sql.Date.valueOf(funcionario.getDataAdmissao()));
            statement.setString(6, funcionario.getTipoContrato().toString());

            statement.execute();
            statement.close();
            connection.close();

            System.out.println("Funcionario cadastrado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar funcionario: " + e.getMessage());
        }
    }

    @Override
    public List<Funcionario> consultar() {
        try {
            var query = """
                select id, nome, matricula, cpf, dataAdmissao, tipoContrato from funcionario
                order by nome
                """;

            var connection = ConnectionFactory.getConnection();

            var statement = connection.prepareStatement(query);

            var result = statement.executeQuery();

            var listaFuncionario = new ArrayList<Funcionario>();
            while(result.next()) {
                var funcionario = new Funcionario();
                funcionario.setId(UUID.fromString(result.getString("id")));
                funcionario.setNome(result.getString("nome"));
                funcionario.setMatricula(result.getString("matricula"));
                funcionario.setCpf(result.getString("cpf"));
                funcionario.setDataAdmissao(result.getDate("dataAdmissao").toLocalDate());
                funcionario.setTipoContrato(TipoContrato.valueOf(result.getString("tipoContrato")));

                listaFuncionario.add(funcionario);
            }

            statement.close();
            connection.close();

            return  listaFuncionario;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao cadastrar funcionario: " + e.getMessage());
        }
        return List.of();
    }
}
