import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
public class ExercicioCardLayout3 extends JFrame {

    public ExercicioCardLayout3() {
        super("Exercício 3");
        JPanel pMain = new JPanel(); // Painel Principal dentro do JFrame
        // Adiciona o painel principal ao JFrame
        this.add(pMain);
        pMain.setLayout(new BorderLayout()); // Usa o BorderLayout para o painel principal

        // Criando um botão e um painel de cards
        JButton lNext = new JButton("Login"); // Botão
        // Cria o objeto do CardLayout
        CardLayout cl = new CardLayout();
        JPanel cards = new JPanel(cl); // Painel de cards no padrão CL
        // Adiciona o botão e o cards ao painel principal
        pMain.add(lNext, BorderLayout.NORTH); // Coloca o botão na parte superior
        pMain.add(cards, BorderLayout.CENTER); // Coloca os cards no centro

        // Criar 3 painéis de cards (card1, card2, card3)
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel cardT = new JPanel();

        // Adiciona um GridLayout ao painel cardT e rótulos para usuário e senha
        cardT.setLayout(new GridLayout(2, 2)); // 2 linhas, 2 colunas

        cardT.add(new JLabel("Usuário:")); // Rótulo para usuário
        cardT.add(new JTextField()); // Campo de texto para usuário
        cardT.add(new JLabel("Senha:")); // Rótulo para senha
        cardT.add(new JTextField()); // Campo de texto para senha

        this.add(cardT, BorderLayout.CENTER); // Adiciona cardT ao centro do JFrame

        // Adiciona os card1, card2, card3 aos cards
        cards.add(card1, "card1"); // Adiciona o card e atribui um "nome"
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        // Diferenciando os cards
        card1.add(new JLabel("Card 1"));
        card2.add(new JLabel("Card 2"));
        card3.add(new JLabel("Card 3"));

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa JFrame.EXIT_ON_CLOSE
        this.setSize(400, 300); // Define o tamanho
        this.setVisible(true);

        String mensagem = "Bem-vindo!!";
        JOptionPane.showMessageDialog(this, mensagem, "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);

        // Cria o evento para o botão
        lNext.addActionListener(e -> {
            cl.next(cards); // Toda vez que clicar no botão, vai mudar o card (card1, card2, card3)
        });
    }

   
    }
}
