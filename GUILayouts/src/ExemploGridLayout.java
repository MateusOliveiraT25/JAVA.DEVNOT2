import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ExemploGridLayout {
    public ExemploGridLayout() {
     JFrame janela1 = new JFrame("Layout Calculadora");
     
     BorderLayout border = new BorderLayout();
      janela1.setLayout(border);
      JPanel painelV = new JPanel();
      JPanel painelB = new JPanel();//padrao flowLayout

     //layout da Jframe padrao é GridLayout
     //Alterar para flowLayout
     GridLayout grid = new GridLayout(4,4);
     painelB.setLayout(grid);
     
     janela1.getContentPane().add(painelB,BorderLayout.CENTER);
     janela1.getContentPane().add(painelV,BorderLayout.NORTH);
     JTextField caixa1 = new JTextField(25);
     painelV.add(caixa1);
     // adicionar componentes ao painel
       String textBotoes[]={"+","9","8","7","/","6","5","4","*","3","2","1","-","C","0","="};
   for (int i = 0; i < textBotoes.length;i++) {
       painelB.add(new JButton(textBotoes[i]));
   }
  
   

     //config janela1
     janela1.setBounds(300,300,300,300);
     janela1.setDefaultCloseOperation(2);
     janela1.setVisible(true);

    }
}
