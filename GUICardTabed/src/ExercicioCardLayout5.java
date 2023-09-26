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
        JButton lNext = new JButton("Avançar"); // Botão
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
        
        // Adiciona um rótulo e um campo de texto ao card1
        card1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card1.add(new JLabel("Nome de Usuário:")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
        card1.add(new JLabel("Email:")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
        card1.add(new JLabel("Senha:")); // Rótulo para senha
        card1.add(new JTextField(15)); // Campo de texto para senha
        
        // Adiciona um rótulo e um campo de texto ao card2
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Email:")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
        card2.add(new JLabel("Senha:")); // Rótulo para senha
        card2.add(new JTextField(15)); // Campo de texto para senha

        // Adicione cardT como um painel interno em card2
        card2.add(cardT);

        // Adiciona os card1, card2, card3 aos cards
        cards.add(card1, "card1"); // Adiciona o card e atribui um "nome"
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        // Diferenciando os cards
        card2.add(new JLabel("Card 2"));
        
        // Conteúdo do card3
        card3.setLayout(new BorderLayout()); // Usar BorderLayout para organizar os componentes
        card3.add(new JLabel("Bem-vindo ao nosso aplicativo!"), BorderLayout.NORTH); // Mensagem de boas-vindas
        JPanel contatoPanel = new JPanel();
        contatoPanel.setLayout(new FlowLayout());
        contatoPanel.add(new JLabel("Entre em contato conosco:"));
        JButton contatoButton = new JButton("Contato");
        contatoPanel.add(contatoButton);
        card3.add(contatoPanel, BorderLayout.CENTER); // Adicione informações de contato

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa JFrame.EXIT_ON_CLOSE
        this.setSize(400, 300); // Define o tamanho
        this.setVisible(true);

        String mensagem = "Bem-vindo!!";
        JOptionPane.showMessageDialog(this, mensagem, "Boas-vindas", JOptionPane.INFORMATION_MESSAGE);

        // Cria o evento para o botão "Avançar"
        lNext.addActionListener(e -> {
            cl.next(cards); // Toda vez que clicar no botão, vai mudar o card (card1, card2, card3)
        });

        // Crie o evento para o botão "Contato"
        contatoButton.addActionListener(e -> {
            // Adicione aqui a ação que você deseja executar quando o botão "Contato" for clicado.
            // Pode ser uma abertura de um formulário de contato ou algo semelhante.
            JOptionPane.showMessageDialog(this, "Formulário de contato será aberto aqui.", "Contato", JOptionPane.INFORMATION_MESSAGE);
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioCardLayout3();
        });
    }
}
