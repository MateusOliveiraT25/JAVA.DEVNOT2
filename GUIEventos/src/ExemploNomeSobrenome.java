import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

public class ExemploNomeSobrenome extends JFrame {
        private JLabel texto;
        private  JTextField caixaNome;
        private JTextField caixaSobrenome;
    // construtor
    public ExemploNomeSobrenome() {
        super("Nome Sobrenome");
        this.setDefaultCloseOperation(2);
        this.setBounds(100, 100, 300, 150);
        // criar painel grid layout 3x2
        JPanel maiPanel = new JPanel(new GridLayout(3, 2));
        // criar componentes do painel
        maiPanel.add(new JLabel("Nome"));
        JTextField caixaNome = new JTextField();
        maiPanel.add(caixaNome);
        maiPanel.add(new JLabel("Sobrenome"));
        JTextField caixaSobrenome = new JTextField();
        maiPanel.add(caixaSobrenome);
        JButton botao = new JButton("Concatenar");
        maiPanel.add(botao);
        JLabel texto = new JLabel();
        maiPanel.add(texto);
        // Configurações do frame
        this.add(maiPanel);
        this.setVisible(true);
        // tratamentos de eventos
        // 1 forma: e->
        /*
         * botao.addActionListener(e->{
         * //evento
         * texto.setText(caixaNome.getText()+" "+caixaSobrenome.getText());
         * caixaNome.setText("");
         * caixaSobrenome.setText("");
         * });
         */
        // 2 forma: +comum
      /*  botao.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                texto.setText(caixaNome.getText() + " " + caixaSobrenome.getText());
                caixaNome.setText("");
                caixaSobrenome.setText("");

            }
        }); */
         // 3 forma:- Handler
         //importar classe do Handler -> botao
         Handler evt = new Handler();
         botao.addActionListener(evt);

         
            }
         public class Handler implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e){
                texto.setText(caixaNome.getText() + " " + caixaSobrenome.getText());
                caixaNome.setText("");
                caixaSobrenome.setText("");
         

    }

}
}