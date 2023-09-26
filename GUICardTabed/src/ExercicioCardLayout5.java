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

        // Criar 10 painéis de cards (card1, card2, card3)
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
         JPanel card4 = new JPanel();
        JPanel card5 = new JPanel();
        JPanel card6 = new JPanel();
         JPanel card7 = new JPanel();
        JPanel card8 = new JPanel();
        JPanel card9 = new JPanel();
        JPanel card10 = new JPanel();
        
        
        
        // Adiciona um rótulo e um campo de texto ao card1
        card1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card1.add(new JLabel("De quem é a famosa frase “Penso, logo existo”?")); // Rótulo para usuário
        card2.add(new JLabel("Descartes")); // Rótulo para usuário
        card2.add(new JLabel("Sócrates")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card2
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("De onde é a invenção do chuveiro elétrico?:")); // Rótulo para usuário
         card2.add(new JLabel("EUA")); // Rótulo para usuário
        card2.add(new JLabel("Brasil")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
        
      // Adiciona um rótulo e um campo de texto ao card3
        card1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card1.add(new JLabel("Qual o número mínimo de jogadores em cada time numa partida de futebol?")); // Rótulo para usuário
        card2.add(new JLabel("11")); // Rótulo para usuário
        card2.add(new JLabel("12")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card4
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Em qual local da Ásia o português é língua oficial?")); // Rótulo para usuário
         card2.add(new JLabel("Macau")); // Rótulo para usuário
        card2.add(new JLabel("Filipinas")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
        
          // Adiciona um rótulo e um campo de texto ao card5
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Qual a nacionalidade de Che Guevara?")); // Rótulo para usuário
        card2.add(new JLabel("Cubana")); // Rótulo para usuário
        card2.add(new JLabel("Argentina")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário

           // Adiciona um rótulo e um campo de texto ao card6
        card1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card1.add(new JLabel("Jim Morrison era vocalista de que grupo?")); // Rótulo para usuário
        card2.add(new JLabel("The Police")); // Rótulo para usuário
        card2.add(new JLabel("The Doors")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card7
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Quem é o autor do famoso discurso "Eu tenho um sonho"?")); // Rótulo para usuário
         card2.add(new JLabel("Martin Luther King")); // Rótulo para usuário
        card2.add(new JLabel("Nelson Mandela")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
        
      // Adiciona um rótulo e um campo de texto ao card8
        card1.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card1.add(new JLabel("Que acontecimento importante para a história da humanidade teve lugar em 20 de julho de 1969?")); // Rótulo para usuário
        card2.add(new JLabel("Chegada do homem à Lua")); // Rótulo para usuário
        card2.add(new JLabel("nvio do primeiro e-mail da história")); // Rótulo para usuário
        card1.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card9
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Kryptonita é a fraqueza de qual super-herói?")); // Rótulo para usuário
        card2.add(new JLabel("Superman")); // Rótulo para usuário
         card2.add(new JLabel("Homem-Aranha")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
        
          // Adiciona um rótulo e um campo de texto ao card10
        card2.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card2.add(new JLabel("Em que ano foi usado um celular pela primeira vez no Brasil?")); // Rótulo para usuário
          card2.add(new JLabel("1985")); // Rótulo para usuário
         card2.add(new JLabel("1990")); // Rótulo para usuário
        card2.add(new JTextField(15)); // Campo de texto para usuário
     
       

        // Adiciona os card1, card2, card3 aos cards
        cards.add(card1, "card1"); // Adiciona o card e atribui um "nome"
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        cards.add(card4, "card2");
        cards.add(card5, "card3");
        cards.add(card6, "card1"); // Adiciona o card e atribui um "nome"
        cards.add(card7, "card2");
        cards.add(card8, "card3");
        cards.add(card9, "card2");
        cards.add(card10, "card3");
        
        // Diferenciando os cards
       
        
        

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa JFrame.EXIT_ON_CLOSE
        this.setSize(400, 300); // Define o tamanho
        this.setVisible(true);


        // Cria o evento para o botão "Avançar"
        lNext.addActionListener(e -> {
            cl.next(cards); // Toda vez que clicar no botão, vai mudar o card (card1, card2, card3)
        });

       
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExercicioCardLayout3();
        });
    }
}
