package View;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.applet.Applet;
import java.applet.AudioClip;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class PainelElevador extends JFrame {

    private JLabel estadoElevador1;
    private JLabel estadoElevador2;
    private int andarElevador1;
    private int andarElevador2;
    private List<JButton> botoesAndar;
    private AudioClip elevadorSound; // Adiciona variável para o som

    public PainelElevador() {
        super("Painel de Elevadores");

        estadoElevador1 = new JLabel("Elevador 1: Parado no Andar 0");
        estadoElevador2 = new JLabel("Elevador 2: Parado no Andar 0");
        andarElevador1 = 0;
        andarElevador2 = 0;

        botoesAndar = new ArrayList<>();

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(4, 2)); // 4 linhas (2 para o estado e 2 para os botões), 2 colunas

        painelPrincipal.add(new JLabel("Elevador 1:"));
        painelPrincipal.add(estadoElevador1);

        painelPrincipal.add(new JLabel("Elevador 2:"));
        painelPrincipal.add(estadoElevador2);

        // Adiciona botões de andar
        for (int i = 0; i < 10; i++) {
            JButton botaoAndar = new JButton("Andar " + i);
            botoesAndar.add(botaoAndar); // Adiciona o botão à lista
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

        // Carrega o som do elevador
        URL soundUrl = getClass().getResource("/caminho/do/arquivo/som.wav");
        elevadorSound = Applet.newAudioClip(soundUrl);

        setSize(400, 300); // Ajustei o tamanho do painel para acomodar os botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chamarElevador(int andarDestino) {
        // Calcula a distância dos elevadores até o andar de destino
        int distanciaElevador1 = Math.abs(andarDestino - andarElevador1);
        int distanciaElevador2 = Math.abs(andarDestino - andarElevador2);

        // Verifica se os elevadores estão no mesmo andar
        if (andarElevador1 == andarElevador2) {
            // Ambos elevadores estão no mesmo andar
            // Decide qual elevador mover baseado na regra de prioridade (o que estiver em cima desce)
            if (andarElevador1 < andarDestino) {
                moverElevador(1, andarDestino);
            } else {
                moverElevador(2, andarDestino);
            }
        } else {
            // Elevadores estão em andares diferentes
            // Move o elevador mais próximo do andar de destino
            if (distanciaElevador1 < distanciaElevador2) {
                moverElevador(1, andarDestino);
            } else {
                moverElevador(2, andarDestino);
            }
        }
    }

    // Método para atualizar o estado visual dos elevadores
    public void atualizarEstadoElevadores(String estadoElevador1, String estadoElevador2) {
        this.estadoElevador1.setText("Elevador 1: " + estadoElevador1 + " no Andar " + andarElevador1);
        this.estadoElevador2.setText("Elevador 2: " + estadoElevador2 + " no Andar " + andarElevador2);
    }

   private void moverElevador(int elevador, int andarDestino) {
        // Obtém o URL do som
        URL soundUrl = getClass().getResource("/caminho/do/arquivo/som.wav");

        // Inicia o som do elevador em uma nova thread para permitir a reprodução contínua
        new Thread(() -> {
            // Toca o som enquanto o elevador está se movimentando
            AudioClip elevadorSound = Applet.newAudioClip(soundUrl);
            elevadorSound.loop();

            // Aguarde o tempo de movimentação (simulando o movimento)
            try {
                Thread.sleep(2000); // Aguarda 2 segundos (ajuste conforme necessário)
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // Para o som quando o elevador chega ao destino
            elevadorSound.stop();
        }).start();

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
            Thread.sleep(2000); // Aguarda 2 segundos (ajuste conforme necessário)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Atualiza o estado para refletir que o elevador chegou ao destino
        if (elevador == 1) {
            estadoElevador1.setText("Elevador 1: Parado no Andar " + andarDestino);
        } else if (elevador == 2) {
            estadoElevador2.setText("Elevador 2: Parado no Andar " + andarDestino);
        }

        // Após o elevador chegar ao destino, atualize o estado visual
        atualizarEstadoElevadores("Parado", "Parado");

        // Destacar o botão correspondente ao andar pressionado
        for (JButton botaoAndar : botoesAndar) {
            botaoAndar.setEnabled(true); // Habilita todos os botões
        }
        botoesAndar.get(andarDestino).setEnabled(false); // Desabilita o botão correspondente ao andar pressionado
    }

   
}
