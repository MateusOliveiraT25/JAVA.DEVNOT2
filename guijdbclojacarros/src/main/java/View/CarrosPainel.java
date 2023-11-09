package View;

import java.awt.*;
import java.util.List; // Alteração aqui

import javax.swing.table.DefaultTableModel;

import Controller.CarrosDAO;

import javax.swing.*;

import Model.Carros;
public class CarrosPainel extends JPanel {
    // Atributos(componentes)
private JButton cadastrar, apagar, editar;
private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField,carValorField;
private List <Carros> carros;
private JTable table;
private DefaultTableModel tableModel;
private int linhaSelecionada = -1;
    // Construtor(GUI-JPanel)
public CarrosPainel() {
super();
// entrada de dados
setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
add(new JLabel("Cadastro Carros"));
JPanel inputPanel = new JPanel();
inputPanel.setLayout(new GridLayout(5, 2));
inputPanel.add(new JLabel("Marca"));
carMarcaField = new JTextField(20);
inputPanel.add(carMarcaField);
inputPanel.add(new JLabel("Modelo"));
carModeloField = new JTextField(20);
inputPanel.add(carModeloField);
inputPanel.add(new JLabel("Ano"));
carAnoField = new JTextField(20);
inputPanel.add(carAnoField);
inputPanel.add(new JLabel("Placa"));
carPlacaField = new JTextField(20);
inputPanel.add(carPlacaField);
inputPanel.add(new JLabel("Valor"));
carValorField = new JTextField(20);
inputPanel.add(carValorField);
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
new String[] { "Marca", "Modelo", "Ano", "Placa", "Valor" });
table = new JTable(tableModel);
jSPane.setViewportView(table);

//criar BD
new CarrosDAO().criaTabela();
//atualizar tabela
atualizarTabela();
}





// Método para atualizar a tabela de exibição com dados do banco de dados
private void atualizarTabela() {
    tableModel.setRowCount(0); // Limpa todas as linhas existentes na tabela
    carros = new CarrosDAO().listarTodos();
    // Obtém os carros atualizados do banco de dados
    for (Carros carro : carros) {
    // Adiciona os dados de cada carro como uma nova linha na tabela Swing
    tableModel.addRow(new Object[] { carro.getMarca(), carro.getModelo(),
    
    carro.getAno(), carro.getPlaca(), carro.getValor() });
    }
    }

}