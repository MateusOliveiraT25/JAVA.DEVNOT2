package View;

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

    public VendasPainel() {
        setLayout(new BorderLayout());

        // Campo para inserção do código de barras do produto
        codigoBarrasField = new JTextField();
        adicionarProdutoButton = new JButton("Adicionar Produto");

        // Lista dinâmica dos produtos adicionados à venda
        produtosListModel = new DefaultListModel<>();
        produtosList = new JList<>(produtosListModel);
        JScrollPane produtosScrollPane = new JScrollPane(produtosList);

        // Botões para adicionar/remover produtos
        removerProdutoButton = new JButton("Remover Produto");

        // Indicação visual de desconto aplicado para clientes VIP
        clienteVipCheckBox = new JCheckBox("Cliente VIP");

        // Adicionando componentes ao painel de vendas
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

        // Adicionando ação ao botão "Adicionar Produto"
        adicionarProdutoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                adicionarProduto();
            }
        });

        // Adicionando ação ao botão "Remover Produto"
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
            // Lógica para buscar informações do produto pelo código de barras
            String nomeProduto = obterNomeProdutoPorCodigoBarras(codigoBarras);

            // Adiciona o produto à lista
            produtosListModel.addElement(nomeProduto);

            // Limpa o campo de código de barras
            codigoBarrasField.setText("");
        }
    }

    private void removerProduto() {
        int selectedIndex = produtosList.getSelectedIndex();
        if (selectedIndex != -1) {
            // Remove o produto selecionado da lista
            produtosListModel.remove(selectedIndex);
        }
    }

    // Simula a obtenção do nome do produto a partir do código de barras
    private String obterNomeProdutoPorCodigoBarras(String codigoBarras) {
        // Implemente a lógica real para buscar o nome do produto no banco de dados
        // ou onde quer que essas informações estejam disponíveis.
        // Aqui, estamos apenas retornando um nome de exemplo.
        return "Produto " + codigoBarras;
    }

   
    }

