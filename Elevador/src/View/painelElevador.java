import javazoom.jl.decoder.Bitstream;
import javazoom.jl.player.advanced.AdvancedPlayer;
import javazoom.jl.player.advanced.PlaybackEvent;
import javazoom.jl.player.advanced.PlaybackEventAdapter;
import javazoom.jl.player.advanced.PlaybackThread;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class PainelElevador extends JFrame {

    private JLabel estadoElevador1;
    private JLabel estadoElevador2;
    private int andarElevador1;
    private int andarElevador2;
    private List<JButton> botoesAndar;

    public PainelElevador() {
        super("Painel de Elevadores");

        estadoElevador1 = new JLabel("Elevador 1: Parado no Andar 0");
        estadoElevador2 = new JLabel("Elevador 2: Parado no Andar 0");
        andarElevador1 = 0;
        andarElevador2 = 0;

        botoesAndar = new ArrayList<>();

        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setLayout(new GridLayout(5, 2)); // 5 linhas (2 para o estado, 2 para os botões, 1 para abrir porta), 2 colunas

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

        // Adiciona botão para abrir a porta
        JButton botaoAbrirPorta = new JButton("Abrir Porta");
        botaoAbrirPorta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                abrirPorta();
            }
        });
        painelPrincipal.add(botaoAbrirPorta);

        add(painelPrincipal);

        setSize(400, 350); // Ajustei o tamanho do painel para acomodar os botões
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void chamarElevador(int andarDestino) {
        // ... (Código anterior para chamar o elevador)
    }

    private void abrirPorta() {
        // Obtém o caminho do arquivo MP3 para o som de abertura da porta
        String mp3FilePath = "caminho/do/arquivo/porta.mp3"; // Substitua pelo caminho correto do seu arquivo MP3

        // Inicia a reprodução do som em uma nova thread
        new Thread(() -> {
            try {
                Bitstream bitstream = new Bitstream(new FileInputStream(mp3FilePath));
                int duration = bitstream.readFrame().max_number_of_frames(null) * 26; // Ajuste conforme necessário
                AdvancedPlayer player = new AdvancedPlayer(new FileInputStream(mp3FilePath));
                PlaybackThread playbackThread = new PlaybackThread(player);
                playbackThread.setPlayBackListener(new PlaybackEventAdapter() {
                    @Override
                    public void playbackFinished(PlaybackEvent evt) {
                        // Chamado quando a reprodução termina
                        // Adicione qualquer lógica adicional aqui, se necessário
                    }
                });
                playbackThread.start();

                // Aguarde o tempo de reprodução
                Thread.sleep(duration); // Aguarda o tempo de reprodução

                // Para a reprodução quando a abertura da porta é concluída
                playbackThread.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }

        // Atualiza o estado do elevador e a posição
        int andarAtual = (elevador == 1) ? andarElevador1 : andarElevador2;
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

    public static void main(String[] args) {
        new PainelElevador();
    }
}
