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
     //   JButton lNext = new JButton("Avançar"); // Botão
        // Cria o objeto do CardLayout
        CardLayout cl = new CardLayout();
        JPanel cards = new JPanel(cl); // Painel de cards no padrão CL
        // Adiciona o botão e o cards ao painel principal
     //   pMain.add(lNext, BorderLayout.NORTH); // Coloca o botão na parte superior
        pMain.add(cards, BorderLayout.CENTER); // Coloca os cards no centro

        // Criar 3 painéis de cards (card1, card2, card3)

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();

        // Conteúdo do card1
        card1.setLayout(new BorderLayout()); // Usar BorderLayout para organizar os componentes
        card1.add(new JLabel("Bem-vindo ao nosso aplicativo!"), BorderLayout.NORTH); // Mensagem de boas-vindas
        JPanel loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());
         loginPanel.add(new JLabel("Entre em Login:"));
        JPanel registroPanel = new JPanel();
        registroPanel.setLayout(new FlowLayout());
        registroPanel.add(new JLabel("Entre em Login:"));
        JButton loginButton = new JButton("Login");
         loginPanel.add(loginButton);
        card1.add( loginPanel, BorderLayout.CENTER); // Adicione informações de contato
        JButton registroButton = new JButton("Registro");
         registroPanel.add( registroButton);
        card1.add( registroPanel, BorderLayout.CENTER); // Adicione informações de contato
        String mensagem = "Registre-se";
        JOptionPane.showMessageDialog(this, mensagem, "Bem-vindo!", JOptionPane.INFORMATION_MESSAGE);

        // Adiciona um rótulo e um campo de texto ao card2
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Email:")); // Rótulo para usuário
        card2.add(new JTextField(30)); // Campo de texto para usuário
        card2.add(new JLabel("Senha:")); // Rótulo para senha
        card2.add(new JTextField(30)); // Campo de texto para senha
          JPanel registroPanel1 = new JPanel();
        registroPanel1.setLayout(new FlowLayout());
        registroPanel1.add(new JLabel("Entre em Login:"));
        card2.add( registroPanel1, BorderLayout.CENTER);
          JPanel iPanel1 = new JPanel();
        iPanel1.setLayout(new FlowLayout());
        iPanel1.add(new JLabel("Entre em registro:"));
        card2.add( iPanel1, BorderLayout.CENTER);
         JButton registroButton1 = new JButton("Inicial");
           registroPanel1.add( registroButton1);


         

        // Adiciona um rótulo e um campo de texto ao card3
        card1.setLayout(new FlowLayout()); // Alinha os componentes à direita

        card3.add(new JLabel("Usuario:")); // Rótulo para usuário
        card3.add(new JTextField(30));// Campo de texto para usuário
        card3.add(new JLabel("Email:")); // Rótulo para email
        card3.add(new JTextField(30)); // Campo de texto para email
        card3.add(new JLabel("Senha:")); // Rótulo para senha
        card3.add(new JTextField(30)); // Campo de texto para senha

        // Adiciona os card1, card2, card3 aos cards
        cards.add(card1, "Registro"); // Adiciona o card e atribui um "nome"
        cards.add(card2, "Login");
        cards.add(card3, "TelaP");
        // Diferenciando os cards

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa JFrame.EXIT_ON_CLOSE
        this.setSize(400, 300); // Define o tamanho
        this.setVisible(true);

       

        // Cria o evento para o botão
       registroButton.addActionListener(e -> {
            cl.next(cards); // Toda vez que clicar no botão, vai mudar o card (card1, card2, card3)
        });
        // Crie o evento para o botão "Contato"
        loginButton.addActionListener(e -> {
            // Adicione aqui a ação que você deseja executar quando o botão "Contato" for
            // clicado.
            // Pode ser uma abertura de um formulário de contato ou algo semelhante.
            // JOptionPane.showMessageDialog(this, "Formulário de contato será aberto
            // aqui.", "Contato", JOptionPane.INFORMATION_MESSAGE);
            cl.previous(cards);

        });
          registroButton1.addActionListener(e -> {
            cl.previous(cards); // Toda vez que clicar no botão, vai mudar o card (card1, card2, card3)
        });
    }
}


