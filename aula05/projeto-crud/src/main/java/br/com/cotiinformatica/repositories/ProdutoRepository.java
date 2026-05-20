package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.factories.ConnectionFactory;

import java.util.ResourceBundle;

public class ProdutoRepository {

    /**
     * Metodo para inserir um produto no bando de dados
     * @param produto
     */
    public String inserir(Produto produto) throws Exception {
        var bundleMessages = ResourceBundle.getBundle("messages");

        var connection = ConnectionFactory.getConnection();
        var query = "insert into produtos(nome, preco, quantidade) values (?, ?, ?)";

        var statement = connection.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());

        // Executar a instrução sql no banco de dados
        statement.execute();

        // Fechar conexao
        ConnectionFactory.closeConnection(connection);

        return bundleMessages.getString("mensagem.produto.criado");
    }

}
