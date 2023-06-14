package ProjetoFinal.Conta;
import javax.swing.JOptionPane;
public abstract class   Conta  {
    String Nome;
    int nConta;
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

    
    
}
