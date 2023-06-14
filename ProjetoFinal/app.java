package ProjetoFinal;
import javax.swing.JOptionPane;
import ProjetoFinal.Conta.ContaPJ;
import ProjetoFinal.Conta.ContaPF;

public class App {
 public static void main(String[] args) {
        //criar o meu vetor de objetos
        ContaPJ clientePJ[] = new ContaPJ[10];
        ContaPF clientePF[] = new ContaPF[10];
        //começar meu banco
        boolean aberto = true;
        int contPJ=0;//contador de contas abertas
        int contPF=0;
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                        +"\n 1-Abrir Conta PJ"
                        +"\n 2-Abrir Conta PF"
                        +"\n 3-Acessar Conta PJ"
                        +"\n 4-Acessar Conta PF"
                        +"\n 5-Acessar saldo PJ"));
            if(acao==1){//abrir a conta pj
                //criar um objeto
                clientePJ[contPJ] = new ContaPJ();//chamei o construtor
                //preencher os atributos do objeto
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa:"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa:"));
                clientePJ[contPJ].setnConta(2000+contPJ);
                clientePJ[contPJ].setSaldo(0);
                //acrescimo no contador
                JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPJ++;}
            else if(acao==2){//abrir a conta pf
                //criar um objeto
                clientePF[contPF] = new ContaPF();//chamei o construtor
                //preencher os atributos do objeto
                clientePF[contPF].setNome(JOptionPane.showInputDialog("Informe o seu Nome:"));
                clientePF[contPF].setnCpf(JOptionPane.showInputDialog("Informe o seu CPF:"));
                clientePF[contPF].setnConta(000+contPF);
                clientePF[contPF].setSaldo(0);
                //acrescimo no contador
                JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso"
                );
                contPF++;
                         
                      
            }
            else if(acao==3){ //acessar uma conta já criada
                //localizar a conta no vetor
                int i;//contador
                int nContaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da Conta buscada"));
                for (i = 0; i < clientePJ.length; i++) {
                    if(nContaBuscada==clientePJ[i].getnConta()){
                        JOptionPane.showMessageDialog(null,"Conta Encontrada");
                        break;
                     }}}
            else if(acao==4){ //acessar uma conta já criada
                //localizar a conta no vetor
                int i;//contador
                int nContaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da Conta buscada"));
                for (i = 0; i < clientePF.length; i++) {
                    if(nContaBuscada==clientePF[i].getnConta()){
                        JOptionPane.showMessageDialog(null,"Conta Encontrada");
                        break;
                    } else if(acao==5){//saldo
                     int op =Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                        +"\n 1-Consultar o Saldo"
                        +"\n 2-Realizar um Saque"
                        +"\n 3-Solicitar um Emprestimo"));
                     break;
                }
                }
                //menu de acesso da conta
                boolean acesso = true;
                while(acesso){ //acessei a conta
                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                        +"\n 1-Consultar o Saldo"
                        +"\n 2-Realizar um Saque"
                        +"\n 3-..."));
                    if(acao==5){//saldo
                        JOptionPane.showMessageDialog(null, "Seu Saldo é de R$ "+clientePJ[i].getSaldo());
                    }
                }
            }
        }
 }}