import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculadoraPesoIdeal extends JPanel implements ActionListener {
    private JTextField entradaField;
    private JComboBox<String> sexoComboBox;
    private JButton calcularButton, apagarButton, alternarButton;

    private boolean entradaNumerica = true;
    private JPanel botoesNumericosPanel;
    private JPanel botoesLetrasPanel;

    public CalculadoraPesoIdeal() {
        super();
        setPreferredSize(new Dimension(400, 200));
        setLayout(new GridBagLayout());
        setBackground(Color.LIGHT_GRAY);
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Inserir Altura (metros) ou Nome:"), gbc);

        gbc.gridx = 1;
        entradaField = new JTextField(10);
        add(entradaField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("Escolher Sexo:"), gbc);

        gbc.gridx = 1;
        String[] sexoOptions = {"Masculino", "Feminino"};
        sexoComboBox = new JComboBox<>(sexoOptions);
        add(sexoComboBox, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        criarBotoesNumericos();
        criarBotoesLetras();
        adicionarBotaoAlternar();
        add(botoesNumericosPanel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        apagarButton = new JButton("Apagar");
        apagarButton.addActionListener(this);
        add(apagarButton, gbc);

        gbc.gridx = 1;
        gbc.anchor = GridBagConstraints.EAST;
        calcularButton = new JButton("Calcular");
        calcularButton.addActionListener(this);
        add(calcularButton, gbc);
    }

    private void criarBotoesNumericos() {
        botoesNumericosPanel = new JPanel(new GridLayout(4, 7, 5, 5));

        for (int i = 1; i <= 9; i++) {
            JButton botao = new JButton(String.valueOf(i));
            botao.addActionListener(this);
            botoesNumericosPanel.add(botao);
        }

        botoesNumericosPanel.add(new JButton("!"));
        botoesNumericosPanel.add(new JButton("@"));
        botoesNumericosPanel.add(new JButton("#"));
        botoesNumericosPanel.add(new JButton("$"));
        botoesNumericosPanel.add(new JButton("%"));
        botoesNumericosPanel.add(new JButton("¨"));
        botoesNumericosPanel.add(new JButton("/"));
        botoesNumericosPanel.add(new JButton(","));
        botoesNumericosPanel.add(new JButton("´"));
        botoesNumericosPanel.add(new JButton("`"));
        botoesNumericosPanel.add(new JButton("\""));
        botoesNumericosPanel.add(new JButton("'"));
        botoesNumericosPanel.add(new JButton("º"));
        botoesNumericosPanel.add(new JButton("ª"));
        botoesNumericosPanel.add(new JButton("\\"));

        botoesNumericosPanel.add(new JButton("0"));
        botoesNumericosPanel.add(new JButton("."));
    }

    private void criarBotoesLetras() {
        botoesLetrasPanel = new JPanel(new GridLayout(3, 4, 5, 5));

        for (char letra = 'A'; letra <= 'Z'; letra++) {
            JButton botao = new JButton(String.valueOf(letra));
            botao.addActionListener(this);
            botoesLetrasPanel.add(botao);
        }
    }

    private void adicionarBotaoAlternar() {
        alternarButton = new JButton("Alternar para Letras");
        alternarButton.addActionListener(this);
        botoesNumericosPanel.add(alternarButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Implementação do actionPerformed (não incluído no código completo para economizar espaço)
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora de Peso Ideal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new CalculadoraPesoIdeal());
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

