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
    private Connection connection;
    private List<Carros> carros;

    public CarrosDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

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

    public void cadastrar(String marca, String modelo, int i, String placa, int j) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO carros_lojacarros (marca, modelo, ano, placa, valor) VALUES (?, ?, ?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setInt(3, i);
            stmt.setString(4, placa);
            stmt.setInt(5, j);
            stmt.executeUpdate();
            System.out.println("Dados inseridos com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao inserir dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public void atualizar(String marca, String modelo, String ano, String placa, String valor) {
        PreparedStatement stmt = null;
        String sql = "UPDATE carros_lojacarros SET marca = ?, modelo = ?, ano = ?, valor =? WHERE placa = ?";
        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, marca);
            stmt.setString(2, modelo);
            stmt.setString(3, ano);
            stmt.setString(4, valor);
            stmt.setString(5, placa);
            stmt.executeUpdate();
            System.out.println("Dados atualizados com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao atualizar dados no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

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

    // Dentro da classe CarrosDAO
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

    public void atualizar(String marca, String modelo, int i, String placa, int j) {
    }
}
