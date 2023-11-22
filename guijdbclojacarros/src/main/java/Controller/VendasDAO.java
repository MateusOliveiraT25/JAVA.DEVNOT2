package Controller;

import Model.Carros;
import Model.Clientes;
import Model.Vendas;

import Connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class VendasDAO {
    private Connection connection;

    public VendasDAO() {
        this.connection = ConnectionFactory.getConnection();
    }

    public void criarTabela() {
        String sql = "CREATE TABLE IF NOT EXISTS vendas (ID INT PRIMARY KEY AUTO_INCREMENT, CLIENTE_CPF VARCHAR(255), CARRO_PLACA VARCHAR(255), VALOR_VENDA DOUBLE, FOREIGN KEY (CLIENTE_CPF) REFERENCES clientes_lojacarros(CPF), FOREIGN KEY (CARRO_PLACA) REFERENCES carros_lojacarros(PLACA))";
        try (Statement stmt = this.connection.createStatement()) {
            stmt.execute(sql);
            System.out.println("Tabela de vendas criada com sucesso.");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao criar a tabela de vendas: " + e.getMessage(), e);
        } finally {
            ConnectionFactory.closeConnection(this.connection);
        }
    }

    public void cadastrar(Vendas venda) {
        PreparedStatement stmt = null;
        String sql = "INSERT INTO vendas (cliente_cpf, carro_placa, valor_venda) VALUES (?, ?, ?)";

        try {
            stmt = connection.prepareStatement(sql);
            stmt.setString(1, venda.getCliente().getCpf());
            stmt.setString(2, venda.getCarro().getPlaca());
            stmt.setDouble(3, venda.getValorVenda());
            stmt.executeUpdate();
            System.out.println("Venda cadastrada com sucesso");
        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cadastrar venda no banco de dados.", e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt);
        }
    }

    public List<Vendas> listarTodas() {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Vendas> vendas = new ArrayList<>();

        try {
            stmt = connection.prepareStatement("SELECT * FROM vendas");
            rs = stmt.executeQuery();

            while (rs.next()) {
                // Aqui você precisará obter clientes e carros associados à venda
                // (use os DAOs correspondentes para isso)
                Clientes cliente = obterClientePorCpf(rs.getString("cliente_cpf"));
                Carros carro = obterCarroPorPlaca(rs.getString("carro_placa"));

                Vendas venda = new Vendas(cliente, carro, rs.getDouble("valor_venda"));
                vendas.add(venda);
            }
        } catch (SQLException e) {
            System.out.println(e);
        } finally {
            ConnectionFactory.closeConnection(connection, stmt, rs);
        }

        return vendas;
    }

    // Método para obter um cliente pelo CPF (você precisa implementar em ClientesDAO)
    private Clientes obterClientePorCpf(String cpf) {
        // Implemente conforme a lógica do seu ClientesDAO
        return null;
    }

    // Método para obter um carro pela placa (você precisa implementar em CarrosDAO)
    private Carros obterCarroPorPlaca(String placa) {
        // Implemente conforme a lógica do seu CarrosDAO
        return null;
    }
}
