package Controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import Model.Carros;
import Model.Clientes;
import Model.Vendas;

public class VendasControl {
    private List<Vendas> vendas;
    private DefaultTableModel tableModel;

    public VendasControl(List<Vendas> vendas, DefaultTableModel tableModel) {
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
        return false;
    }
}
