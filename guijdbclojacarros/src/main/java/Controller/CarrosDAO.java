package Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Connection.ConnectionFactory;
import Model.Carros;

public class CarrosDAO {
    // Variáveis de conexão e lista de carros
    private Connection connection;
    private List<Carros> carros;

    // Construtor para inicializar a conexão
    public CarrosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    // Método para criar a tabela carros_lojacarros
    public void criaTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS carros_lojacarros (MARCA VARCHAR(255), MODELO VARCHAR(255), ANO INT, PLACA VARCHAR(255) PRIMARY KEY, VALOR INT)";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela criada com sucesso.");

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    // Método para recuperar uma lista de todos os carros do banco de dados
    public List<Carros> listarTodos() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        carros = new ArrayList<>();
        try {
            stmt = connection.prepareStatement("SELECT * FROM carros_lojacarros");
            rs = stmt.executeQuery();
            while (rs.next()) {
                Carros carro = new Carros(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getInt("valor")
                );
                carros.add(carro);
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }
        return carros;
    }

    // Método para inserir um novo carro no banco de dados
    public void cadastrar(String marca, String modelo, int ano, String placa, int valor) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO carros_lojacarros (marca, modelo, ano, placa, valor) VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setInt(3, ano);
            stmt.setString(4, placa);
            stmt.setInt(5, valor);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para atualizar informações de um carro no banco de dados
    public void atualizar(String marca, String modelo, int ano, String placa, int valor) {
        PreparedStatement stmt = null;
        String sql = "UPDATE carros_lojacarros SET marca = ?, modelo = ?, ano = ?, valor =? WHERE placa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setInt(3, ano);
            stmt.setInt(4, valor);
            stmt.setString(5, placa);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para excluir um carro do banco de dados
    public void apagar(String placa) {
        PreparedStatement stmt = null;
        String sql = "DELETE FROM carros_lojacarros WHERE placa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, placa);
            stmt.executeUpdate();
            System.out.println("Dado apagado com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao apagar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    // Método para obter um carro por sua placa
    public Carros obterCarroPorPlaca(String placa) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Carros carro = null;

        try {
            stmt = connection.prepareStatement("SELECT * FROM carros_lojacarros WHERE placa = ?");
            stmt.setString(1, placa);
            rs = stmt.executeQuery();

            if (rs.next()) {
                carro = new Carros(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getInt("valor")
                );
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(null, stmt, rs);
        }

        return carro;
    }
}
