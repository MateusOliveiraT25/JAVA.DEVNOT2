import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JButtonAmndJLabel {
    private int clickCount = 0; // Contador de cliques
    private JLabel clickLabel; // Rótulo para exibir o número de cliques

    public JButtonAmndJLabel() {
        // Criar um JFrame
        JFrame janela = new JFrame("Janela Principal");
        JPanel painel = new JPanel(); // Painel (Container)

        // Criar Componentes
        JButton button = new JButton("Clique Aqui!!!");
        clickLabel = new JLabel("Nº de Cliques: 0");

        // Adicionar os componentes ao painel
        painel.add(button);
        painel.add(clickLabel);
        painel.add(new JButton("" + clickCount));

        // Adicionar um ouvinte de ação ao botão
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Ação a ser executada quando o botão for clicado
                clickCount++; // Incrementar o contador de cliques
                updateClickLabel(); // Atualizar o rótulo com o novo número de cliques
            }
        });

        // Configurações da janela
        janela.getContentPane().add(painel);
        janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela.pack();
        janela.setVisible(true);
    }

    // Atualiza o rótulo com o número de cliques atualizado
    private void updateClickLabel() {
        clickLabel.setText("Nº de Cliques: " + clickCount);
    }

    public static void main(String[] args) {
        // Inicializa a interface gráfica na thread de despacho de eventos
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new JButtonAmndJLabel();
            }
        });
    }
    


}



/*  (ActionListener)(acao para o botao)
  button.addActionListener(e ->{
            cont++;
            text.setText("Nº de Cliques "+cont);
            janela.pack();
        });*/


