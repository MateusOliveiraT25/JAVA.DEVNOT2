
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FlowLayoutExemplo extends JFrame{
    public JFrame frame;
    public JLabel pesoLabel;
    public JLabel alturaLabel;
    public JTextField pesoTextField;
    public JTextField alturaTextField;
    public JButton calcularButton;
    public JLabel resultadoLabel;
    
    public FlowLayoutExemplo(){
        super();

        frame = new JFrame("Calculadora de IMC");
        frame.setLayout(new GridLayout(4, 2));

        pesoLabel = new JLabel("Peso (kg):");
        alturaLabel = new JLabel("Altura (m):");
        pesoTextField = new JTextField(10);
        alturaTextField = new JTextField(10);
        calcularButton = new JButton("Calcular IMC");
        resultadoLabel = new JLabel("");

        calcularButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calcularIMC();
            }
        });

        frame.add(pesoLabel);
        frame.add(pesoTextField);
        frame.add(alturaLabel);
        frame.add(alturaTextField);
        frame.add(calcularButton);
        frame.add(resultadoLabel);
    }

    public void calcularIMC() {
        try {
            double peso = Double.parseDouble(pesoTextField.getText());
            double altura = Double.parseDouble(alturaTextField.getText());
            double imc = peso / (altura * altura);

            resultadoLabel.setText("Seu peso ideal é: " + String.format("%.2f", imc));
        } catch (NumberFormatException e) {
            resultadoLabel.setText("Por favor, insira valores válidos.");
        }
    }
    
    }

    

