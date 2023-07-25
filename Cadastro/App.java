package Cadastro;
import javax.swing.JOptionPane;
import ;
import ;

public class App {
    public static void main(String[] args) {
        //criar o meu vetor de objetos
        EP clienteEP[] = new EP[10];
        
       
        boolean aberto = true;
        int contEP=0;
        //contador de contas abertas
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                        +"\n 1-Abrir Empresa"
                        +"\n 5-Sair"));
            if(acao==1){//abrir a conta 
                //criar um objeto
                clienteEP[contPJ] = new ContaEP();//chamei o construtor
                //preencher os atributos do objeto
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa:"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa:"));
                
                //acrescimo no contador
                JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPJ++;
       
                         break; // Sai do loop while (acesso)
                            } else {
                                aberto=false;
                    }
