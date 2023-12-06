package View;

import java.awt.event.*;
import java.awt.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import java.util.List;
import Controller.ClientesControl;
import Controller.ClientesDAO;
import Model.Clientes;

public class ClientesPainel extends JPanel {
    private JButton cadastrar, apagar, editar, buscar;
    private JTextField clienteCPFField, clienteNomeField;
    private List<Clientes> clientes;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public ClientesPainel() {
        super();
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        // Diálogo inicial para verificar se o usuário está cadastrado
        int respostaCadastro = JOptionPane.showConfirmDialog(null, "Você faz parte do clube de membros?", "Verificação de Cadastro", JOptionPane.YES_NO_OPTION);
        if (respostaCadastro == JOptionPane.NO_OPTION) {
            // Adicionar lógica para cadastrar o usuário
            cadastrarUsuario();
        }

        add(new JLabel("Cadastro Clientes"));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(2, 2));

        inputPanel.add(new JLabel("CPF"));
        clienteCPFField = new JTextField(20);
        inputPanel.add(clienteCPFField);

        inputPanel.add(new JLabel("Nome"));
        clienteNomeField = new JTextField(20);
        inputPanel.add(clienteNomeField);

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
        tableModel = new DefaultTableModel(new Object[][] {}, new String[] { "Nome", "CPF" });
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
                    clienteNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
                }
            }
        });

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        buscar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfBusca = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para buscar:", "Busca por CPF", JOptionPane.QUESTION_MESSAGE);
                if (cpfBusca != null && !cpfBusca.isEmpty()) {
                    // Adicione lógica aqui para buscar o cliente pelo CPF e exibir os resultados na tabela
                    // Por exemplo, você pode chamar um método em ClientesControl para realizar a busca
                    // e atualizar a tabela com os resultados.
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
                                clienteNomeField.getText(),
                                clienteCPFField.getText(),
                                "",
                                "",
                                "");

                        if (cadastroSucesso) {
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                            clienteCPFField.setText("");
                            clienteNomeField.setText("");
                            atualizarTabela();
                        }
                    }
                }
            }
        });
    }

    private void cadastrarUsuario() {
        JTextField nomeField = new JTextField();
        JTextField cpfField = new JTextField();
    
        JPanel panel = new JPanel(new GridLayout(2, 2));
        panel.add(new JLabel("Nome:"));
        panel.add(nomeField);
        panel.add(new JLabel("CPF:"));
        panel.add(cpfField);
    
        int option = JOptionPane.showConfirmDialog(null, panel, "Cadastro de Usuário", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            // Coletar os dados dos campos e chamar o método de cadastro do usuário
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
    
            ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);
            operacoes.cadastrarUsuario(nome, cpf);
        }
    }

    private void atualizarTabela() {
        // Lógica para atualizar a tabela com dados do banco de dados
        // ...
    }

    public DefaultTableModel getTableDefaultModel() {
        return tableModel;
    }

    public JTable getTable() {
        return table;
    }
}
