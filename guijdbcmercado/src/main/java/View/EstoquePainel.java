package View;

import Controller.EstoqueControll;
import Model.Produto;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.List;

public class EstoquePainel extends JPanel {
    private EstoqueControll gerenciadorEstoque;

    public EstoquePainel(EstoqueControll gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;

        JButton listarProdutosButton = new JButton("Listar Produtos");
        listarProdutosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                listarProdutos();
            }
        });

        JButton adicionarProdutoButton = new JButton("Adicionar Produto");
        adicionarProdutoButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        add(listarProdutosButton);
        add(adicionarProdutoButton);
    }

    public void setGerenciadorEstoque(EstoqueControll gerenciadorEstoque) {
        this.gerenciadorEstoque = gerenciadorEstoque;
    }

    private void listarProdutos() {
        List<Produto> produtos = gerenciadorEstoque.listarProdutosDoBanco();
        StringBuilder mensagem = new StringBuilder("Produtos em Estoque:\n");

        for (Produto produto : produtos) {
            mensagem.append(produto.getNome()).append(" - Quantidade: ").append(produto.getQuantidade()).append("\n");
        }

        JOptionPane.showMessageDialog(this, mensagem.toString(), "Produtos em Estoque", JOptionPane.INFORMATION_MESSAGE);
    }

    private void adicionarProduto() {
        // Solicitação de informações ao usuário
        String codigoBarra = JOptionPane.showInputDialog(this, "Digite o código de barras do produto:");
        String nome = JOptionPane.showInputDialog(this, "Digite o nome do produto:");
        String quantidadeStr = JOptionPane.showInputDialog(this, "Digite a quantidade do produto:");
        String precoStr = JOptionPane.showInputDialog(this, "Digite o preço do produto:");

        // Verificação de valores não nulos ou vazios
        if (codigoBarra != null && nome != null && !quantidadeStr.isEmpty() && !precoStr.isEmpty()) {
            try {
                // Conversão para números
                int quantidade = Integer.parseInt(quantidadeStr);
                double preco = Double.parseDouble(precoStr);

                // Chamada do método do controlador para adicionar o produto
                gerenciadorEstoque.adicionarProduto(codigoBarra, nome, quantidade, preco);

                // Exibição de mensagem de sucesso em uma caixa de diálogo
                JOptionPane.showMessageDialog(this, "Produto adicionado com sucesso!", "Sucesso",
                        JOptionPane.INFORMATION_MESSAGE);
            } catch (NumberFormatException e) {
                // Tratamento de erro se a conversão falhar
                JOptionPane.showMessageDialog(this, "Erro ao converter valores para números.", "Erro",
                        JOptionPane.ERROR_MESSAGE);
            }
        } else {
            // Usuário cancelou a entrada ou forneceu valores nulos/vazios
            JOptionPane.showMessageDialog(this, "Entrada cancelada ou valores inválidos.", "Aviso",
                    JOptionPane.WARNING_MESSAGE);
        }
    }
}
