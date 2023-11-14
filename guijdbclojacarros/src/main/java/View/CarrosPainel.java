package View;

import java.awt.event.*;
import java.awt.*;
import java.util.List;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;

import Controller.CarrosControl;
import Controller.CarrosDAO;
import Model.Carros;

public class CarrosPainel extends JPanel {
    private JButton cadastrar, apagar, editar;
    private JTextField carMarcaField, carModeloField, carAnoField, carPlacaField, carValorField;
    private List<Carros> carros;
    private JTable table;
    private DefaultTableModel tableModel;
    private int linhaSelecionada = -1;

    public CarrosPainel() {
        super();
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
        cadastrar = new JButton("Cadastrar");
        editar = new JButton("Editar");
        apagar = new JButton("Apagar");
        botoes.add(cadastrar);
        botoes.add(editar);
        botoes.add(apagar);
        add(botoes);

        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][]{},
                new String[]{"Marca", "Modelo", "Ano", "Placa", "Valor"});
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        new CarrosDAO().criaTabela();
        atualizarTabela();

        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent evt) {
                linhaSelecionada = table.rowAtPoint(evt.getPoint());
                if (linhaSelecionada != -1) {
                    carMarcaField.setText((String) table.getValueAt(linhaSelecionada, 0));
                    carModeloField.setText((String) table.getValueAt(linhaSelecionada, 1));
                    carAnoField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 2)));  // Convertido para String
                    carPlacaField.setText((String) table.getValueAt(linhaSelecionada, 3));
                    carValorField.setText(String.valueOf(table.getValueAt(linhaSelecionada, 4)));  // Convertido para String
                }
            }
        });

        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);

        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean cadastroSucesso = operacoes.cadastrar(
                        carMarcaField.getText(),
                        carModeloField.getText(),
                        Integer.parseInt(carAnoField.getText()),
                        carPlacaField.getText(),
                        Integer.parseInt(carValorField.getText()));

                if (cadastroSucesso) {
                    JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");
                    atualizarTabela();
                } else {
                    JOptionPane.showMessageDialog(null, "Erro ao cadastrar o carro. Verifique os dados e tente novamente.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.atualizar(carMarcaField.getText(),
                        carModeloField.getText(),
                        Integer.parseInt(carAnoField.getText()),
                        carPlacaField.getText(),
                        Integer.parseInt(carValorField.getText()));
                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
                atualizarTabela();
            }
        });

        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operacoes.apagar(carPlacaField.getText());
                carMarcaField.setText("");
                carModeloField.setText("");
                carAnoField.setText("");
                carPlacaField.setText("");
                carValorField.setText("");
                atualizarTabela();
            }
        });
    }

    private void atualizarTabela() {
        tableModel.setRowCount(0);
        carros = new CarrosDAO().listarTodos();
        for (Carros carro : carros) {
            tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(),
                    carro.getAno(), carro.getPlaca(), carro.getValor()});
        }
    }
}
