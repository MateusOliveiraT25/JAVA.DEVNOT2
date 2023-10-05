import javax.swing.JFrame;
public class JFrameSwing extends JFrame {
    
public JFrameSwing() {
    super("Minha primeira janela de Swing");
    this.setSize(400, 400);
    this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    this.setVisible(true);
}
}
