package View;

import java.awt.event.*;
import java.awt.*;
import java.util.List;

import javax.swing.table.DefaultTableModel;

import Controller.ClientesControl;
import Controller.ClientesDAO;

import javax.swing.*;

import Model.Clientes;

public class ClientesPainel extends JPanel {
    private JButton cadastrar, apagar, editar, buscar;
    private JTextField clienteCPFField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public ClientesPainel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        add(new JLabel("Cadastro Clientes"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("CPF"));
        clienteCPFField = new JTextField(20);
        inputPanel.add(clienteCPFField);

        add(inputPanel);

        JPanel botoes = new JPanel();
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        buscar = new JButton("Buscar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        botoes.add(buscar);
        add(botoes);

        JScrollPane jScrollPane = new JScrollPane();
        add(jScrollPane);
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF", "VIP", "Endereço", "Telefone", "Email" });
        table = new JTable(tableModel);
        jScrollPane.setViewportView(table);

        new ClientesDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    clienteCPFField.setText((String) table.getValueAt(linhaSelecionada, 1));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

     buscar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        String cpfBusca = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para buscar:", "Busca por CPF", JOptionPane.QUESTION_MESSAGE);
        if (cpfBusca != null && !cpfBusca.isEmpty()) {
            List<Clientes> resultados = operacoes.buscarPorCpf(cpfBusca);
            // Adicione lógica aqui para exibir os resultados na tabela ou realizar outra ação apropriada.
        }
    }
});


        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Adiciona lógica para verificar se o cliente é VIP
                int resposta = JOptionPane.showConfirmDialog(null, "Este cliente é VIP?", "Verificação de VIP", JOptionPane.YES_NO_OPTION);
                
                if (resposta == JOptionPane.YES_OPTION) {
                    // Adiciona lógica para tratamento de clientes VIP
                    JOptionPane.showMessageDialog(null, "Cliente VIP");
                } else {
                    // Adiciona lógica para tratamento de clientes não VIP
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        boolean cadastroSucesso = operacoes.cadastrar(
                                "",
                                clienteCPFField.getText(),
                                "",
                                "",
                                "");

                        if (cadastroSucesso) {
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                            clienteCPFField.setText("");
                            atualizarTabela();
                        }
                    }
                }
            }
        });
    }

  private void atualizarTabela(List<Clientes> resultados) {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    
    // Adiciona os dados dos clientes encontrados como novas linhas na tabela Swing
    for (Clientes cliente : resultados) {
        Object[] rowData = { cliente.getNome(), cliente.getCpf() };
        tableModel.addRow(rowData);

        // Se o CPF estiver cadastrado, define a cor verde para a célula do CPF
        int rowIndex = tableModel.getRowCount() - 1;
        table.getColumnModel().getColumn(1).setCellRenderer(new CustomTableCellRenderer(cliente.getCpf(), rowIndex));
    }
    
    // Se não houver resultados, pergunta ao usuário se deseja cadastrar o cliente
    if (resultados.isEmpty()) {
        int confirmacao = JOptionPane.showConfirmDialog(null, "CPF não cadastrado. Deseja cadastrar este cliente?", "Confirmação de Cadastro", JOptionPane.YES_NO_OPTION);

        if (confirmacao == JOptionPane.YES_OPTION) {
            // Adicione a lógica aqui para cadastrar o cliente
            boolean cadastroSucesso = operacoes.cadastrar(
                    "",
                    clienteCPFField.getText(),
                    "",
                    "",
                    "");

            if (cadastroSucesso) {
                JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                clienteCPFField.setText("");
            }
            
            // Atualiza a tabela após cadastrar o cliente
            atualizarTabela();
        }
    }
}

// Classe para definir a cor da célula com base no CPF
class CustomTableCellRenderer extends DefaultTableCellRenderer {
    private String cpf;
    private int rowIndex;

    public CustomTableCellRenderer(String cpf, int rowIndex) {
        this.cpf = cpf;
        this.rowIndex = rowIndex;
    }

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
        Component rendererComponent = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

        // Se o CPF estiver cadastrado, define a cor verde
        if (ClientesDAO.existeClienteComCpf(cpf)) {
            rendererComponent.setForeground(Color.GREEN);
        } else {
            // Se o CPF não estiver cadastrado, define a cor vermelha
            rendererComponent.setForeground(Color.RED);
        }

        return rendererComponent;
    }
}
