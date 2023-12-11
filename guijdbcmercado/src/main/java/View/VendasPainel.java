package View;

import Controller.EstoqueControll;
import Model.Produto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VendasPainel extends JPanel {

    private JTextField codigoBarrasField;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;
    private JCheckBox clienteVipCheckBox;
    private JButton adicionarProdutoButton, removerProdutoButton;
    private EstoqueControll estoqueControll; // Adiciona um campo para o EstoqueControll

    public VendasPainel(EstoqueControll estoqueControll) {
        this.estoqueControll = estoqueControll; // Inicializa o EstoqueControll
        setLayout(new BorderLayout());

        codigoBarrasField = new JTextField();
        adicionarProdutoButton = new JButton("Adicionar Produto");

        produtosListModel = new DefaultListModel<>();
        produtosList = new JList<>(produtosListModel);
        JScrollPane produtosScrollPane = new JScrollPane(produtosList);

        removerProdutoButton = new JButton("Remover Produto");
        clienteVipCheckBox = new JCheckBox("Cliente VIP");

        JPanel codigoBarrasPanel = new JPanel(new BorderLayout());
        codigoBarrasPanel.add(new JLabel("Código de Barras: "), BorderLayout.WEST);
        codigoBarrasPanel.add(codigoBarrasField, BorderLayout.CENTER);
        codigoBarrasPanel.add(adicionarProdutoButton, BorderLayout.EAST);

        JPanel botoesPanel = new JPanel();
        botoesPanel.add(removerProdutoButton);
        botoesPanel.add(clienteVipCheckBox);

        add(codigoBarrasPanel, BorderLayout.NORTH);
        add(produtosScrollPane, BorderLayout.CENTER);
        add(botoesPanel, BorderLayout.SOUTH);

        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        removerProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removerProduto();
            }
        });
    }
    private void adicionarProduto() {
        String codigoBarras = codigoBarrasField.getText();
        if (!codigoBarras.isEmpty()) {
            // Lógica para buscar informações do produto pelo código de barras usando o EstoqueControll
            Produto produto = estoqueControll.obterProdutoPorCodigoBarras(codigoBarras);
    
            if (produto != null) {
                // Adiciona o produto à lista exibida no JList
                produtosListModel.addElement(produto.getNome() + " - Preço: R$" + produto.getPreco());
                codigoBarrasField.setText("");
            } else {
                JOptionPane.showMessageDialog(this, "Produto não encontrado no estoque", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    
    

    private void removerProduto() {
        int selectedIndex = produtosList.getSelectedIndex();
        if (selectedIndex != -1) {
            produtosListModel.remove(selectedIndex);
        }
    }
}
