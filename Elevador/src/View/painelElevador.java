import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
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
        // Obtém o caminho do arquivo MP3
        String mp3FilePath = "caminho/do/arquivo/movimento.mp3"; // Substitua pelo caminho correto do seu arquivo MP3

        // Calcula o tempo de movimentação (simulando o movimento) em milissegundos
        int tempoPorAndar = 2000; // 2 segundos por andar (ajuste conforme necessário)
        int tempoTotal = Math.abs(andarDestino - (elevador == 1 ? andarElevador1 : andarElevador2)) * tempoPorAndar;

        // Inicia a reprodução do som em uma nova thread
        new Thread(() -> {
            try {
                Clip clip = AudioSystem.getClip();
                AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new FileInputStream(mp3FilePath));
                clip.open(audioInputStream);
                clip.start();
                Thread.sleep(tempoTotal); // Aguarda o tempo de reprodução
            } catch (Exception e) {
                e.printStackTrace();
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
        }).start();
    }

    private void abrirPorta() {
        // Obtém o caminho do arquivo WAV para o som de abertura da porta
        String wavFilePath = "caminho/do/arquivo/porta.wav"; // Substitua pelo caminho correto do seu arquivo WAV

        try {
            // Obtém um Clip para reprodução do som
            Clip clip = AudioSystem.getClip();
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(new FileInputStream(wavFilePath));
            clip.open(audioInputStream);

            // Adiciona um listener para saber quando a reprodução é concluída
            clip.addLineListener(event -> {
                if (event.getType() == LineEvent.Type.STOP) {
                    // Lógica para quando a reprodução é concluída
                    // Adicione qualquer lógica adicional aqui, se necessário
                }
            });

            // Inicia a reprodução
            clip.start();

            // Aguarde o tempo de reprodução
            Thread.sleep(clip.getMicrosecondLength() / 1000); // Aguarda o tempo de reprodução em milissegundos
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   
}
