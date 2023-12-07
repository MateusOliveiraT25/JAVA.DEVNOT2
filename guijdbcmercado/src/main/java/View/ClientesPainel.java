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
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;
    private JLabel resultadoLabel;

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
        clienteCPFField.setEditable(false); // Campo de nome não editável
        inputPanel.add(clienteCPFField);

        inputPanel.add(new JLabel("Nome"));
        clienteNomeField = new JTextField(20);
        clienteNomeField.setEditable(false); // Campo de nome não editável
        inputPanel.add(clienteNomeField);

        add(inputPanel);

        JPanel buttonPanel = new JPanel();
        JButton buscarButton = new JButton("Procurar");
        buttonPanel.add(buscarButton);
        add(buttonPanel);

        resultadoLabel = new JLabel();
        add(resultadoLabel);

        ClientesControl operacoes = new ClientesControl(clientes, tableModel, null); // Passando 'null' para a tabela, pois não a usaremos aqui

        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cpfBusca = JOptionPane.showInputDialog(null, "Digite o CPF do cliente para buscar:", "Busca por CPF", JOptionPane.QUESTION_MESSAGE);
                if (cpfBusca != null && !cpfBusca.isEmpty()) {
                    Clientes clienteEncontrado = operacoes.obterClientePorCPF(cpfBusca);
                    if (clienteEncontrado != null) {
                        clienteCPFField.setText(clienteEncontrado.getCpf());
                        clienteNomeField.setText(clienteEncontrado.getNome());
                        resultadoLabel.setText("Resultado da Busca: CPF - " + clienteEncontrado.getCpf() + ", Nome - " + clienteEncontrado.getNome());
                    } else {
                        JOptionPane.showMessageDialog(null, "Cliente não encontrado", "Erro de Busca", JOptionPane.ERROR_MESSAGE);
                        resultadoLabel.setText("Resultado da Busca: Cliente não encontrado");
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
            String nome = nomeField.getText();
            String cpf = cpfField.getText();
    
            ClientesControl operacoes = new ClientesControl(clientes, tableModel, null); // Passando 'null' para a tabela, pois não a usaremos aqui
            operacoes.cadastrarUsuario(nome, cpf);
        }
    }
}
