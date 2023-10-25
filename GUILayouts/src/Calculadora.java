import java.awt.*;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
<<<<<<< HEAD
=======
import java.awt.BorderLayout;
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348


public class Calculadora extends JPanel{
    public Calculadora() {
        super(new BorderLayout());
<<<<<<< HEAD
        //mudando o Lyout dathis
=======
        //mudando o Lyout daFrame
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
        BorderLayout border = new BorderLayout();
        this.setLayout(border);
        JPanel painelV = new JPanel();
        JPanel painelB = new JPanel();
        JPanel painelC = new JPanel();// padrao flowlayout
        this.add(painelV, BorderLayout.NORTH);
        this.add(painelB, BorderLayout.CENTER);
        this.add(painelC, BorderLayout.EAST);
       
        //adicionar o textField no PainelV
         JTextField visor = new JTextField(30);
        painelV.add(visor);
        // set layout do JPanel
        GridLayout grid = new GridLayout(4, 4);
        painelB.setLayout(grid);
        String textBotoes[] = { "9", "8", "7","6", "5", "4", "1", "2", "3","AC","0","="};
        for (int a = 0; a < textBotoes.length; a++) {
            painelB.add(new JButton(textBotoes[a]));
        }
        //GridLayout grid2 = new GridLayout(1, 1);
       // painelC.setLayout(grid2);
        painelC.setLayout(new GridLayout(4, 1));
        painelC.add(new JButton("+"));
        painelC.add(new JButton("-"));
        painelC.add(new JButton("/"));
        painelC.add(new JButton("x"));
<<<<<<< HEAD
     //set do Frame
   
    this.pack();
   this.setVisible(true);
    this.setBounds(300,300,300,300);

=======
    
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348

       // String textBotoes2[] = {  "0","="};
        //for (int i = 0; i < textBotoes2.length; i++) {
           // painelB.add(new JButton(textBotoes2[i]));
        // Vetor com os txtos dos botoes
       
    }
<<<<<<< HEAD

    private void pack() {
    }
}
=======
}
>>>>>>> 63e0b5528dd2e85af9e8b9a045104dab10a1a348
