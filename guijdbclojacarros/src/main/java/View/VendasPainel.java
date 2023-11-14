/* 
package View;
import java.awt.event.*;
import java.awt.*;
import java.util.List; // Alteração aqui

import javax.swing.table.DefaultTableModel;

import Controller.VendasDAO;
import Controller.ClientesControl;
import Controller.ClientesDAO;
import Controller.VendasControl;

import javax.swing.*;

import Model.Clientes;
import Model.Vendas;
public class VendasPainel extends JPanel {
    // Atributos(componentes)
private JButton cadastrar, apagar, editar;
private JTextField vendasDataField,vendasCarroField, vendasClienteField,vendasCarrosQuantField,vendasValorTotalField;
private List <Vendas> vendas;
private JTable table;
private DefaultTableModel tableModel;
private int linhaSelecionada = -1;
    // Construtor(GUI-JPanel)
public VendasPainel() {
super();
// entrada de dados
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
add(new JLabel("Cadastro de Vendas"));
JPanel inputPanel = new JPanel();
inputPanel.setLayout(new GridLayout(5, 2));
inputPanel.add(new JLabel("Data da venda"));
vendasDataField = new JTextField(20);
inputPanel.add(vendasDataField);
inputPanel.add(new JLabel("Tipos de Carro"));
vendasCarroField = new JTextField(20);
inputPanel.add(vendasCarroField);
inputPanel.add(new JLabel("Nome do Cliente"));
vendasClienteField = new JTextField(20);
inputPanel.add(vendasClienteField);
inputPanel.add(new JLabel("Quantidade de vendas"));
vendasCarrosQuantField = new JTextField(20);
inputPanel.add(vendasCarrosQuantField);
inputPanel.add(new JLabel("Valor total"));
vendasValorTotalField = new JTextField(20);
inputPanel.add(vendasValorTotalField);
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
new String[] { "Data da venda", "Tipos de Carro", "Nome do Cliente", "Quantidade de vendas", "Valor total" });
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
    vendasDataField.setText((String) table.getValueAt(linhaSelecionada, 0));
    vendasCarroField.setText((String) table.getValueAt(linhaSelecionada, 1));
    vendasClienteField.setText((String) table.getValueAt(linhaSelecionada, 2));
    vendasCarrosQuantField.setText((String) table.getValueAt(linhaSelecionada, 3));
    vendasValorTotalField.setText((String) table.getValueAt(linhaSelecionada, 4));
    }
    }
    });

    VendasControl operacoes = new  VendasControl ( vendas, tableModel, table);
// Configura a ação do botão "cadastrar" para adicionar um novo registro no banco
//de dados
cadastrar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "cadastrar" do objeto operacoes com os valores dos
    
    //campos de entrada
    
    operacoes.cadastrar(vendasDataField.getText(), vendasCarroField.getText(),
    
    vendasClienteField.getText(),vendasCarrosQuantField.getText(), vendasValorTotalField.getText());
    // Limpa os campos de entrada após a operação de cadastro
    vendasDataField.setText("");
    vendasCarroField.setText("");
    vendasClienteField.setText("");
    vendasCarrosQuantField.setText("");
    vendasValorTotalField.setText("");
    }
    });

// Configura a ação do botão "editar" para atualizar um registro no banco de
// dados
editar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "atualizar" do objeto operacoes com os valores dos
    
    //campos de entrada
    
    operacoes.atualizar(vendasDataField.getText(), vendasCarroField.getText(),
    
    vendasClienteField.getText(),vendasCarrosQuantField.getText(), vendasValorTotalField.getText());
    // Limpa os campos de entrada após a operação de atualização
    vendasDataField.setText("");
    vendasCarroField.setText("");
    vendasClienteField.setText("");
    vendasCarrosQuantField.setText("");
    vendasValorTotalField.setText("");
    }
    });

// Configura a ação do botão "apagar" para excluir um registro no banco de dados
apagar.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
    // Chama o método "apagar" do objeto operacoes com o valor do campo de
    
    //entrada "placa"
    
    operacoes.apagar(vendasDataField.getText());
    // Limpa os campos de entrada após a operação de exclusão
        vendasDataField.setText("");
    vendasCarroField.setText("");
    vendasClienteField.setText("");
    vendasCarrosQuantField.setText("");
    vendasValorTotalField.setText("");
    }
    });


}

// Método para atualizar a tabela de exibição com dados do banco de dados
private void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    vendas = new VendasDAO().listarTodos();
    // Obtém os carros atualizados do banco de dados
    for (Vendas vendas : vendas) {
    // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    tableModel.addRow(new Object[] { vendas.getData(), vendas.getCarro(),
    
    vendas.getCliente(), vendas.getCarrosQuant(), vendas.getValorTotal() });
    }
    }

}*/