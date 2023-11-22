package View;
import java.awt.event.*;
import java.awt.*;
import java.util.List; // Alteração aqui

import javax.swing.table.DefaultTableModel;

import Controller.ClientesControl;
import Controller.ClientesDAO;

import javax.swing.*;

import Model.Clientes;
public class ClientesPainel extends JPanel {
    // Atributos(componentes)
private JButton cadastrar, apagar, editar;
private JTextField clienteNomeField,clienteEnderecoField, clienteTelefoneField,clienteEmailField,clienteCPFField;
private List <Clientes> clientes;
private JTable table;
private DefaultTableModel tableModel;
private int linhaSelecionada = -1;
    // Construtor(GUI-JPanel)
public ClientesPainel() {
super();
// entrada de dados
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
add(new JLabel("Cadastro Clientes"));
JPanel inputPanel = new JPanel();
inputPanel.setLayout(new GridLayout(5, 2));
inputPanel.add(new JLabel("Nome"));
clienteNomeField = new JTextField(20);
inputPanel.add(clienteNomeField);
inputPanel.add(new JLabel("Endereço"));
clienteEnderecoField = new JTextField(20);
inputPanel.add(clienteEnderecoField);
inputPanel.add(new JLabel("Nº Telefone"));
clienteTelefoneField = new JTextField(20);
inputPanel.add(clienteTelefoneField);
inputPanel.add(new JLabel("Email"));
clienteEmailField = new JTextField(20);
inputPanel.add(clienteEmailField);
inputPanel.add(new JLabel("CPF"));
clienteCPFField = new JTextField(20);
inputPanel.add(clienteCPFField);
add(inputPanel);
JPanel botoes = new JPanel();
botoes.add(cadastrar = new JButton("Cadastrar"));
botoes.add(editar = new JButton("Editar"));
botoes.add(apagar = new JButton("Apagar"));
add(botoes);
// tabela de carros
JScrollPane jSPane = new JScrollPane();
add(jSPane);
tableModel = new DefaultTableModel(new Object[][] {},
new String[] { "Nome", "Endereco", "N° Telefone", "Email", "CPF" });
table = new JTable(tableModel);
jSPane.setViewportView(table);

//criar BD
new ClientesDAO().criaTabela();
//atualizar tabela
atualizarTabela();

// tratamento de eventos contrutor
table.addMouseListener(new MouseAdapter() {
    @Override
    public void mouseClicked(MouseEvent evt) {
    linhaSelecionada = table.rowAtPoint(evt.getPoint());
    if (linhaSelecionada != -1) {
    clienteNomeField.setText((String) table.getValueAt(linhaSelecionada, 0));
    clienteEnderecoField.setText((String) table.getValueAt(linhaSelecionada, 1));
    clienteTelefoneField.setText((String) table.getValueAt(linhaSelecionada, 2));
    clienteEmailField.setText((String) table.getValueAt(linhaSelecionada, 3));
    clienteCPFField.setText((String) table.getValueAt(linhaSelecionada, 4));
    }
    }
    });

  ClientesControl operacoes = new ClientesControl(clientes, tableModel, table);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String telefone = clienteTelefoneField.getText();
                    if (telefone.isEmpty() || !telefone.matches("\\d{11}")) {
                        JOptionPane.showMessageDialog(null, "Telefone inválido. Insira um número de telefone válido (10 dígitos).", "Erro", JOptionPane.ERROR_MESSAGE);
                        clienteTelefoneField.setForeground(Color.RED);
                        return;
                    }

                    String cpf = clienteCPFField.getText();
                    if (cpf.isEmpty() || !cpf.matches("\\d{11}")) {
                        JOptionPane.showMessageDialog(null, "CPF inválido. Insira um CPF válido (11 dígitos numéricos).", "Erro", JOptionPane.ERROR_MESSAGE);
                        clienteCPFField.setForeground(Color.RED);
                        return;
                    }

                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        boolean cadastroSucesso = operacoes.cadastrar(
                                clienteNomeField.getText(),
                                clienteEnderecoField.getText(),
                                clienteTelefoneField.getText(),
                                clienteEmailField.getText(),
                                clienteCPFField.getText());

                        if (cadastroSucesso) {
                            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                            clienteNomeField.setText("");
                            clienteEnderecoField.setText("");
                            clienteTelefoneField.setText("");
                            clienteEmailField.setText("");
                            clienteCPFField.setText("");
                            atualizarTabela();
                        } 
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato. Certifique-se de inserir números válidos para Telefone e CPF.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente editar este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    operacoes.atualizar(
                            clienteNomeField.getText(),
                            clienteEnderecoField.getText(),
                            clienteTelefoneField.getText(),
                            clienteEmailField.getText(),
                            clienteCPFField.getText());
                    clienteNomeField.setText("");
                    clienteEnderecoField.setText("");
                    clienteTelefoneField.setText("");
                    clienteEmailField.setText("");
                    clienteCPFField.setText("");
                    atualizarTabela();
                }
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar este cliente?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    operacoes.apagar(clienteCPFField.getText());
                    clienteNomeField.setText("");
                    clienteEnderecoField.setText("");
                    clienteTelefoneField.setText("");
                    clienteEmailField.setText("");
                    clienteCPFField.setText("");
                    atualizarTabela();
                }
            }
        });
    }

// Método para atualizar a tabela de exibição com dados do banco de dados
private void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    clientes = new ClientesDAO().listarTodos();
    // Obtém os carros atualizados do banco de dados
    for (Clientes clientes : clientes) {
    // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    tableModel.addRow(new Object[] { clientes.getNome(), clientes.getEndereco(),
    
    clientes.getTelefone(), clientes.getEmail(), clientes.getCpf() });
    }
    }

}
