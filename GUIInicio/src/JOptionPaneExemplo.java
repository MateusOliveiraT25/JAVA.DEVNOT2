

import javax.swing.JOptionPane;

public class JOptionPaneExemplo extends JOptionPane {
    public JOptionPaneExemplo(){
        super();
        String informacao = "Minha Janela Dialog";
        this.showMessageDialog(getComponentPopupMenu(),
         informacao, informacao,
         JOptionPane.INFORMATION_MESSAGE);
    }
}
