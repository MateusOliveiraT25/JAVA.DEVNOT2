package View;

import Controller.EstoqueControll;
import Model.Produto;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class VendasPainel extends JPanel {

    private JTextField codigoBarrasField;
    private DefaultListModel<String> produtosListModel;
    private JList<String> produtosList;
    private JCheckBox clienteVipCheckBox;
    private JButton adicionarProdutoButton, removerProdutoButton;
    private EstoqueControll estoqueControll; // Adiciona um campo para o EstoqueControll

   private JButton avancarButton; // Adiciona um campo para o botão "Avançar"

public VendasPainel(EstoqueControll estoqueControll) {
    this.estoqueControll = estoqueControll;
    setLayout(new BorderLayout());

    codigoBarrasField = new JTextField();
    adicionarProdutoButton = new JButton("Adicionar Produto");

    produtosListModel = new DefaultListModel<>();
    produtosList = new JList<>(produtosListModel);
    JScrollPane produtosScrollPane = new JScrollPane(produtosList);

    removerProdutoButton = new JButton("Remover Produto");
    clienteVipCheckBox = new JCheckBox("Cliente VIP");

    avancarButton = new JButton("Avançar"); // Inicializa o botão "Avançar"

    JPanel codigoBarrasPanel = new JPanel(new BorderLayout());
    codigoBarrasPanel.add(new JLabel("Código de Barras: "), BorderLayout.WEST);
    codigoBarrasPanel.add(codigoBarrasField, BorderLayout.CENTER);
    codigoBarrasPanel.add(adicionarProdutoButton, BorderLayout.EAST);

    JPanel botoesPanel = new JPanel();
    botoesPanel.add(removerProdutoButton);
    botoesPanel.add(clienteVipCheckBox);
    botoesPanel.add(avancarButton); // Adiciona o botão "Avançar"

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
    avancarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Lógica para avançar para a tela de conclusão
            JTabbedPane jTPane = (JTabbedPane) SwingUtilities.getAncestorOfClass(JTabbedPane.class, VendasPainel.this);
    
            // Supondo que "Tela de Conclusão de Compras" está na terceira posição (índice 2)
            jTPane.setSelectedIndex(2);
    
            // Obtém a referência para o ConclusaoCompraPainel
            ConclusaoCompraPainel conclusaoCompraPainel = (ConclusaoCompraPainel) jTPane.getComponentAt(2);
    
            // Obtém os produtos do VendasPainel
            List<String> produtos = obterProdutosDoVendasPainel();
    
            // Passa os produtos para o ConclusaoCompraPainel
            conclusaoCompraPainel.setProdutos(produtos);
        }
    
        private List<String> obterProdutosDoVendasPainel() {
            // Lógica para obter a lista de produtos do VendasPainel
            List<String> produtos = new ArrayList<>();
            // Adicione aqui a lógica para obter os produtos do VendasPainel e formatá-los como desejado
            return produtos;
        }
    });
    

    
}

private void adicionarProduto() {
    String codigoBarras = codigoBarrasField.getText();
    if (!codigoBarras.isEmpty()) {
        Produto produto = estoqueControll.obterProdutoPorCodigoBarras(codigoBarras);

        if (produto != null) {
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