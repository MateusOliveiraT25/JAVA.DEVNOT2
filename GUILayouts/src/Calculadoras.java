import java.awt.Dimension;

import javax.swing.JFrame;

import javax.swing.JTabbedPane;

public class Calculadoras extends JFrame {
    public Calculadoras() {
        super("Calculadoras");

        // Cria as instâncias das calculadoras
        CalculadoraBasica calculadora = new CalculadoraBasica();
        CalculadoraCustoViagem calculadoraCustoViagem = new CalculadoraCustoViagem();
        CalculadoraPesoIdeal calculadoraPesoIdeal = new CalculadoraPesoIdeal();

        // Define o tamanho da janela
        int frameWidth = 420;
        int frameHeight = 330;
        this.setBounds(700, 300, frameWidth, frameHeight);

        // Cria um JTabbedPane e adiciona as calculadoras
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Calculadora", calculadora);
        tabbedPane.addTab("Custo Viagem", calculadoraCustoViagem);
        tabbedPane.addTab("Peso Ideal", calculadoraPesoIdeal);

        // Define o tamanho preferido da Calculadora
        calculadora.setPreferredSize(new Dimension(300, 200));

        // Adiciona o JTabbedPane ao JFrame
        this.add(tabbedPane);

        this.setVisible(true);
        //this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}