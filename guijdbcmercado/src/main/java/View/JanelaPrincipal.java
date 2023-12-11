package View;

import Controller.EstoqueControll;

import javax.swing.*;
import java.awt.*;

public class JanelaPrincipal extends JFrame {
    private CardLayout cardLayout;
    private JPanel cards;
    private EstoqueControll gerenciadorEstoque;
    private JTabbedPane jTPane;

    public JanelaPrincipal() {
        super("Janela Principal");
            setSize(800, 600);
        setLocationRelativeTo(null);

        // Inicializa o CardLayout
        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        // Inicializa o EstoqueControll
        gerenciadorEstoque = new EstoqueControll();

        // Cria instâncias das duas outras janelas
        ConclusaoCompraPainel conclusaoCompraPainel = new ConclusaoCompraPainel();
        VendasPainel vendasPainel = new VendasPainel(gerenciadorEstoque);

        // Adiciona as duas janelas ao CardLayout
        cards.add(conclusaoCompraPainel, "ConclusaoCompra");
        cards.add(vendasPainel, "Vendas");

        // Adiciona o CardLayout à janela principal
        add(cards);

        // Inicializa o JTabbedPane
        jTPane = new JTabbedPane();
        add(jTPane);

        // Cria instâncias das outras janelas
        ClientesPainel tab1 = new ClientesPainel();
        EstoquePainel tab4 = new EstoquePainel(gerenciadorEstoque);

        // Adiciona as janelas ao JTabbedPane
        jTPane.add("Tela de Clientes", tab1);
        jTPane.add("Tela de Registro de venda", vendasPainel);
        jTPane.add("Tela de Conclusão de Compras", conclusaoCompraPainel);
        jTPane.add("Tela de Estoque", tab4);

        // Define a janela principal para ser visível
        setVisible(true);
    }

    // Método para obter o EstoqueControll
    public EstoqueControll getGerenciadorEstoque() {
        return gerenciadorEstoque;
    }

    // Método para iniciar a execução da janela
    public void run() {
        // Implemente aqui qualquer lógica de inicialização necessária
    }

    // Método para adicionar a guia de estoque à janela principal
    public void adicionarTabEstoque(EstoquePainel janelaEstoque) {
        cards.add(janelaEstoque, "Estoque");
    }

    // Método para abrir a janela de estoque separadamente
    public void abrirJanelaEstoque() {
        EstoquePainel estoqueJanela = new EstoquePainel(gerenciadorEstoque);

        JFrame estoqueFrame = new JFrame("Estoque");
        estoqueFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        estoqueFrame.setSize(400, 300);
        estoqueFrame.setLocationRelativeTo(null);
        estoqueFrame.add(estoqueJanela);
        estoqueFrame.setVisible(true);
    }

    // Método para definir o EstoqueControll
    public void setGerenciadorEstoque(EstoqueControll gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;
    }
}
