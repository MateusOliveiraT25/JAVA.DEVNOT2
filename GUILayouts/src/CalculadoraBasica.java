import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CalculadoraBasica extends JPanel implements ActionListener {
    private JTextField visor;

    // Construtor da classe CalculadoraBasica
    public CalculadoraBasica() {
        super(new BorderLayout());

        // Criando o visor com tamanho maior e fonte maior
        visor = new JTextField(10);
        visor.setFont(visor.getFont().deriveFont(40f)); // Ajustando o tamanho da fonte
        setBackground(Color.LIGHT_GRAY);

        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel();
        JPanel painelC = new JPanel();

        this.add(painelV, BorderLayout.NORTH);
        this.add(painelB, BorderLayout.CENTER);
        this.add(painelC, BorderLayout.EAST);

        // Adicionando o visor ao painelV.
        painelV.add(visor);

        // Setando o layout do JPanel
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        String textBotoes[] = { "9", "8", "7", "6", "5", "4", "1", "2", "3", "AC", "0", "=" };

        for (int a = 0; a < textBotoes.length; a++) {
            JButton botao = new JButton(textBotoes[a]);
            botao.addActionListener(this); // Adicionando o ActionListener a todos os botões
            painelB.add(botao);
        }

        painelC.setLayout(new GridLayout(4, 1));
        painelC.add(new JButton("+"));
        painelC.add(new JButton("-"));
        painelC.add(new JButton("/"));
        painelC.add(new JButton("x"));
    }

    // Método chamado quando um botão é pressionado
    @Override
    public void actionPerformed(ActionEvent e) {
        String textoBotao = ((JButton) e.getSource()).getText();

        // Adicionando ações para os botões
        switch (textoBotao) {
            case "AC":
                visor.setText(""); // Limpa o visor
                break;
            case "=":
                calcularResultado(); // Chama o método para calcular o resultado
                break;
            default:
                visor.setText(visor.getText() + textoBotao); // Adiciona o texto do botão ao visor
                break;
        }
    }

    // Método para calcular o resultado da expressão
    private void calcularResultado() {
        //String expressao = visor.getText();
        // Implementar a lógica para calcular a expressão
        // O resultado deve ser exibido no visor
        // Exemplo: visor.setText(resultado);
    }
}
