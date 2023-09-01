import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.*;
    

public class BoxLayoutExemplo extends JFrame {
    public BoxLayoutExemplo() {
        // configurado layout do frame
        super("Exemplo Box Layout ");
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        // criar dois paineis
        JPanel painel1 = new JPanel();
        JPanel painel2 = new JPanel();
        //adicionar os paineis ao frame 
        this.add(painel1,BorderLayout.WEST);
        this.add(painel2,BorderLayout.SOUTH);
        // layout do paineis
        painel1.setLayout(new BoxLayout(painel1, BoxLayout.Y_AXIS));
        painel2.setLayout(new BoxLayout(painel2, BoxLayout.X_AXIS));
        //adicionar os elementos aos paineis 
        for (int i = 0; i <5; i++) {
           painel1.add(new JButton(""+i+1)) ;
           painel2.add(new JButton(""+i+1)) ;
        }
        //set do Frame
        this.setDefaultCloseOperation(2);
        this.pack();
        this.setVisible(true);


    }
}
