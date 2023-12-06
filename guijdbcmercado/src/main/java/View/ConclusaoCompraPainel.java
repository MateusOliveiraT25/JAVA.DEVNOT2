package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConclusaoCompraPainel extends JPanel {

    private DefaultListModel<String> detalhesCompraModel;
    private JList<String> detalhesCompraList;
    private JLabel totalCompraLabel;
    private JComboBox<String> opcoesPagamentoComboBox;
    private JButton finalizarCompraButton, imprimirCupomButton;

    public ConclusaoCompraPainel() {
        setLayout(new BorderLayout());

        // Lista final dos produtos, quantidades e preços
        detalhesCompraModel = new DefaultListModel<>();
        detalhesCompraList = new JList<>(detalhesCompraModel);
        JScrollPane detalhesCompraScrollPane = new JScrollPane(detalhesCompraList);

        // Rótulo para exibir o total da compra
        totalCompraLabel = new JLabel("Total da Compra: R$ 0.00");

        // Opções de pagamento
        String[] opcoesPagamento = {"Dinheiro", "Cartão de Crédito", "Cartão de Débito", "Pix"};
        opcoesPagamentoComboBox = new JComboBox<>(opcoesPagamento);

        // Botão para finalizar a compra
        finalizarCompraButton = new JButton("Finalizar Compra");

        // Botão opcional para imprimir o relatório de vendas (Cupom Fiscal)
        imprimirCupomButton = new JButton("Imprimir Cupom Fiscal");

        // Adicionando componentes ao painel de conclusão
        JPanel botoesPanel = new JPanel();
        botoesPanel.add(finalizarCompraButton);
        botoesPanel.add(imprimirCupomButton);

        add(detalhesCompraScrollPane, BorderLayout.CENTER);
        add(totalCompraLabel, BorderLayout.SOUTH);
        add(opcoesPagamentoComboBox, BorderLayout.NORTH);
        add(botoesPanel, BorderLayout.EAST);

        // Adicionando ação ao botão "Finalizar Compra"
        finalizarCompraButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                finalizarCompra();
            }
        });

        // Adicionando ação ao botão "Imprimir Cupom Fiscal"
        imprimirCupomButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                imprimirCupomFiscal();
            }
        });
    }

    private void finalizarCompra() {
        // Lógica para finalizar a compra
        // Atualize conforme necessário
        JOptionPane.showMessageDialog(this, "Compra finalizada com sucesso!");
    }

    private void imprimirCupomFiscal() {
        // Lógica para imprimir o Cupom Fiscal
        // Atualize conforme necessário
        JOptionPane.showMessageDialog(this, "Cupom Fiscal impresso com sucesso!");
    }

   
    
}
