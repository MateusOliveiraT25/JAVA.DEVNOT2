package Controller;

import Model.Produto;
import Connection.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProdutoDAO {
    private Connection connection;

    // Consultas SQL
    private static final String LIMPAR_TABELA = "DELETE FROM produtos";
    private static final String VERIFICAR_REGISTRO = "SELECT COUNT(*) FROM produtos";

    // Inicia uma transação no banco de dados
    public void iniciarTransacao() throws SQLException {
        obterConexao(); // Garante que a conexão está aberta
        connection.setAutoCommit(false);
    }

    // Finaliza uma transação no banco de dados
    public void finalizarTransacao() {
        try {
            connection.commit();
        } catch (SQLException e) {
            System.err.println("Erro no commit: " + e.getMessage());
        } finally {
            try {
                connection.setAutoCommit(true);
            } catch (SQLException e) {
                System.err.println("Erro ao redefinir auto commit: " + e.getMessage());
            }
        }
    }

    // Executa rollback em caso de falha na transação
    public void rollbackTransacao() {
        try {
            if (connection != null) {
                connection.rollback();
            }
        } catch (SQLException e) {
            System.err.println("Erro no rollback: " + e.getMessage());
        } finally {
            try {
                if (connection != null) {
                    connection.setAutoCommit(true);
                }
            } catch (SQLException e) {
                System.err.println("Erro ao redefinir auto commit: " + e.getMessage());
            }
        }
    }

    // Construtor que inicializa a conexão e cria a tabela de produtos se não existir
    public ProdutoDAO() {
        this.connection = ConnectionFactory.getConnection();
        criarTabelaProdutos(); // Chame o método para criar a tabela no construtor, se necessário
    }

    // Cria a tabela de produtos no banco de dados
    private void criarTabelaProdutos() {
        String sql = "CREATE TABLE IF NOT EXISTS produtos (codigo_barra VARCHAR(255), nome VARCHAR(255), quantidade INT, preco DOUBLE)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de produtos criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de produtos: " + e.getMessage(), e);
        }
    }

    // Adiciona um produto ao banco de dados
    public void adicionarProduto(Produto produto) {
        String sql = "INSERT INTO produtos (codigo_barra, nome, quantidade, preco) VALUES (?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getCodigoBarra());
            preparedStatement.setString(2, produto.getNome());
            preparedStatement.setInt(3, produto.getQuantidade());
            preparedStatement.setDouble(4, produto.getPreco());
            preparedStatement.executeUpdate();
            System.out.println("Produto adicionado com sucesso!");
        } catch (SQLException e) {
            System.err.println("Erro ao adicionar produto: " + e.getMessage());

            // Em caso de erro, faça o rollback da transação
            rollbackTransacao();
        }
    }

    // Lista todos os produtos do banco de dados
    public List<Produto> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Produto> produtos = new ArrayList<>();

        try {
            obterConexao(); // Garante que a conexão está aberta
            stmt = connection.prepareStatement("SELECT * FROM produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Produto produto = new Produto(
                        rs.getString("codigo_barra"),
                        rs.getString("nome"),
                        rs.getInt("quantidade"),
                        rs.getDouble("preco"));
                produtos.add(produto);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return produtos;
    }

    // Verifica se um registro com o código de barras especificado já existe no banco de dados
    private boolean registroExiste(String codigoBarra) throws SQLException {
        try (PreparedStatement preparedStatement = connection
                .prepareStatement("SELECT 1 FROM produtos WHERE codigo_barra = ?")) {
            preparedStatement.setString(1, codigoBarra);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                return resultSet.next();
            }
        }
    }

    // Atualiza a tabela do banco de dados com a lista de produtos fornecida
    public void atualizarTabelaBancoDados(List<Produto> produtos) {
        try {
            iniciarTransacao();

            // Atualiza apenas os registros existentes e adiciona os novos
            for (Produto produto : produtos) {
                if (registroExiste(produto.getCodigoBarra())) {
                    atualizarProduto(produto);
                } else {
                    adicionarProduto(produto);
                }
            }

            finalizarTransacao();
        } catch (SQLException e) {
            rollbackTransacao();
            System.err.println("Erro ao atualizar tabela no banco de dados.");
            e.printStackTrace();
        }
    }

    // Atualiza os dados de um produto no banco de dados
    private void atualizarProduto(Produto produto) throws SQLException {
        // Atualiza os dados do produto no banco de dados
        String sql = "UPDATE produtos SET nome=?, quantidade=?, preco=? WHERE codigo_barra=?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setString(1, produto.getNome());
            preparedStatement.setInt(2, produto.getQuantidade());
            preparedStatement.setDouble(3, produto.getPreco());
            preparedStatement.setString(4, produto.getCodigoBarra());
            preparedStatement.executeUpdate();
            System.out.println("Produto atualizado com sucesso!");
        }
    }

    // Obtém a conexão, abrindo-a se estiver fechada
    private void obterConexao() throws SQLException {
        if (connection == null || connection.isClosed()) {
            connection = ConnectionFactory.getConnection();
        }
    }

    // Fecha a conexão com o banco de dados
    public void fecharConexao() {
        ConnectionFactory.closeConnection(this.connection);
    }
}
