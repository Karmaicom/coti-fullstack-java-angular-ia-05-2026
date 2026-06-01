package br.com.cotiinformatica.apiprodutos.repositories;

import br.com.cotiinformatica.apiprodutos.entities.Produto;
import br.com.cotiinformatica.apiprodutos.factories.ConnectionFactory;
import br.com.cotiinformatica.apiprodutos.intefaces.IProdutoRepository;
import org.hibernate.validator.constraints.br.CNPJ;

import java.sql.Connection;
import java.sql.Date;
import java.time.LocalDateTime;

public class ProdutoRepository implements IProdutoRepository {

    private Connection conenction;

    public ProdutoRepository(Connection conenction) {
        this.conenction = ConnectionFactory.getConnection();
    }

    @Override
    public void inserirProduto(Produto produto) throws Exception {
        var query = """
                    insert into produto 
                        (nome, descricao, preco, quantidade)
                    values (?, ?, ?, ?)
                """;

        var statement = conenction.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setString(2, produto.getDescricao());
        statement.setDouble(3, produto.getPreco());
        statement.setInt(4, produto.getQuantidade());

        statement.execute();
        conenction.close();
    }

    @Override
    public void alterarProduto(Produto produto) throws Exception {

    }

    @Override
    public void excluirProduto() throws Exception {

    }

    @Override
    public void consultarProduto(Produto produto) throws Exception {

    }

    @Override
    public void listarProdutos() throws Exception {

    }
}
