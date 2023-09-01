import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

public class CalculadoraCustoViagem extends JFrame implements ActionListener {
    private JTextField distanciaField, consumoField, precoField;
    private JButton calcularButton, apagarButton;

    public CalculadoraCustoViagem() {
        super("Calculadora de Custo de Viagem");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 300, 400, 250); // Modifique os valores de largura (400) e altura (250) aqui
        setLayout(new GridLayout(4, 2));
        

        add(new JLabel("Distância percorrida (km):"));
        distanciaField = new JTextField();
        add(distanciaField);

        add(new JLabel("Consumo do transporte (km/l):"));
        consumoField = new JTextField();
        add(consumoField);

        add(new JLabel("Preço do combustível (R$/l):"));
        precoField = new JTextField();
        add(precoField);
       

        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton);
           calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        add(calcularButton);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == apagarButton) {
            distanciaField.setText("");
            consumoField.setText("");
            precoField.setText("");
        } else if (e.getSource() == calcularButton) 
            try {  int distanciaPercorrida = Integer.parseInt(distanciaField.getText());
            double consumoTransporte = Double.parseDouble(consumoField.getText());
            double precoCombustivelPorLitro = Double.parseDouble(precoField.getText());

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
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(this, "Por favor, insira valores válidos!", "Erro", JOptionPane.ERROR_MESSAGE);
                }

}
}