

import javax.swing.JOptionPane;

public class JOptionPaneExemplo extends JOptionPane {
    public JOptionPaneExemplo(){
        super();
        String informacao = "Minha Janela Dialog";
        JOptionPane.showMessageDialog(null,
            informacao, "Título da Janela",
            JOptionPane.INFORMATION_MESSAGE);
    }
}
