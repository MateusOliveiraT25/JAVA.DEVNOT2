import javax.swing.JButton;
import javax.swing.JFrame;
//import javax.swing.JPanel;

import java.awt.FlowLayout;

public class ContainerComponentes extends JFrame {
    public ContainerComponentes() {
        super("Exemplo Janela");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(200, 200, 400, 400);
        FlowLayout flow = new   FlowLayout();
        this.setLayout(flow);
        //Utilizando um novo Container
       // JPanel painel = new JPanel(); //por padrao é um flowlayout
       //this.getContentPane()add(painel);
       for (int i = 0; i< 6; i++) {
        this.add(new JButton("Number " +i));
       }this.setVisible(true);
    }
}
