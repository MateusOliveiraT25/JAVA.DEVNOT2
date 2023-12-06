package View;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;


public class JanelaPrincipal extends JFrame{
// criação do tabbedPane para incluir as tabs
private JTabbedPane jTPane;
public JanelaPrincipal() {
jTPane = new JTabbedPane();
add(jTPane);
// criandos as tabs
// tab1 carros

ClientesPainel tab1 = new ClientesPainel();
VendasPainel tab2 = new VendasPainel();
ConclusaoCompraPainel tab3 = new ConclusaoCompraPainel();
jTPane.add("Tela de Clientes", tab1);
jTPane.add("Tela de Registro de venda", tab2);
jTPane.add("Tela de Conclusão de Compras", tab3);
setBounds(100, 100, 600, 600);
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
}
//métodos para tornar a janela visível
public void run(){
this.setVisible(true);
}
}