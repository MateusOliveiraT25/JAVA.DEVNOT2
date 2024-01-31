package Controller;


import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class movimentar {
    private Predio predio;

    public Movimentar() {
        this.predio = new Predio(2, 10, 0);
    }

    public void run() {
        criarInterfaceGrafica();
    }

    private void criarInterfaceGrafica() {
        JFrame frame = new JFrame("Movimentar Prédio");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JButton chamarElevadorButton = new JButton("Chamar Elevador");
        chamarElevadorButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chamarElevadorPelaInterface();
            }
        });

        frame.getContentPane().add(chamarElevadorButton);
        frame.setSize(300, 200);
        frame.setVisible(true);
    }

    private void chamarElevadorPelaInterface() {
        int andarDestino = obterAndarDesejado();
        predio.chamarElevadorParaAndar(andarDestino);
        predio.atualizar();
        predio.exibirEstadoPredio();
    }

    private int obterAndarDesejado() {
        try {
            String andarDestinoStr = JOptionPane.showInputDialog("Informe o andar desejado:");
            if (andarDestinoStr == null) {
                // Usuário clicou em Cancelar ou fechou a janela
                return 0;  // Andar inválido, tratado como o térreo
            }

            return Integer.parseInt(andarDestinoStr);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um número válido para o andar.", "Erro", JOptionPane.ERROR_MESSAGE);
            return 0;  // Andar inválido, tratado como o térreo
        }
    }

    
    }

