import javax.swing.*;
import java.awt.*;

public class ExercicioCardLayout3 extends JFrame {

    private CardLayout cardLayout;
    private JPanel cards;

    public ExercicioCardLayout3() {
        super("Exercício 3");

        // Painel Principal dentro do JFrame
        JPanel painelPrincipal = new JPanel();
        this.add(painelPrincipal);
        painelPrincipal.setLayout(new BorderLayout());

        // Criando o CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);
        painelPrincipal.add(cards, BorderLayout.CENTER);

        // Criando os três painéis de cards
        JPanel card1 = criarCard1();
        JPanel card2 = criarCard2();
        JPanel card3 = criarCard3();

        // Adicionando os cards ao painel de cards
        cards.add(card1, "Registro");
        cards.add(card2, "Login");
        cards.add(card3, "TelaP");

        // Configurações do frame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setVisible(true);
    }

    private JPanel criarCard1() {
        JPanel card = new JPanel();
        card.setLayout(new BorderLayout());

        // Componentes do card1
        card.add(new JLabel("Bem-vindo ao nosso aplicativo!"), BorderLayout.NORTH);

        JPanel painelLogin = new JPanel(new FlowLayout());
        painelLogin.add(new JLabel("Digite seu login:"));
        JButton botaoLogin = new JButton("Login");
        painelLogin.add(botaoLogin);

        JPanel painelRegistro = new JPanel(new FlowLayout());
        painelRegistro.add(new JLabel("Registre-se:"));
        JButton botaoRegistro = new JButton("Registro");
        painelRegistro.add(botaoRegistro);

        card.add(painelLogin, BorderLayout.CENTER);
        card.add(painelRegistro, BorderLayout.SOUTH);

        // Botões para avançar e voltar
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton botaoAvancar = new JButton("Avançar");
        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoTelaP = new JButton("TelaP");
        painelBotoes.add(botaoVoltar);
        painelBotoes.add(botaoAvancar);
        painelBotoes.add(botaoTelaP);
        card.add(painelBotoes, BorderLayout.SOUTH);

        // Adicionando ação aos botões
        botaoRegistro.addActionListener(e -> cardLayout.show(cards, "Registro"));
        botaoLogin.addActionListener(e -> cardLayout.show(cards, "Login"));
        botaoAvancar.addActionListener(e -> cardLayout.next(cards));
        botaoVoltar.addActionListener(e -> cardLayout.previous(cards));
        botaoTelaP.addActionListener(e -> cardLayout.show(cards, "TelaP"));

        return card;
    }

    private JPanel criarCard2() {
        JPanel card = new JPanel();
        card.setLayout(new FlowLayout());

        // Componentes do card2
        card.add(new JLabel("Email:"));
        card.add(new JTextField(30));
        card.add(new JLabel("Senha:"));
        card.add(new JTextField(30));

        JPanel painelRegistro = new JPanel(new FlowLayout());
        painelRegistro.add(new JLabel("Digite seu login:"));
        JPanel painel1 = new JPanel(new FlowLayout());
        painel1.add(new JLabel("Digite seu registro:"));
        JButton botaoRegistro = new JButton("Inicial");
        painelRegistro.add(botaoRegistro);
        card.add(painelRegistro);
        card.add(painel1);

        // Botões para avançar e voltar
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton botaoAvancar = new JButton("Avançar");
        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoTelaP = new JButton("TelaP");
        painelBotoes.add(botaoVoltar);
        painelBotoes.add(botaoAvancar);
        painelBotoes.add(botaoTelaP);
        card.add(painelBotoes);

        // Adicionando ação aos botões
        botaoRegistro.addActionListener(e -> cardLayout.show(cards, "Registro"));
        botaoAvancar.addActionListener(e -> cardLayout.next(cards));
        botaoVoltar.addActionListener(e -> cardLayout.previous(cards));
        botaoTelaP.addActionListener(e -> cardLayout.show(cards, "TelaP"));

        return card;
    }

    private JPanel criarCard3() {
        JPanel card = new JPanel();
        card.setLayout(new FlowLayout());

        // Componentes do card3
        card.add(new JLabel("Usuário:"));
        card.add(new JTextField(30));
        card.add(new JLabel("Email:"));
        card.add(new JTextField(30));
        card.add(new JLabel("Senha:"));
        card.add(new JTextField(30));

        // Botões para avançar e voltar
        JPanel painelBotoes = new JPanel(new FlowLayout());
        JButton botaoAvancar = new JButton("Avançar");
        JButton botaoVoltar = new JButton("Voltar");
        JButton botaoTelaP = new JButton("TelaP");
        painelBotoes.add(botaoVoltar);
        painelBotoes.add(botaoAvancar);
        painelBotoes.add(botaoTelaP);
        card.add(painelBotoes);

        // Adicionando ação aos botões
        botaoAvancar.addActionListener(e -> cardLayout.next(cards));
        botaoVoltar.addActionListener(e -> cardLayout.previous(cards));
        botaoTelaP.addActionListener(e -> cardLayout.show(cards, "TelaP"));

        return card;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new ExercicioCardLayout3());
    }
}
