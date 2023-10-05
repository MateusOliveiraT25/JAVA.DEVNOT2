import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.Button;
public class BorderLayoutExemplo {
    public BorderLayoutExemplo() {
        super();
        JFrame janelaP = new JFrame("Janela Principal");
        BorderLayout border = new BorderLayout();
        janelaP.setLayout(border);
        janelaP.add(new Button("West"),BorderLayout.WEST);
          janelaP.add(new Button("East"),BorderLayout.EAST);
            janelaP.add(new Button("Center"),BorderLayout.CENTER);
              janelaP.add(new Button("South"),BorderLayout.SOUTH);
                janelaP.add(new Button("North"),BorderLayout.NORTH);
 //set frame
    janelaP.setDefaultCloseOperation(2);
    janelaP.pack();
    janelaP.setVisible(true);
    }

    
  }