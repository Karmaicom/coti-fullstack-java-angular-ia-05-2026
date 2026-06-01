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
    public List<ProdutoResponseDTO> obterPorNome(String nome) throws Exception {
        var query = """
                    select nome, descricao, preco, quantidade, data_cadastro, data_atualizacao, data_exclusao, ativo
                    from produto p 
                    where p.nome ilike ?
                    order by nome
                """;

        var conenction = ConnectionFactory.getConnection();
        var statement = conenction.prepareStatement(query);
        statement.setString(1, "%" + nome + "%");

        var  resultado = statement.executeQuery();

        var lista = new ArrayList<ProdutoResponseDTO>();

        while (resultado.next()) {
            var produto = new ProdutoResponseDTO(
                    resultado.getString(1),
                    resultado.getString(2),
                    resultado.getDouble(3),
                    resultado.getInt(4),
                    resultado.getObject(5, LocalDateTime.class),
                    resultado.getObject(6, LocalDateTime.class),
                    resultado.getObject(7, LocalDateTime.class),
                    resultado.getBoolean(8)
            );
            lista.add(produto);
        }
        return lista;
    }
}
