 package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.util.List;
import Controller.CarrosDAO;
import Controller.ClientesDAO;
import Controller.VendasDAO;
import Model.Clientes;
import Model.Carros;
import Model.Vendas;

public class VendasPainel extends JPanel {
    private JButton realizarVenda;
    private JTextField clienteCpfField;
    private JComboBox<String> clientesComboBox, carrosComboBox;

    public VendasPainel() {
        super(new BorderLayout());

        // Criação de componentes
        clientesComboBox = new JComboBox<>();
        carrosComboBox = new JComboBox<>();
        clienteCpfField = new JTextField(20);
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
        clientesComboBox.removeAllItems(); // Limpa o ComboBox antes de atualizar
        ClientesDAO clientesDAO = new ClientesDAO();
        List<Clientes> listaClientes = clientesDAO.listarTodos();

        clientesComboBox.addItem("Selecione um cliente..."); // Adiciona um item default

        for (Clientes cliente : listaClientes) {
            clientesComboBox.addItem(cliente.getCpf());
        }
    }

    // Atualiza o ComboBox de carros
    private void atualizarComboBoxCarros() {
        carrosComboBox.removeAllItems(); // Limpa o ComboBox antes de atualizar
        CarrosDAO carrosDAO = new CarrosDAO();
        List<Carros> listaCarros = carrosDAO.listarTodos();

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
        ClientesDAO clientesDAO = new ClientesDAO();
        CarrosDAO carrosDAO = new CarrosDAO();
        Clientes cliente = clientesDAO.obterClientePorCpf(clienteCpf);
        Carros carro = carrosDAO.obterCarroPorPlaca(selectedCarroPlaca);

        // Lógica para realizar a venda
        // Utilize o método cadastrar() da classe VendasDAO para realizar a venda
        VendasDAO vendasDAO = new VendasDAO();
        double valorVenda = calcularValorVenda(); // Substitua isso pela lógica real
        Vendas venda = new Vendas(cliente, carro, valorVenda);
        vendasDAO.cadastrar(venda);

        JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
        // Atualize os ComboBox de clientes e carros após a venda
        atualizarComboBoxClientes();
        atualizarComboBoxCarros();
    }

    // Método fictício para calcular o valor da venda
    private double calcularValorVenda() {
        // Substitua isso pela lógica real de cálculo do valor da venda
        return 0.0;
    }
}
