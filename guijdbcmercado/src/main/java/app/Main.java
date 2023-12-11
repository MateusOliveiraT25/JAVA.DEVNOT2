package app;

import Controller.EstoqueControll;
import View.EstoquePainel;
import View.JanelaPrincipal;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // Cria uma instância de JanelaPrincipal
            JanelaPrincipal janelaPrincipal = new JanelaPrincipal();

            // Obtém a referência para o EstoqueControll da JanelaPrincipal
            EstoqueControll gerenciadorEstoque = janelaPrincipal.getGerenciadorEstoque();

            // Inicializa o EstoqueControll se necessário
            if (gerenciadorEstoque == null) {
                gerenciadorEstoque = new EstoqueControll();
                janelaPrincipal.setGerenciadorEstoque(gerenciadorEstoque); // Atualiza a referência na JanelaPrincipal
            }

            // Cria uma instância de EstoquePainel e adiciona à guia "Estoque" na JanelaPrincipal
            EstoquePainel janelaEstoque = new EstoquePainel(gerenciadorEstoque);
            janelaPrincipal.adicionarTabEstoque(janelaEstoque);

            // Executa o método run da JanelaPrincipal
            janelaPrincipal.run();

         
        });
    }
}