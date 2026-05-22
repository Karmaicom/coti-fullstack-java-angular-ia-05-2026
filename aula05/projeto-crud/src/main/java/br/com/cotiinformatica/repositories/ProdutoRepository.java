package br.com.cotiinformatica.repositories;

import br.com.cotiinformatica.entities.Produto;
import br.com.cotiinformatica.factories.ConnectionFactory;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class ProdutoRepository {

    private Connection connection;
    private ResourceBundle bundleMessages;

    public ProdutoRepository() {
        this.connection = ConnectionFactory.getConnection();
        this.bundleMessages = ResourceBundle.getBundle("messages");
    }

    /**
     * Metodo para inserir um produto no bando de dados
     * @param produto
     * @return Texto definido no arquivo de mensagens
     * @throws Exception
     */
    public String inserir(Produto produto) throws Exception {
        var query = "insert into produtos(nome, preco, quantidade) values (?, ?, ?)";

        var statement = this.connection.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());

        // Executar a instrução sql no banco de dados
        statement.execute();

        // Fechar conexao
        ConnectionFactory.closeConnection(this.connection);

        return this.bundleMessages.getString("mensagem.produto.criado");
    }

    /**
     * Metodo para atualizar dados de um produto no banco de dados
     * @param produto
     * @return Texto definido no arquivo de mensagens
     * @throws Exception
     */
    public String atualizar(Produto produto) throws Exception {
        var query = "update produtos set nome = ?, preco = ?, quantidade = ? where id = ?)";

        var statement = this.connection.prepareStatement(query);
        statement.setString(1, produto.getNome());
        statement.setDouble(2, produto.getPreco());
        statement.setInt(3, produto.getQuantidade());
        statement.setInt(4, produto.getId());

        var result = statement.executeUpdate();

        if (result > 0) return this.bundleMessages.getString("mensagem.produto.atualizado");
        else return this.bundleMessages.getString("mensagem.produto.nao.encontrado");

    }

    /**
     * Metodo para excluir um produto do banco de dados
     * @param id
     * @return
     * @throws Exception
     */
    public String excluir(Integer id) throws Exception {
        var query = "delete from produtos where id = ?";

        var statement = this.connection.prepareStatement(query);
        statement.setInt(1, id);

        var result = statement.executeUpdate();

        if (result > 0) return this.bundleMessages.getString("mensagem.produto.excluido");
        else return this.bundleMessages.getString("mensagem.produto.nao.encontrado");
    }

    public List<Produto> consultar() throws Exception {
        var query = "select id, nome, preco, quantidade from produtos";

        var statement = this.connection.prepareStatement(query);

        var result = statement.executeQuery();

        var produtos = new ArrayList<Produto>();
        while(result.next()) {
            var produto = new Produto(
                    result.getInt("id"),
                    result.getString("nome"),
                    result.getDouble("preco"),
                    result.getInt("quantidade"));

            produtos.add(produto);
        }

        return produtos;
    }
}
