package br.com.cotiinformatica.apiprodutos.repositories;

import br.com.cotiinformatica.apiprodutos.dtos.ProdutoResponseDTO;
import br.com.cotiinformatica.apiprodutos.entities.Produto;
import br.com.cotiinformatica.apiprodutos.factories.ConnectionFactory;
import br.com.cotiinformatica.apiprodutos.intefaces.IProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ProdutoRepository implements IProdutoRepository {

    /**
     * Metodo para cadastrar um produto no banco de dados
     * @param produto
     * @throws Exception
     */
    @Override
    public void inserirProduto(Produto produto) throws Exception {
        var query = """
                    insert into produto 
                        (nome, descricao, preco, quantidade)
                    values (?, ?, ?, ?)
                """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getQuantidade());

        statement.execute();
        conenction.close();
    }

    /**
     * Metodo para consultar, no banco de dados, filtrando e ordenando pelo nome do produto
     * @param nome
     * @return
     * @throws Exception
     */
    public List<Produto> obterPorNome(String nome) throws Exception {
        var query = """
                    select id, nome, descricao, preco, quantidade, data_cadastro, data_atualizacao, data_exclusao, ativo
                    from produto p 
                    where ativo = 1 and p.nome ilike ?
                    order by nome
                """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setString(1, "%" + nome + "%");

        var  resultado = statement.executeQuery();

        var lista = new ArrayList<Produto>();

        while (resultado.next()) {
            var produto = new Produto();
            produto.setId(resultado.getInt(1));
            produto.setNome(resultado.getString(2));
            produto.setDescricao(resultado.getString(3));
            produto.setPreco(resultado.getDouble(4));
            produto.setQuantidade(resultado.getInt(5));
            produto.setDataCadastro(resultado.getObject(6, LocalDateTime.class));
            produto.setDataAtualizacao(resultado.getObject(7, LocalDateTime.class));
            produto.setDataExclusao(resultado.getObject(8, LocalDateTime.class));
            produto.setAtivo(resultado.getBoolean(9));

            lista.add(produto);
        }

        conenction.close();

        return lista;
    }

    /**
     * Metodo para atualizar as informações de um produto
     * @param produto
     * @return
     * @throws Exception
     */
    public boolean atualizar(Produto produto) throws Exception {
        var query = """
                    update produto set 
                            nome = ?, 
                            descricao = ?, 
                            preco = ?, 
                            quantidade = ?, 
                            data_atualizacao = now(),
                    where id = ?
                """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getQuantidade());
        statement.setInt(5, produto.getId());

        var updateResult = statement.executeUpdate();

        conenction.close();

        return updateResult > 0; // true ou false
    }

    /**
     * Metodo para deletar/inativar um produto
     * @param id
     * @return
     * @throws Exception
     */
    public boolean excluir(Integer id) throws Exception {
        var query = """
            update produto set ativo = 0, data_exclusao = now() where id = ?
        """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setInt(1, id);

        var deleteResult = statement.executeUpdate();

        conenction.close();

        return deleteResult > 0;
    }

    /**
     * Metodo para retornar um produto caso seja encontrado no banco de dados
     * @param id
     * @return
     * @throws Exception
     */
    public Produto buscarPorId(Integer id) throws Exception {
        var query = """
                select id, nome, descricao, preco, quantidade, 
                       data_cadastro, data_atualizacao, data_exclusao, ativo
                from produto where ativo = 1 and id = ?
        """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setInt(1, id);

        var resultado = statement.executeQuery();

        var produto = new Produto();

        if (resultado.first()) {
            produto.setId(resultado.getInt(1));
        }

        return produto;
    }
}
