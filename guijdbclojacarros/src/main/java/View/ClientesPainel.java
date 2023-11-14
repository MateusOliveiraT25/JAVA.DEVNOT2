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
// Configura a ação do botão "cadastrar" para adicionar um novo registro no banco
//de dados
cadastrar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "cadastrar" do objeto operacoes com os valores dos
    
    //campos de entrada
    
    operacoes.cadastrar(clienteNomeField.getText(), clienteEnderecoField.getText(),
    
    clienteTelefoneField.getText(),clienteEmailField.getText(), clienteCPFField.getText());
    // Limpa os campos de entrada após a operação de cadastro
    clienteNomeField.setText("");
    clienteEnderecoField.setText("");
    clienteTelefoneField.setText("");
    clienteEmailField.setText("");
    clienteCPFField.setText("");
    }
    });

// Configura a ação do botão "editar" para atualizar um registro no banco de
// dados
editar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "atualizar" do objeto operacoes com os valores dos
    
    //campos de entrada
    
    operacoes.atualizar(clienteNomeField.getText(), clienteEnderecoField.getText(),
    
    clienteTelefoneField.getText(),clienteEmailField.getText(), clienteCPFField.getText());
    // Limpa os campos de entrada após a operação de atualização
    clienteNomeField.setText("");
    clienteEnderecoField.setText("");
    clienteTelefoneField.setText("");
    clienteEmailField.setText("");
    clienteCPFField.setText("");
    }
    });
// Configura a ação do botão "apagar" para excluir um registro no banco de dados
apagar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "apagar" do objeto operacoes com o valor do campo de
    
    //entrada "placa"
    
    operacoes.apagar(clienteCPFField.getText());
    // Limpa os campos de entrada após a operação de exclusão
    clienteNomeField.setText("");
    clienteEnderecoField.setText("");
    clienteTelefoneField.setText("");
    clienteEmailField.setText("");
    clienteCPFField.setText("");
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