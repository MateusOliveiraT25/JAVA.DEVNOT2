<<<<<<< HEAD
/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        //Criar uma janela do  tipo frame 
        JFrame janela1= new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        janela1.add(new JLabel("Nº de botões"));
        JTextField campoTexto = new JTextField("Insira um valor", 25);
        janela1.add(campoTexto);
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        // criar a ação do botao
        enviar.addActionListener(e ->{
            int valor = Integer.parseInt(campoTexto.getText());
            for (int i = 0; i < valor; i++) {
                janela1.add(new JButton(""+i+1));
            }
               janela1.pack();
        });
        //seta os elementos da janela
        janela1.setDefaultCloseOperation(0);
        janela1.pack();
        janela1.setVisible(true);

      
    }

} */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        // Criar uma janela do tipo frame
        JFrame janela1 = new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);

        janela1.add(new JLabel("Nº de botões"));
        JTextField campoTexto = new JTextField("Insira um valor", 25);
        janela1.add(campoTexto);

        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);

        // Criar a ação do botão "Enviar"
        enviar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(campoTexto.getText());

                for (int i = 0; i < valor; i++) {
                    janela1.add(new JButton("" + (i + 1))); // Adicionei parênteses para garantir a precedência da operação de soma
                }

                janela1.pack(); // Atualiza o layout da janela para refletir as mudanças
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido");
            }
        });

        // Configuração da janela
        janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela1.pack();
        janela1.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExemploFlowLayout();
            }
        });
    }
}
=======
/*import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;
public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        //Criar uma janela do  tipo frame 
        JFrame janela1= new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);
        janela1.add(new JLabel("Nº de botões"));
        JTextField campoTexto = new JTextField("Insira um valor", 25);
        janela1.add(campoTexto);
        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);
        // criar a ação do botao
        enviar.addActionListener(e ->{
            int valor = Integer.parseInt(campoTexto.getText());
            for (int i = 0; i < valor; i++) {
                janela1.add(new JButton(""+i+1));
            }
               janela1.pack();
        });
        //seta os elementos da janela
        janela1.setDefaultCloseOperation(0);
        janela1.pack();
        janela1.setVisible(true);

      
    }

} */
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;

public class ExemploFlowLayout {
    public ExemploFlowLayout() {
        // Criar uma janela do tipo frame
        JFrame janela1 = new JFrame("Janela FlowLayout");
        FlowLayout flow = new FlowLayout();
        janela1.setLayout(flow);

        janela1.add(new JLabel("Nº de botões"));
        JTextField campoTexto = new JTextField("Insira um valor", 25);
        janela1.add(campoTexto);

        JButton enviar = new JButton("Enviar");
        janela1.add(enviar);

        // Criar a ação do botão "Enviar"
        enviar.addActionListener(e -> {
            try {
                int valor = Integer.parseInt(campoTexto.getText());

                for (int i = 0; i < valor; i++) {
                    janela1.add(new JButton("" + (i + 1))); // Adicionei parênteses para garantir a precedência da operação de soma
                }

                janela1.pack(); // Atualiza o layout da janela para refletir as mudanças
            } catch (NumberFormatException ex) {
                System.out.println("Valor inválido");
            }
        });

        // Configuração da janela
        janela1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        janela1.pack();
        janela1.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ExemploFlowLayout();
            }
        });
    }
}
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
