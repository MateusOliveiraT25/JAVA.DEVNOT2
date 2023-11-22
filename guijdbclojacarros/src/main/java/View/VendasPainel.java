 
package View;
import java.util.List;


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import Controller.CarrosDAO;
import Controller.ClientesDAO;
import Controller.VendasDAO;
import Model.Clientes;
import Model.Vendas;
import Model.Carros;

public class VendasPainel extends JPanel {
    private JButton realizarVenda;
    private JTextField clienteCpfField, carroPlacaField;
    private JComboBox<String> clientesComboBox, carrosComboBox;

    public VendasPainel() {
        super(new BorderLayout());

        // Criação de componentes
        clientesComboBox = new JComboBox<>();
        carrosComboBox = new JComboBox<>();
        clienteCpfField = new JTextField(20);
        carroPlacaField = new JTextField(20);
        realizarVenda = new JButton("Realizar Venda");

        // Popula os ComboBox com dados existentes
        atualizarComboBoxClientes();
        atualizarComboBoxCarros();

        // Adiciona os componentes ao painel
        JPanel formPanel = new JPanel(new GridLayout(3, 2));
        formPanel.add(new JLabel("Cliente (CPF):"));
        formPanel.add(clientesComboBox);
        formPanel.add(new JLabel("Carro (Placa):"));
        formPanel.add(carrosComboBox);
        formPanel.add(new JLabel("CPF do Cliente (se novo):"));
        formPanel.add(clienteCpfField);

        add(formPanel, BorderLayout.CENTER);
        add(realizarVenda, BorderLayout.SOUTH);

        // Adiciona ação ao botão de realizar venda
        realizarVenda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                realizarVenda();
            }
        });
    }

// Atualiza o ComboBox de clientes
private void atualizarComboBoxClientes() {
    // Limpa o ComboBox antes de atualizar
    clientesComboBox.removeAllItems();

    // Utiliza o método listarTodos() da classe ClientesDAO para obter a lista de clientes
    ClientesDAO clientesDAO = new ClientesDAO();
    List<Clientes> listaClientes = clientesDAO.listarTodos();

    // Adiciona os CPFs ao ComboBox
    clientesComboBox.addItem("Selecione um cliente..."); // Adiciona um item default

    for (Clientes cliente : listaClientes) {
        clientesComboBox.addItem(cliente.getCpf());
    }
}
   // Atualiza o ComboBox de carros
private void atualizarComboBoxCarros() {
    // Limpa o ComboBox antes de atualizar
    carrosComboBox.removeAllItems();

    // Utiliza o método listarTodos() da classe CarrosDAO para obter a lista de carros
    CarrosDAO carrosDAO = new CarrosDAO();
    List<Carros> listaCarros = carrosDAO.listarTodos();

    // Adiciona as placas dos carros ao ComboBox
    carrosComboBox.addItem("Selecione um carro..."); // Adiciona um item default

    for (Carros carro : listaCarros) {
        carrosComboBox.addItem(carro.getPlaca());
    }
}


   // Método para realizar a venda
private void realizarVenda() {
    String clienteCpf = clienteCpfField.getText().trim();
    String selectedCliente = (String) clientesComboBox.getSelectedItem();
    String selectedCarroPlaca = (String) carrosComboBox.getSelectedItem();

    if ("Selecione um cliente...".equals(selectedCliente)) {
        JOptionPane.showMessageDialog(this, "Selecione um cliente.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if ("Selecione um carro...".equals(selectedCarroPlaca)) {
        JOptionPane.showMessageDialog(this, "Selecione um carro.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    if (clienteCpf.isEmpty() && "Selecione um cliente...".equals(selectedCliente)) {
        JOptionPane.showMessageDialog(this, "Informe o CPF do cliente ou selecione um cliente existente.", "Erro", JOptionPane.ERROR_MESSAGE);
        return;
    }

    // Lógica para obter o cliente e o carro selecionados
    // Utilize os métodos obterClientePorCpf() e obterCarroPorPlaca() das respectivas classes DAO
    Clientes cliente = obterClientePorCpf(clienteCpf);
    Carros carro = obterCarroPorPlaca(selectedCarroPlaca);

    // Lógica para realizar a venda
    // Utilize o método cadastrar() da classe VendasDAO para realizar a venda
    VendasDAO vendasDAO = new VendasDAO();
    Vendas venda = new Vendas(cliente, carro, calcularValorVenda()); // Você precisa ajustar isso conforme a lógica do seu programa
    vendasDAO.cadastrar(venda);

    JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
    // Atualize os ComboBox de clientes e carros após a venda
    atualizarComboBoxClientes();
    atualizarComboBoxCarros();
}

private Clientes obterClientePorCpf(String clienteCpf) {
    return null;
}

private Carros obterCarroPorPlaca(String selectedCarroPlaca) {
    return null;
}

// Método fictício para calcular o valor da venda
private double calcularValorVenda() {
    // Lógica para calcular o valor da venda
    // Exemplo fictício:
    return 10000.0;
}



}