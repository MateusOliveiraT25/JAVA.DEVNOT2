package Controller;

import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Model.Carros;
import Model.Clientes;
import Model.Vendas;

public class VendasControl {
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;
    private JTable table; 
    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel, JTable table) {
        this.vendas = vendas;
        this.tableModel = tableModel;
    }

    public void adicionarVenda(Clientes cliente, Carros carro, double valorVenda) {
        // Lógica para adicionar uma venda
        Vendas venda = new Vendas(cliente, carro, valorVenda);
        vendas.add(venda);

        // Atualizar a tabela
        atualizarTabela();
    }

    public void removerVenda(int indice) {
        // Lógica para remover uma venda
        if (indice >= 0 && indice < vendas.size()) {
            vendas.remove(indice);

            // Atualizar a tabela
            atualizarTabela();
        }
    }

    public List<Vendas> listarVendas() {
        // Retorna a lista de vendas
        return vendas;
    }

    private void atualizarTabela() {
        // Limpa todas as linhas existentes na tabela
        tableModel.setRowCount(0);

        // Adiciona os dados de cada venda como uma nova linha na tabela Swing
        for (Vendas venda : vendas) {
            tableModel.addRow(new Object[] {
                    venda.getCliente().getNome(),
                    venda.getCarro().getModelo(),
                    venda.getValorVenda()
            });
        }
    }

   public boolean realizarVenda(Clientes cliente, Carros carro) {
        if (cliente == null || carro == null) {
            // Verifica se cliente e carro são válidos
            System.out.println("Cliente ou carro inválido para realizar a venda.");
            return false;
        }

        // Obtém os detalhes do cliente e do carro
        String clienteCpf = cliente.getCpf();
        String carroPlaca = carro.getPlaca();
        double valorVenda = calcularValorVenda(carro); // Implemente o método conforme a lógica do seu sistema

        // Cria uma instância de Vendas com os dados obtidos
        Vendas venda = new Vendas(cliente, carro, valorVenda);

        // Chama o método cadastrar da classe VendasDAO para salvar a venda no banco de dados
        VendasDAO vendasDAO = new VendasDAO();
        vendasDAO.cadastrar(venda);

        return true;
    }

    // Exemplo de método para calcular o valor da venda (ajuste conforme sua lógica)
    private double calcularValorVenda(Carros carro) {
        // Implemente conforme a lógica do seu sistema
        return carro.getValor() * 1.1; // Aumenta o valor em 10% como exemplo
    }
}