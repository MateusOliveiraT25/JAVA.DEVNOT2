package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class painelElevador extends JFrame {

    private JLabel estadoElevador1;
    private JLabel estadoElevador2;
    private int andarElevador1;
    private int andarElevador2;

    public painelElevador() {
        super("Painel de Elevadores");

        estadoElevador1 = new JLabel("Elevador 1: Parado no Andar 0");
        estadoElevador2 = new JLabel("Elevador 2: Parado no Andar 0");
        andarElevador1 = 0;
        andarElevador2 = 0;

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4, 2)); // 4 linhas (2 para o estado e 2 para os botões), 2 colunas

        painelPrincipal.add(new JLabel("Elevador 1:"));
        painelPrincipal.add(estadoElevador1);

        painelPrincipal.add(new JLabel("Elevador 2:"));
        painelPrincipal.add(estadoElevador2);

        // Adiciona botões de andar
        for (int i = 0; i < 10; i++) {
            JButton botaoAndar = new JButton("Andar " + i);
            final int andar = i;
            botaoAndar.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    chamarElevador(andar);
                }
            });
            painelPrincipal.add(botaoAndar);
        }

        add(painelPrincipal);

        setSize(400, 300); // Ajustei o tamanho do painel para acomodar os botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chamarElevador(int andarDestino) {
        // Adiciona a lógica para mover o elevador até o andar de destino
        if (andarDestino > andarElevador1) {
            moverElevador(1, andarDestino);
        } else if (andarDestino < andarElevador1) {
            moverElevador(1, andarDestino);
        } else {
            // Elevador já está no andar de destino
        }

        // Faça o mesmo para o Elevador 2 se necessário
    }

    private void moverElevador(int elevador, int andarDestino) {
        // Atualiza o estado do elevador
        if (elevador == 1) {
            estadoElevador1.setText("Elevador 1: Indo para o Andar " + andarDestino);
            andarElevador1 = andarDestino;
        } else if (elevador == 2) {
            estadoElevador2.setText("Elevador 2: Indo para o Andar " + andarDestino);
            andarElevador2 = andarDestino;
        }

        // Aguarde por algum tempo (simulando o movimento)
        try {
            Thread.sleep(1000); // Aguarda 1 segundo
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Atualiza o estado para refletir que o elevador chegou ao destino
        if (elevador == 1) {
            estadoElevador1.setText("Elevador 1: Parado no Andar " + andarDestino);
        } else if (elevador == 2) {
            estadoElevador2.setText("Elevador 2: Parado no Andar " + andarDestino);
        }
    }

    public void run() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'run'");
    }

}
