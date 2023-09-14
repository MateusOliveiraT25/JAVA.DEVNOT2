import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraCustoViagem extends JPanel implements ActionListener {
    private JTextField distanciaField, consumoField, precoField;
    private JButton calcularButton, apagarButton, sairButton;

    public CalculadoraCustoViagem() {
        super();
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setPreferredSize(new Dimension(400, 200));//altura e largura
        setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();  // Cria um novo objeto GridBagConstraints para configurar o layout.
        gbc.insets = new Insets(5, 5, 5, 5); // Espaçamento interno margem
        gbc.anchor = GridBagConstraints.WEST; // Alinhar à esquerda

        // Campo e rótulo para Distância percorrida (km)
        gbc.gridx = 0;//coluna 0
        gbc.gridy = 0;//linha 0
        add(new JLabel("Distância percorrida (km):"), gbc);

        gbc.gridx = 1; // coluna 1
        distanciaField = new JTextField(10);
        add(distanciaField, gbc);

        // Campo e rótulo para Consumo do transporte (km/l)
        gbc.gridx = 0; //coluna 0
        gbc.gridy = 1; //linha 1
        add(new JLabel("Consumo do transporte (km/l):"), gbc);

        gbc.gridx = 1; //coluna 1
        consumoField = new JTextField(10);
        add(consumoField, gbc);

        // Campo e rótulo para Preço do combustível (R$/l)
        gbc.gridx = 0; //coluna 0
        gbc.gridy = 2; //linha 2
        add(new JLabel("Preço do combustível (R$/l):"), gbc);

        gbc.gridx = 1; //coluna 1
        precoField = new JTextField(10);
        add(precoField, gbc);

        // Botão Apagar
        gbc.gridx = 0;//coluna 0
        gbc.gridy = 3;//linha 3
        gbc.gridwidth = 1; //componente deve ocupar horizontalmente
        gbc.anchor = GridBagConstraints.WEST; // Alinhar à esquerda
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);
        
// Botão Calcular
gbc.gridx = 1; // Coluna 1
gbc.gridy = 3; // Linha 3
gbc.gridwidth = 1; // Ocupa uma célula horizontal
gbc.anchor = GridBagConstraints.CENTER; // Alinhar ao centro
calcularButton = new JButton("Calcular");
calcularButton.addActionListener(this); //responde a eventos de clique
add(calcularButton, gbc);

// Espaço em branco para alinhar à direita
gbc.gridx = 2; // Coluna 2
gbc.anchor = GridBagConstraints.EAST; // Alinhar à direita
add(Box.createHorizontalStrut(10), gbc); // Adiciona um espaço em branco

// Botão Sair
gbc.gridx = 3; // Coluna 3
sairButton = new JButton("Sair");
sairButton.addActionListener(new ActionListener() {
    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0); // Fecha a aplicação
    }
});
add(sairButton, gbc);

        // Adicionar o painel de botões à grade
        gbc.gridx = 1; //coluna 1
        gbc.gridy = 3; // linha 3
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.EAST; // Alinhar à direita
        add(botoesPanel, gbc);

       // pack();
      //  setLocationRelativeTo(null); // Centraliza a janela na tela
        //setVisible(true);
    }
  // Implementação do método actionPerformed para lidar com eventos de botões.
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
            }
        }
    }   
    }
