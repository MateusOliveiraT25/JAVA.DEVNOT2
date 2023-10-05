import javax.swing.JFrame;
import javax.swing.JTabbedPane;

    public class MinhaJframe extends JFrame{
    public MinhaJframe() {
        super("Calculadoras");
        this.add(new JTabbedPane());
        //set frame
        this.setBounds(500, 100, 300, 200);
        this.setVisible(true);
        this.setResizable(false);
    }
}