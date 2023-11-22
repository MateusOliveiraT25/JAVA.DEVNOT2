/* 
package View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import Controller.VendasControl;
import Model.Clientes;
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
        // Lógica para obter a lista de clientes e atualizar o ComboBox
        // Utilize o método listarTodos() da classe ClientesDAO para obter a lista de clientes
        // Atualize o ComboBox com os CPFs dos clientes
        // Exemplo fictício:
        clientesComboBox.addItem("Selecione um cliente...");
        clientesComboBox.addItem("111.222.333-44");
        clientesComboBox.addItem("555.666.777-88");
    }

    // Atualiza o ComboBox de carros
    private void atualizarComboBoxCarros() {
        // Lógica para obter a lista de carros e atualizar o ComboBox
        // Utilize o método listarTodos() da classe CarrosDAO para obter a lista de carros
        // Atualize o ComboBox com as placas dos carros
        // Exemplo fictício:
        carrosComboBox.addItem("Selecione um carro...");
        carrosComboBox.addItem("ABC1234");
        carrosComboBox.addItem("XYZ5678");
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
        // Exemplo fictício:
        Clientes cliente = obterClientePorCpf(clienteCpf);
        Carros carro = obterCarroPorPlaca(selectedCarroPlaca);

        // Lógica para realizar a venda
        // Utilize o método realizarVenda() da classe VendasControl
        // Exemplo fictício:
        boolean vendaRealizada = realizarVenda(cliente, carro);

        if (vendaRealizada) {
            JOptionPane.showMessageDialog(this, "Venda realizada com sucesso!");
            // Atualize os ComboBox de clientes e carros após a venda
            atualizarComboBoxClientes();
            atualizarComboBoxCarros();
        } else {
            JOptionPane.showMessageDialog(this, "Erro ao realizar a venda. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Método fictício para obter um cliente por CPF
    private Clientes obterClientePorCpf(String cpf) {
        // Lógica para obter o cliente por CPF
        // Utilize o método obterClientePorCpf() da classe ClientesDAO
        // Exemplo fictício:
        ClientesDAO clientesDAO = new ClientesDAO();
        return clientesDAO.obterClientePorCpf(cpf);
    }

    // Método fictício para obter um carro por placa
    private Carros obterCarroPorPlaca(String placa) {
        // Lógica para obter o carro por placa
        // Utilize o método obterCarroPorPlaca() da classe CarrosDAO
        // Exemplo fictício:
        CarrosDAO carrosDAO = new CarrosDAO();
        return carrosDAO.obterCarroPorPlaca(placa);
    }

    // Método fictício para realizar a venda
    private boolean realizarVenda(Clientes cliente, Carros carro) {
        // Lógica para realizar a venda
        // Utilize o método realizarVenda() da classe VendasControl
        // Exemplo fictício:
        VendasControl vendasControl = new VendasControl();
        return vendasControl.realizarVenda(cliente, carro);
    }

 
}



*/
