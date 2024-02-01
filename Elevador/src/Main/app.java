package Main;

import javax.swing.SwingUtilities;

import View.PainelElevador;

public class app {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new PainelElevador().setVisible(true));
    }
}
