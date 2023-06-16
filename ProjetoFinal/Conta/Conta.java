package ProjetoFinal.Conta;
import javax.swing.JOptionPane;
public abstract class   Conta  {
    String Nome;
    int nConta;
    double saldo;
   
     

    public int getnConta() {
        return nConta;
    }
    public void setnConta(int nConta) {
        this.nConta = nConta;
    }
    public String getNome() {
        return Nome;
    }
    public void setNome(String nome) {
        Nome = nome;
    }

    public void extrato(){
        double extrato = Double.parseDouble(JOptionPane.showInputDialog("O extrato é: "+Nome; nConta;Saldo));
        
        
    }
    
    public void saque() {
        double sacar = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja sacar: "));
        if (sacar <= saldo) {
            double resultado = saldo - sacar;
            JOptionPane.showMessageDialog(null, "O saque foi realizado com sucesso!"
                    + "\n Saldo atual: "
                    + resultado);
        } else {
            JOptionPane.showMessageDialog(null, "O saldo é Insuficiente");
        }
    }

    public void deposito() {
        double depositar = Double.parseDouble(JOptionPane.showInputDialog("Informe o valor que deseja depositar: "));
        double resultado = saldo + depositar;
        JOptionPane.showMessageDialog(null, "O deposito foi realizado com sucesso!"
                    + "\n Saldo atual: "
                    + resultado);
    }
