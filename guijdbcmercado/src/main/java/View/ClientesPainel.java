package View;
import java.util.List;
import java.awt.*;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import Controller.ClientesControl;
import Controller.ClientesDAO;
import Model.Clientes;

public class ClientesPainel extends JPanel {
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
        clienteNomeField.setEditable(false); // Campo de nome não editável
        inputPanel.add(clienteNomeField);

        add(inputPanel);

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

        clienteCPFField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Lógica para buscar o cliente pelo CPF e preencher os campos
                String cpfBusca = clienteCPFField.getText();
                Clientes clienteEncontrado = operacoes.obterClientePorCPF(cpfBusca);

                if (clienteEncontrado != null) {
                    // Se o cliente foi encontrado, preencha os campos
                    clienteNomeField.setText(clienteEncontrado.getNome());
                } else {
                    // Caso contrário, exiba uma mensagem indicando que o cliente não foi encontrado
                    JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro de Busca", JOptionPane.ERROR_MESSAGE);
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
