import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExercicioCardLayout5 extends JFrame {

    private CardLayout cl;
    private JPanel cards;
    private int pontos = 0; //rastrear a pontuação
    private int indiceAtual = 0; //rastrear em qual "quiz" está atualmente

    //combo seja um membro da classe ExercicioCardLayout5
    private JComboBox<String> combo1;// qualquer método pode acessar dentro da classe 
    private JComboBox<String> combo2;
    private JComboBox<String> combo3;
    private JComboBox<String> combo4;
    private JComboBox<String> combo5;

    public ExercicioCardLayout5() {
        super("Exercício 5");

        JPanel pMain = new JPanel();
        this.add(pMain);
        pMain.setLayout(new BorderLayout());

        JButton lNext = new JButton("Avançar");
        lNext.setBackground(Color.cyan);  // Defina a cor de fundo do botão
        cl = new CardLayout();
        cards = new JPanel(cl);
        pMain.add(lNext, BorderLayout.NORTH);
        pMain.add(cards, BorderLayout.CENTER);

        JPanel card1 = new JPanel();
        JPanel card2 = new JPanel();
        JPanel card3 = new JPanel();
        JPanel card4 = new JPanel();
        JPanel card5 = new JPanel();
        JPanel card6 = new JPanel();

        // Defina a cor de fundo dos cards
        card1.setBackground(Color.WHITE);
        card2.setBackground(Color.WHITE);
        card3.setBackground(Color.WHITE);
        card4.setBackground(Color.WHITE);
        card5.setBackground(Color.WHITE);
        card6.setBackground(Color.WHITE);
        
        cards.add(card1, "Quiz 1");
        cards.add(card2, "Quiz 2");
        cards.add(card3, "Quiz 3");
        cards.add(card4, "Quiz 4");
        cards.add(card5, "Quiz 5");
        cards.add(card6, "Resultado");


        String[] options1 = {"","Nietzsche", "Sartre", "Descartes"};
        combo1 = new JComboBox<>(options1);
        card1.setLayout(new FlowLayout());
        card1.add(new JLabel("De quem é a famosa frase 'Penso, logo existo'?"));
        card1.add(combo1);

        String[] options2 = {"","Estados Unidos", "Inglaterra", "Brasil"};
        combo2 = new JComboBox<>(options2);
        card2.setLayout(new FlowLayout());
        card2.add(new JLabel("De onde é a invenção do chuveiro elétrico?"));
        card2.add(combo2);

        String[] options3 = {"","7", "11", "10"};
        combo3 = new JComboBox<>(options3);
        card3.setLayout(new FlowLayout());
        card3.add(new JLabel("O n° mínimo de jogadores para jogar futebol"));
        card3.add(combo3);

        String[] options4 = {"","Macau", "Toquio", "Moçambique"};
        combo4 = new JComboBox<>(options4);
        card4.setLayout(new FlowLayout());
        card4.add(new JLabel("Em qual local da Ásia o português é língua oficial?"));
        card4.add(combo4);

        String[] options5 = {"","Cubana", "Argentina", "Chilena"};
        combo5 = new JComboBox<>(options5);
        card5.setLayout(new FlowLayout());
        card5.add(new JLabel("Qual a nacionalidade de Che Guevara?"));
        card5.add(combo5);

      

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(300, 150);
        this.setVisible(true);

        lNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean respostaCorreta = false;

                switch (indiceAtual) {
                    case 0:
                        respostaCorreta = "Descartes".equals(combo1.getSelectedItem());
                        break;
                    case 1:
                        respostaCorreta = "Brasil".equals(combo2.getSelectedItem());
                        break;
                    case 2:
                        respostaCorreta = "7".equals(combo3.getSelectedItem());
                        break;
                    case 3:
                        respostaCorreta = "Macau".equals(combo4.getSelectedItem());
                        break;
                    case 4:
                        respostaCorreta = "Argentina".equals(combo5.getSelectedItem());
                        break;
                }

                if (respostaCorreta) {
                    pontos++;
                }

                cl.next(cards);

                indiceAtual++;

                if (indiceAtual == cards.getComponentCount() - 1) {
                    cl.show(cards, "Resultado");
                    JOptionPane.showMessageDialog(ExercicioCardLayout5.this,
                            "Pontuação Final: " + pontos + " pontos",
                            "Resultado",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
    }
}
