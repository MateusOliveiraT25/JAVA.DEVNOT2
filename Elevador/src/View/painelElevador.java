package View;

import javax.swing.*;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PainelElevador extends JFrame {

    private JLabel estadoElevador1;
    private JLabel estadoElevador2;
    private int andarElevador1;
    private int andarElevador2;
    private List<JButton> botoesAndar;
    private Clip clip; // Variável para controlar a reprodução do som

    public PainelElevador() {
        super("Painel de Elevadores");

        andarElevador1 = 0;
        andarElevador2 = 0;

        // Painel para o estado dos elevadores
        JPanel painelEstado = new JPanel(new GridLayout(2, 2)); // 2 linhas, 2 colunas
        estadoElevador1 = new JLabel("Elevador 1: Parado no Andar 0");
        estadoElevador2 = new JLabel("Elevador 2: Parado no Andar 0");
        painelEstado.add(new JLabel("Elevador 1:"));
        painelEstado.add(estadoElevador1);
        painelEstado.add(new JLabel("Elevador 2:"));
        painelEstado.add(estadoElevador2);

        // Painel para os botões de andar
        JPanel painelBotoes = new JPanel(new GridLayout(5, 2)); // 5 linhas, 2 colunas
        botoesAndar = new ArrayList<>();
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
            painelBotoes.add(botaoAndar);
        }

        // Adiciona os painéis à janela principal
        add(painelEstado, BorderLayout.NORTH);
        add(painelBotoes, BorderLayout.CENTER);

        setSize(700, 500); // Ajustei o tamanho do painel para acomodar os botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chamarElevador(int andarDestino) {
        // Se já estiver tocando música, pare antes de iniciar uma nova
        if (clip != null && clip.isRunning()) {
            pararMusica();
        }

        // Calcula a distância dos elevadores até o andar de destino
        int distanciaElevador1 = Math.abs(andarDestino - andarElevador1);
        int distanciaElevador2 = Math.abs(andarDestino - andarElevador2);

        // Verifica se os elevadores estão no mesmo andar
        if (andarElevador1 == andarElevador2) {
            // Ambos elevadores estão no mesmo andar
            // Decide qual elevador mover baseado na regra de prioridade (o que estiver em
            // cima desce)
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

        // Após chamar o elevador, atualize o estado visual
        atualizarEstadoElevadores("Em Movimento", "Parado");

        // Destacar o botão correspondente ao andar pressionado
        for (JButton botaoAndar : botoesAndar) {
            botaoAndar.setEnabled(true); // Habilita todos os botões
        }
        botoesAndar.get(andarDestino).setEnabled(false); // Desabilita o botão correspondente ao andar pressionado
    }

    // Método para atualizar o estado visual dos elevadores
    public void atualizarEstadoElevadores(String estadoElevador1, String estadoElevador2) {
        this.estadoElevador1.setText("Elevador 1: " + estadoElevador1);
        this.estadoElevador2.setText("Elevador 2: " + estadoElevador2);
    }

    private void moverElevador(int elevador, int andarDestino) {
        // Obtém o caminho do arquivo WAV para o som de chegada ao andar
        String wavFilePath = "C:\\Users\\DevNoite\\Documents\\Audio\\GarotadeIpanema.wav";

        // Calcula o tempo de movimentação (simulando o movimento) em milissegundos
        int tempoPorAndar = 2000; // 2 segundos por andar (ajuste conforme necessário)
        int tempoTotal = Math.abs(andarDestino - (elevador == 1 ? andarElevador1 : andarElevador2)) * tempoPorAndar;

        // Inicia a reprodução do som em uma nova thread
        new Thread(() -> {
            try {
                clip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new File(wavFilePath));
                clip.open(audioInputStream);
                clip.start();
                Thread.sleep(tempoTotal); // Aguarda o tempo de reprodução
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Se a música não foi interrompida, atualiza o estado do elevador
            if (clip != null && clip.isRunning()) {
                if (elevador == 1) {
                    andarElevador1 = andarDestino;
                    estadoElevador1.setText("Elevador 1: Indo para o Andar " + andarDestino);
                } else {
                    andarElevador2 = andarDestino;
                    estadoElevador2.setText("Elevador 2: Indo para o Andar " + andarDestino);
                }

                // Aguarde o tempo de movimentação (simulando o movimento)
                try {
                    Thread.sleep(tempoTotal); // Aguarda o tempo de movimentação
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                // Atualiza o estado para refletir que o elevador chegou ao destino
                if (elevador == 1) {
                    estadoElevador1.setText("Elevador 1: Parado no Andar " + andarDestino);
                } else {
                    estadoElevador2.setText("Elevador 2: Parado no Andar " + andarDestino);
                }
            }
        }).start();
    }

    // Método para parar a reprodução da música
    private void pararMusica() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    // Método para tornar a janela visível
    public void run() {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new PainelElevador().setVisible(true);
            }
        });
    }

}
