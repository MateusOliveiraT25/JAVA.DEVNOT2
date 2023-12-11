package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Clientes;

public class ClientesDAO {
    private final Connection connection;

    public ClientesDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS clientes_vip (NOME VARCHAR(255), CPF VARCHAR(255) PRIMARY KEY)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.execute();
            System.out.println("Tabela criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public List<Clientes> listarTodos() {
        List<Clientes> clientes = new ArrayList<>();
        String sql = "SELECT * FROM clientes_vip";
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                Clientes cliente = new Clientes(
                        rs.getString("nome"),
                        rs.getString("cpf")
                );
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println("Erro ao listar todos os clientes: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        return clientes;
    }

    public boolean cadastrarUsuario(String nome, String cpf) {
        String sql = "INSERT INTO clientes_vip (nome, cpf) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Usuário cadastrado com sucesso");
            return true;
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar usuário no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void atualizar(String nome, String cpf) {
        String sql = "UPDATE clientes_vip SET nome = ? WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, nome);
            stmt.setString(2, cpf);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public void apagar(String cpf) {
        String sql = "DELETE FROM clientes_vip WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
    }

    public Clientes obterClientePorCpf(String cpf) {
        String sql = "SELECT * FROM clientes_vip WHERE cpf = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, cpf);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Clientes(rs.getString("nome"), rs.getString("cpf"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Erro ao obter cliente por CPF: " + e.getMessage());
        } finally {
            ConnectionFactory.closeConnection(connection);
        }
        return null;
    }
}
