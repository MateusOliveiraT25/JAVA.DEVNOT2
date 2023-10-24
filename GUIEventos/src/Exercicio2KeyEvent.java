import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
public class Exercicio2KeyEvent extends JFrame{
    //atributos
    private JPanel mainP;
    private JLabel letraDigitada;
    private JTextField caixaDigicao;
    private JLabel textoDigitado;
    //construtor
    public Exercicio2KeyEvent() {
        super("Exercicio 2");
        this.setDefaultCloseOperation(2);
        this.setBounds(100,100,400,250);
        //add painel principal = grid layout (4,1)
        mainP = new JPanel(new GridLayout(4,1));
        this.add(mainP);
        //add Componentes
        letraDigitada = new JLabel("A letra digitada é ");
        mainP.add(letraDigitada);
        mainP.add(new Label("Digite seu texto"));
        caixaDigicao = new JTextField("");
        mainP.add(caixaDigicao);
        textoDigitado = new JLabel("");
        mainP.add(textoDigitado);

        //criar tratamento de eventos = Handler
        Handler evt = new Handler();
        caixaDigicao.addKeyListener(evt);


    }
    public class Handler implements KeyListener{

        @Override
        public void keyTyped(KeyEvent e) {
          char teclaApertada = e.getKeyChar();
          letraDigitada.setText("A letra digitada é " +teclaApertada);
        }

        @Override
        public void keyPressed(KeyEvent e) {
           
        }

        @Override
        public void keyReleased(KeyEvent e) {
            textoDigitado.setText(caixaDigicao.getText());
        }}
    public void run(){
        this.setVisible(true);
    }

}
