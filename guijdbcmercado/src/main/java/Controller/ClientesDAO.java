package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Clientes;

public class ClientesDAO {
    // Variáveis de conexão e lista de clientes
    private Connection connection;
    private List<Clientes> clientes;

    // Construtor para inicializar a conexão
    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para criar a tabela clientes_lojacarros
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_vip (NOME VARCHAR(255),ENDERECO VARCHAR(255),TELEFONE VARCHAR(255),CPF VARCHAR(255) PRIMARY KEY, EMAIL VARCHAR(255))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para recuperar uma lista de todos os clientes do banco de dados
    public List<Clientes> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        clientes = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_vip");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                    
                        rs.getString("cpf")
                );
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return clientes;
    }

    // Método para inserir um novo cliente no banco de dados
    public void cadastrar(String nome, String endereco, String telefone, String email, String cpf) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO clientes_vip (nome, endereco, telefone, email, cpf) VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para atualizar informações de um cliente no banco de dados
    public void atualizar(String nome, String endereco, String telefone, String email, String cpf) {
        PreparedStatement stmt = null;
        String sql = "UPDATE clientes_vip SET nome = ?, cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para excluir um cliente do banco de dados
    public void apagar(String cpf) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM clientes_vip WHERE cpf = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para obter um cliente por seu CPF
    public Clientes obterClientePorCpf(String cpf) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Clientes cliente = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM clientes_vip WHERE cpf = ?");
            stmt.setString(1, cpf);
            rs = stmt.executeQuery();

            if (rs.next()) {
                cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("cpf")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(null, stmt, rs);
        }

        return cliente;
    }
    // Método para verificar se existe um cliente com o CPF fornecido
    public static boolean existeClienteComCpf(String cpf) {
        Clientes cliente = obterClientePorCpf(cpf);
        return cliente != null;
    }

}
