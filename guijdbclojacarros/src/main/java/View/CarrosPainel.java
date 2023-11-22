package View;
import java.awt.*;
import java.awt.event.*;
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
         // Configuração da tabela e seu modelo
        JScrollPane jSPane = new JScrollPane();
        add(jSPane);
        tableModel = new DefaultTableModel(new Object[][]{},
                new String[]{"Marca", "Modelo", "Ano", "Placa", "Valor"});
        table = new JTable(tableModel);
        jSPane.setViewportView(table);

        // Configuração de eventos de clique na tabela
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
      // Configuração das operações de controle
        CarrosControl operacoes = new CarrosControl(carros, tableModel, table);
 // Ação do botão "Cadastrar"
        cadastrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try { // Verificação de validade do ano inserido
                    if (!isNumeroValido(carAnoField.getText()) || Integer.parseInt(carAnoField.getText()) < 1886) {
                        JOptionPane.showMessageDialog(null, "Ano inválido. Insira um ano numérico válido maior que 1886.", "Erro", JOptionPane.ERROR_MESSAGE);
                         carAnoField.setForeground(Color.RED);
                        return;
                    }
                    // Verificação de validade do valor inserido
                    if (!isNumeroValido(carValorField.getText())) {
                        JOptionPane.showMessageDialog(null, "Valor inválido. Insira um valor numérico válido.", "Erro", JOptionPane.ERROR_MESSAGE);
                         carValorField.setForeground(Color.RED);
                        return;
                    }
  // Confirmação do cadastro
                    int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente cadastrar este carro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                    if (confirmacao == JOptionPane.YES_OPTION) {
                        // Execução do cadastro
                        boolean cadastroSucesso = operacoes.cadastrar(
                                carMarcaField.getText(),
                                carModeloField.getText(),
                                Integer.parseInt(carAnoField.getText()),
                                carPlacaField.getText(),
                                Integer.parseInt(carValorField.getText()));
     // Exibição de mensagem de sucesso ou erro
                        if (cadastroSucesso) {
                            JOptionPane.showMessageDialog(null, "Carro cadastrado com sucesso!");
                            carMarcaField.setText("");
                            carModeloField.setText("");
                            carAnoField.setText("");
                            carPlacaField.setText("");
                            carValorField.setText("");
                            atualizarTabela();
                        } 
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Erro de formato. Certifique-se de inserir números válidos para Ano e Valor.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
 // Ação do botão "Editar"
        editar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente editar este carro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
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
            }
        });
  // Ação do botão "Apagar"
        apagar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja realmente apagar este carro?", "Confirmação", JOptionPane.YES_NO_OPTION);
                if (confirmacao == JOptionPane.YES_OPTION) {
                    operacoes.apagar(carPlacaField.getText());
                    carMarcaField.setText("");
                    carModeloField.setText("");
                    carAnoField.setText("");
                    carPlacaField.setText("");
                    carValorField.setText("");
                    atualizarTabela();
                }
            }
        });
    }
 // Atualiza a tabela com os dados mais recentes
    private void atualizarTabela() {
        tableModel.setRowCount(0);
        carros = new CarrosDAO().listarTodos();
        for (Carros carro : carros) {
            tableModel.addRow(new Object[]{carro.getMarca(), carro.getModelo(),
                    carro.getAno(), carro.getPlaca(), carro.getValor()});
        }
    }

    // Método auxiliar para verificar se uma string contém apenas números
    private boolean isNumeroValido(String texto) {
        try {
            Integer.parseInt(texto);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JFrame frame = new JFrame("Cadastro de Carros");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(new CarrosPainel());
                frame.setPreferredSize(new Dimension(600, 400));
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }
}
