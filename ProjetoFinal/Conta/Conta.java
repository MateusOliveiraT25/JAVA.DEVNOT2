package ProjetoFinal.Conta;
import javax.swing.JOptionPane;
public abstract class   Conta  {
    String Nome;
    int nConta;
    double saldo;
    double saque;
    double valor;
    double deposito;
     

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
        System.out.println("\tEXTRATO");
        System.out.println("Nome: " + this.Nome);
        System.out.println("Número da conta: " + this.nConta);
        System.out.printf("Saldo atual: %.2f\n",this.saldo);
        System.out.println("Saques realizados hoje: " + this.saque + "\n");
        
    }
    
    public void Saque(){
        if(saldo >= saque){
            saldo -= saque;
            saque++;
            System.out.println("Sacado: " + saque);
            System.out.println("Novo saldo: " + saldo + "\n");
        } else {
            System.out.println("Saldo insuficiente. Faça um depósito\n");
        }
    }
    
    public void deposito()
    {
    
}
}