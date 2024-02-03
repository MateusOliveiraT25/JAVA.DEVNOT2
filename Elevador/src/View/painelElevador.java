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
    private Clip clipEmMovimento; // Som quando o elevador está em movimento
    private Clip clipChegadaAoAndar; // Som quando o elevador chega ao andar

    public PainelElevador() {
        super("Painel de Elevadores");

        andarElevador1 = 0;
        andarElevador2 = 0;

        // Painel para o estado dos elevadores
        JPanel painelEstado = new JPanel(new GridLayout(2, 2)); // 2 linhas, 2 colunas
        estadoElevador1 = new JLabel("Elevador 1: Parado no Andar 0");
        estadoElevador2 = new JLabel("Elevador 2: Parado no Andar 0");
        estiloLabel(estadoElevador1);
        estiloLabel(estadoElevador2);
        painelEstado.add(new JLabel("Elevador 1:"));
        painelEstado.add(estadoElevador1);
        painelEstado.add(new JLabel("Elevador 2:"));
        painelEstado.add(estadoElevador2);

        // Painel para os botões de andar
        JPanel painelBotoes = new JPanel(new GridLayout(5, 2)); // 5 linhas, 2 colunas
        botoesAndar = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            JButton botaoAndar = new JButton("Andar " + i);
            estiloBotao(botaoAndar);
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
        if (clipEmMovimento != null && clipEmMovimento.isRunning()) {
            pararMusicaEmMovimento();
        }

        // Calcula a distância dos elevadores até o andar de destino
        int distanciaElevador1 = Math.abs(andarDestino - andarElevador1);
        int distanciaElevador2 = Math.abs(andarDestino - andarElevador2);

        // Verifica se os elevadores estão no mesmo andar
        if (andarElevador1 == andarElevador2) {
            // Ambos elevadores estão no mesmo andar
            // Decide qual elevador mover baseado na regra de prioridade (o que estiver em
            // cima desce)
            if (andarElevador1 < andarDestino && andarElevador2 < andarDestino) {
                // Ambos elevadores estão abaixo do destino, move o que estiver mais acima
                if (andarElevador1 > andarElevador2) {
                    moverElevador(1, andarDestino);
                } else {
                    moverElevador(2, andarDestino);
                }
            } else if (andarElevador1 < andarDestino) {
                moverElevador(1, andarDestino);
            } else if (andarElevador2 < andarDestino) {
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
        String chegadaAoAndarFilePath = "C:\\Users\\DevNoite\\Documents\\Audio\\ChegadaAoAndar.wav";

        // Obtém o caminho do arquivo WAV para o som de elevador em movimento
        String emMovimentoFilePath = "C:\\Users\\DevNoite\\Documents\\Audio\\EmMovimento.wav";

        // Calcula o tempo de movimentação (simulando o movimento) em milissegundos
        int tempoPorAndar = 2000; // 2 segundos por andar (ajuste conforme necessário)
        int tempoTotal = Math.abs(andarDestino - (elevador == 1 ? andarElevador1 : andarElevador2)) * tempoPorAndar;

        // Inicia a reprodução do som de elevador em movimento em uma nova thread
        new Thread(() -> {
            try {
                clipEmMovimento = AudioSystem.getClip();
                AudioInputStream audioInputStreamEmMovimento = AudioSystem
                        .getAudioInputStream(new File(emMovimentoFilePath));
                clipEmMovimento.open(audioInputStreamEmMovimento);
                clipEmMovimento.start();
                Thread.sleep(tempoTotal); // Aguarda o tempo de reprodução
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Se a música não foi interrompida, atualiza o estado do elevador
            if (clipEmMovimento != null && clipEmMovimento.isRunning()) {
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

                // Parar o som de elevador em movimento ao chegar ao destino
                pararMusicaEmMovimento();

                // Tocar o som de chegada ao andar
                tocarChegadaAoAndar();

                // Atualiza o estado para refletir que o elevador chegou ao destino
                if (elevador == 1) {
                    estadoElevador1.setText("Elevador 1: Parado no Andar " + andarDestino);
                } else {
                    estadoElevador2.setText("Elevador 2: Parado no Andar " + andarDestino);
                }
            }
        }).start();
    }

    // Método para parar a reprodução do som de elevador em movimento
    private void pararMusicaEmMovimento() {
        if (clipEmMovimento != null && clipEmMovimento.isRunning()) {
            clipEmMovimento.stop();
            clipEmMovimento.close();
        }
    }

    // Método para tocar o som de chegada ao andar
    private void tocarChegadaAoAndar() {
        // Obtém o caminho do arquivo WAV para o som de chegada ao andar
        String chegadaAoAndarFilePath = "C:\\Users\\DevNoite\\Documents\\Audio\\ChegadaAoAndar.wav";

        // Inicia a reprodução do som em uma nova thread
        new Thread(() -> {
            try {
                clipChegadaAoAndar = AudioSystem.getClip();
                AudioInputStream audioInputStreamChegadaAoAndar = AudioSystem
                        .getAudioInputStream(new File(chegadaAoAndarFilePath));
                clipChegadaAoAndar.open(audioInputStreamChegadaAoAndar);
                clipChegadaAoAndar.start();
                Thread.sleep(clipChegadaAoAndar.getMicrosecondLength() / 1000); // Aguarda o tempo de reprodução
            } catch (Exception e) {
                e.printStackTrace();
            }

            // Se a música não foi interrompida, pare o som de chegada ao andar
            if (clipChegadaAoAndar != null && clipChegadaAoAndar.isRunning()) {
                clipChegadaAoAndar.stop();
                clipChegadaAoAndar.close();
            }
        }).start();
    }

    // Método para parar a reprodução do som de chegada ao andar
    private void pararChegadaAoAndar() {
        if (clipChegadaAoAndar != null && clipChegadaAoAndar.isRunning()) {
            clipChegadaAoAndar.stop();
            clipChegadaAoAndar.close();
        }
    }

    // Método para tornar a janela visível
    public void run() {
        SwingUtilities.invokeLater(() -> new PainelElevador().setVisible(true));
    }

    // Método para adicionar estilo a um botão
    private void estiloBotao(JButton botao) {
        botao.setBackground(new Color(50, 205, 50)); // Cor de fundo verde-limão
        botao.setForeground(Color.WHITE); // Texto branco
        botao.setFocusPainted(false); // Remove a borda de foco
    }

    // Método para adicionar estilo a um rótulo
    private void estiloLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.BOLD, 14));
        label.setForeground(new Color(70, 130, 180)); // Cor azul aço
    }

    public static void main(String[] args) {
        new PainelElevador().run();
    }
}

