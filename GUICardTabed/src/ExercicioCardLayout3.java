import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
public class ExercicioCardLayout3 extends JFrame {

    public ExercicioCardLayout3() {
        super("Exercicio 3");
        JPanel pMain = new JPanel();//Painel Principal dentro do JFrame
        //add painel principal ao jFrame
        this.add(pMain);
        //criando um botão e um painel de cards
        JButton lNext = new JButton("Login");//botão
        //criar o objeto do cardLayout
        CardLayout cl = new CardLayout();
        JPanel cards = new JPanel(cl);//painel de cards no padrão CL
        //add o botão e o cards ao painel principal
        pMain.add(lNext);
        pMain.add(cards);
        //criar 3 paineis de cards (card1, card2, card3)
        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel cardT = new JPanel();
       this.add(cardT, BorderLayout.CENTER);
        //add os card1, car2, card3 ao cards
        cards.add(card1,"card1");//add o card e atribuindo um "nome"
        cards.add(card2,"card2");
        cards.add(card3,"card3");
        //diferenciando os cards
        card1.add(new JLabel("Card 1"));
        card2.add(new JLabel("Card 2"));
        card3.add(new JLabel("Card 3"));
      
        cardT.add(new JTextField("Usuario"));
        cardT.add(new JTextField("Senha"));
        card1.add(cardT);

        //set do frame
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 300);
        this.setVisible(true);

         String mensagem = "Bem Vindo!!";
          JOptionPane.showMessageDialog(this, mensagem, "Boas vindas", JOptionPane.INFORMATION_MESSAGE);
        //criar o evento para o botão
        lNext.addActionListener(e->{
            cl.next(cards);//toda vez que clicar no botão , vai mudar o card (card1, card2, card3)
        });
    }
}