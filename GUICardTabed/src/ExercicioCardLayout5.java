/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.*;
public class ExercicioCardLayout5 extends JFrame {

    public ExercicioCardLayout5() {
        super("Exercício 5");
        JPanel pMain = new JPanel(); // Painel Principal dentro do JFrame
        // Adiciona o painel principal ao JFrame
        this.add(pMain);
        pMain.setLayout(new BorderLayout()); // Usa o BorderLayout para o painel principal
        int pontos = 0;

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
        JPanel card11 = new JPanel();
        
        
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
        card2.add(new JTextField(30)); // Campo de texto para usuário
        
      // Adiciona um rótulo e um campo de texto ao card3
        card3.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card3.add(new JLabel("Qual o número mínimo de jogadores em cada time numa partida de futebol?")); // Rótulo para usuário
        card3.add(new JLabel("11")); // Rótulo para usuário
        card3.add(new JLabel("7")); // Rótulo para usuário
        card3.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card4
        card4.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card4.add(new JLabel("Em qual local da Ásia o português é língua oficial?")); // Rótulo para usuário
         card4.add(new JLabel("Macau")); // Rótulo para usuário
        card4.add(new JLabel("Filipinas")); // Rótulo para usuário
        card4.add(new JTextField(30)); // Campo de texto para usuário
        
          // Adiciona um rótulo e um campo de texto ao card5
        card5.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card5.add(new JLabel("Qual a nacionalidade de Che Guevara?")); // Rótulo para usuário
        card5.add(new JLabel("Cubana")); // Rótulo para usuário
        card5.add(new JLabel("Argentina")); // Rótulo para usuário
        card5.add(new JTextField(30)); // Campo de texto para usuário

           // Adiciona um rótulo e um campo de texto ao card6
        card6.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card6.add(new JLabel("Jim Morrison era vocalista de que grupo?")); // Rótulo para usuário
        card6.add(new JLabel("The Police")); // Rótulo para usuário
        card6.add(new JLabel("The Doors")); // Rótulo para usuário
        card6.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card7
        card7.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card7.add(new JLabel("Quem é o autor do famoso discurso "Eu tenho um sonho"?")); // Rótulo para usuário
         card7.add(new JLabel("Martin Luther King")); // Rótulo para usuário
        card7.add(new JLabel("Nelson Mandela")); // Rótulo para usuário
        card7.add(new JTextField(30)); // Campo de texto para usuário
        
      // Adiciona um rótulo e um campo de texto ao card8
        card8.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card8.add(new JLabel("Que acontecimento importante para a história da humanidade teve lugar em 20 de julho de 1969?")); // Rótulo para usuário
        card8.add(new JLabel("Chegada do homem à Lua")); // Rótulo para usuário
        card8.add(new JLabel("nvio do primeiro e-mail da história")); // Rótulo para usuário
        card8.add(new JTextField(30)); // Campo de texto para usuário
      
        // Adiciona um rótulo e um campo de texto ao card9
        card9.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card9.add(new JLabel("Kryptonita é a fraqueza de qual super-herói?")); // Rótulo para usuário
        card9.add(new JLabel("Superman")); // Rótulo para usuário
         card9.add(new JLabel("Homem-Aranha")); // Rótulo para usuário
        card9.add(new JTextField(30)); // Campo de texto para usuário
        
          // Adiciona um rótulo e um campo de texto ao card10
        card10.setLayout(new FlowLayout()); // Usar FlowLayout para organizar os componentes
        card10.add(new JLabel("Em que ano foi usado um celular pela primeira vez no Brasil?")); // Rótulo para usuário
          card10.add(new JLabel("1985")); // Rótulo para usuário
         card10.add(new JLabel("1990")); // Rótulo para usuário
        card10.add(new JTextField(30)); // Campo de texto para usuário
     
       card11.setLayout(new FlowLayout());
JLabel resultadoLabel = new JLabel("Pontuação Final: " + pontos + " pontos");
card11.add(resultadoLabel);


        // Adiciona os card1, card2, card3 aos cards
        cards.add(card1, "Quiz 1"); // Adiciona o card e atribui um "nome"
        cards.add(card2, "card2");
        cards.add(card3, "card3");
        cards.add(card4, "card2");
        cards.add(card5, "card3");
        cards.add(card6, "card1"); // Adiciona o card e atribui um "nome"
        cards.add(card7, "card2");
        cards.add(card8, "card3");
        cards.add(card9, "card2");
        cards.add(card10, "card3");
         cards.add(card11, "Resultado")
        
        // Diferenciando os cards
       
        
        

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Usa JFrame.EXIT_ON_CLOSE
        this.setSize(400, 300); // Define o tamanho
        this.setVisible(true);


lNext.addActionListener(e -> {
            // Verificar a resposta correta com base no card atual
            String cardName = cl.toString();
            boolean respostaCorreta = false;

            if (cardName.equals("card1")) {
                // Verificar a resposta para o card1 (De quem é a famosa frase “Penso, logo existo”?)
                String respostaUsuario = card1.getComponents()[6].getText(); // Índice 6 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Descartes");
            } else if (cardName.equals("card2")) {
                // Verificar a resposta para o card2 (De onde é a invenção do chuveiro elétrico?)
                String respostaUsuario = card2.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Brasil");
            } else if (cardName.equals("card3")) {
                // Verificar a resposta para o card3 (Qual o número mínimo de jogadores em cada time numa partida de futebol?)
                String respostaUsuario = card3.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("11");
            } else if (cardName.equals("card4")) {
                // Verificar a resposta para o card4 (Em qual local da Ásia o português é língua oficial?)
                String respostaUsuario = card4.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Macau");
            } else if (cardName.equals("card5")) {
                // Verificar a resposta para o card5 (Qual a nacionalidade de Che Guevara?)
                String respostaUsuario = card5.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Argentina");
            } else if (cardName.equals("card6")) {
                // Verificar a resposta para o card6 (Jim Morrison era vocalista de que grupo?)
                String respostaUsuario = card6.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("The Doors");
            } else if (cardName.equals("card7")) {
                // Verificar a resposta para o card7 (Quem é o autor do famoso discurso "Eu tenho um sonho"?)
                String respostaUsuario = card7.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Martin Luther King");
            } else if (cardName.equals("card8")) {
                // Verificar a resposta para o card8 (Que acontecimento importante para a história da humanidade teve lugar em 20 de julho de 1969?)
                String respostaUsuario = card8.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Chegada do homem à Lua");
            } else if (cardName.equals("card9")) {
                // Verificar a resposta para o card9 (Kryptonita é a fraqueza de qual super-herói?)
                String respostaUsuario = card9.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("Superman");
            } else if (cardName.equals("card10")) {
                // Verificar a resposta para o card10 (Em que ano foi usado um celular pela primeira vez no Brasil?)
                String respostaUsuario = card10.getComponents()[3].getText(); // Índice 3 é o campo de texto
                respostaCorreta = respostaUsuario.equalsIgnoreCase("1990");
            }
    // Verificar se a resposta está correta
            if (respostaCorreta) {
                pontos++; // Incrementar o contador de pontos
            } else {
                JOptionPane.showMessageDialog(this, "Resposta incorreta. Tente novamente.", "Aviso", JOptionPane.ERROR_MESSAGE);
            }
          // Verificar se todas as perguntas foram respondidas
    if (cl.getLayoutComponent(card10) == null) {
        // Todas as perguntas foram respondidas, mostrar o card11
        cl.show(cards, "Resultado");
        resultadoLabel.setText("Pontuação Final: " + pontos + " pontos");
    }
});
*\






       
/*   import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ExercicioCardLayout5 extends JFrame {

    private JPanel cards;
    private CardLayout cardLayout;
    private int pontos;

    public ExercicioCardLayout5() {
        super("Exercício 5");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        JPanel pMain = new JPanel(new BorderLayout());
        add(pMain);

        JButton lNext = new JButton("Avançar");
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        pMain.add(lNext, BorderLayout.NORTH);
        pMain.add(cards, BorderLayout.CENTER);

        List<Pergunta> perguntas = criarPerguntas();
        for (Pergunta pergunta : perguntas) {
            cards.add(pergunta.getPanel(), pergunta.getNome());
        }

        lNext.addActionListener(e -> {
            Pergunta perguntaAtual = perguntas.get(cardLayout.getHgap());
            if (perguntaAtual.verificarResposta()) {
                pontos++;
            } else {
                JOptionPane.showMessageDialog(this, "Resposta incorreta. Tente novamente.",
                        "Aviso", JOptionPane.ERROR_MESSAGE);
            }

            if (cardLayout.getHgap() < perguntas.size() - 1) {
                cardLayout.next(cards);
            } else {
                cardLayout.show(cards, "Resultado");
                perguntas.get(perguntas.size() - 1).atualizarPontuacao(pontos);
            }
        });

        setVisible(true);
    }

    private List<Pergunta> criarPerguntas() {
        List<Pergunta> perguntas = new ArrayList<>();

        perguntas.add(new Pergunta("De quem é a famosa frase 'Penso, logo existo'?", "Descartes"));
        perguntas.add(new Pergunta("De onde é a invenção do chuveiro elétrico?", "Brasil"));
        perguntas.add(new Pergunta("Qual é o maior planeta do Sistema Solar?", "Júpiter"));
perguntas.add(new Pergunta("Quem escreveu 'Romeu e Julieta'?", "William Shakespeare"));
perguntas.add(new Pergunta("Qual é a capital da Austrália?", "Camberra"));
perguntas.add(new Pergunta("Quem foi o primeiro presidente do Brasil?", "Marechal Deodoro da Fonseca"));
perguntas.add(new Pergunta("Quantos elementos químicos existem na tabela periódica?", "118"));
perguntas.add(new Pergunta("Qual é o oceano mais extenso?", "Oceano Pacífico"));
perguntas.add(new Pergunta("Quem pintou a 'Mona Lisa'?", "Leonardo da Vinci"));
perguntas.add(new Pergunta("Quantos lados tem um heptágono?", "7"));

        // Adicione outras perguntas conforme necessário

        // Adicione um painel final para mostrar a pontuação
        JPanel resultadoPanel = new JPanel(new FlowLayout());
        JLabel resultadoLabel = new JLabel("Pontuação Final: " + pontos + " pontos");
        resultadoPanel.add(resultadoLabel);
        perguntas.add(new Pergunta("Resultado", resultadoPanel));

        return perguntas;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExercicioCardLayout5());
    }
}

class Pergunta {
    private JPanel panel;
    private String nome;
    private String respostaCorreta;

    public Pergunta(String nome, String respostaCorreta) {
        this.nome = nome;
        this.respostaCorreta = respostaCorreta;
        this.panel = criarPainel();
    }

    public JPanel getPanel() {
        return panel;
    }

    public String getNome() {
        return nome;
    }

    public boolean verificarResposta() {
        if (respostaCorreta == null) {
            return true; // Painel de resultado, não há resposta a verificar
        }
        String respostaUsuario = ((JTextField) panel.getComponents()[3]).getText();
        return respostaUsuario.equalsIgnoreCase(respostaCorreta);
    }

    public void atualizarPontuacao(int pontos) {
        JLabel resultadoLabel = (JLabel) panel.getComponents()[0];
        resultadoLabel.setText("Pontuação Final: " + pontos + " pontos");
    }

    private JPanel criarPainel() {
        JPanel cardPanel = new JPanel(new FlowLayout());
        cardPanel.add(new JLabel(nome));

        if (respostaCorreta != null) {
            cardPanel.add(new JTextField(30));
            cardPanel.add(new JLabel(respostaCorreta));
        } else {
            cardPanel.add(new FlowLayout()); // Painel vazio para o resultado
        }

        return cardPanel;
    }
}
*\
