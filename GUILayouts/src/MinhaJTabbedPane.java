import javax.swing.JTabbedPane;

public class MinhaJTabbedPane extends JTabbedPane{
    public MinhaJTabbedPane() {
        super();
       this.add("Calculadora",new Calculadora());
       this.add("Calculadora Custo Viagem",new CalculadoraCustoViagem());
       //this.add("Outro",new FlowLayoutExemplo());
    }
}