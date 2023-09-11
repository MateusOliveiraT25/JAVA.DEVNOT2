import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraCustoViagem extends JFrame implements ActionListener {
    private JTextField distanciaField, consumoField, precoField;
    private JButton calcularButton, apagarButton,limparButton, sairButton;

    public CalculadoraCustoViagem() {
        super("Calculadora de Custo de Viagem");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));//altura e largura
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno
        gbc.anchor = GridBagConstraints.WEST;

        // Campo e rótulo para Distância percorrida (km)
        gbc.gridx = 0;//coluna
        gbc.gridy = 0;//linha
        add(new JLabel("Distância percorrida (km):"), gbc);

        gbc.gridx = 1;
        distanciaField = new JTextField(10);
        add(distanciaField, gbc);

        // Campo e rótulo para Consumo do transporte (km/l)
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Consumo do transporte (km/l):"), gbc);

        gbc.gridx = 1;
        consumoField = new JTextField(10);
        add(consumoField, gbc);

        // Campo e rótulo para Preço do combustível (R$/l)
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Preço do combustível (R$/l):"), gbc);

        gbc.gridx = 1;
        precoField = new JTextField(10);
        add(precoField, gbc);

        // Botão Apagar
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1; //componente deve ocupar horizontalmente
        gbc.anchor = GridBagConstraints.WEST; // Alinhar à esquerda
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);
        // Botão Limpar Caractere
       gbc.gridx = 2; // Coluna 2 (ou qualquer outra coluna desejada)
       gbc.gridy = 0; // Linha 0 (ou qualquer outra linha desejada)
       limparButton = new JButton("Limpar");
       limparButton.addActionListener(this);
       add(limparButton, gbc);

        // Painel para os botões (Calcular, Sair)
        JPanel botoesPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        // Botão Calcular (no centro)
        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        botoesPanel.add(calcularButton);

        // Botão Sair (à direita)
        sairButton = new JButton("Sair");
        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Fecha a aplicação
            }
        });
        botoesPanel.add(sairButton);

        // Adicionar o painel de botões à grade
        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Alinhar à direita
        add(botoesPanel, gbc);

        pack();
        setLocationRelativeTo(null); // Centraliza a janela na tela
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == apagarButton) {
            // Limpa os campos de entrada
            distanciaField.setText("");
            consumoField.setText("");
            precoField.setText("");
        } else if (e.getSource() == calcularButton) {
            try {
                int distanciaPercorrida = Integer.parseInt(distanciaField.getText());
                double consumoTransporte = Double.parseDouble(consumoField.getText());
                double precoCombustivelPorLitro = Double.parseDouble(precoField.getText());

                if (consumoTransporte == 0) {
                    JOptionPane.showMessageDialog(this, "O consumo do transporte não pode ser zero.", "Erro", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Realiza o cálculo do custo da viagem
                    double quantidadeLitrosCombustivel = distanciaPercorrida / consumoTransporte;
                    double custoTotal = quantidadeLitrosCombustivel * precoCombustivelPorLitro;

                    DecimalFormat df = new DecimalFormat("#,##0.00");
                    String custoFormatado = "R$" + df.format(custoTotal);

                    String mensagem = "Distância percorrida: " + distanciaPercorrida + " km\n"
                            + "Consumo do transporte: " + consumoTransporte + " km/l\n"
                            + "Preço do combustível: R$" + precoCombustivelPorLitro + " por litro\n"
                            + "Quantidade de litros de combustível: " + df.format(quantidadeLitrosCombustivel) + " litros\n"
                            + "Custo total da viagem: " + custoFormatado;

                    JOptionPane.showMessageDialog(this, mensagem, "Resultado da Viagem", JOptionPane.INFORMATION_MESSAGE);
                }
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
            } else if (e.getSource() limparButton) {
        // Verifica qual campo de texto está em foco e remove o último caractere
        if (distanciaField.isFocusOwner()) {
            String texto = distanciaField.getText();
            if (texto.length() > 0) {
                distanciaField.setText(texto.substring(0, texto.length() - 1));
            }
        } else if (consumoField.isFocusOwner()) {
            String texto = consumoField.getText();
            if (texto.length() > 0) {
                consumoField.setText(texto.substring(0, texto.length() - 1));
            }
        } else if (precoField.isFocusOwner()) {
            String texto = precoField.getText();
            if (texto.length() > 0) {
                precoField.setText(texto.substring(0, texto.length() - 1));
        }
    }
        }
    
   
