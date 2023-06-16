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
        int contPJ=0;
        int contPF=0;
        //contador de contas abertas
        while (aberto) {
            int acao = Integer.parseInt(JOptionPane.showInputDialog("Informe a ação Desejada:"
                        +"\n 1-Abrir Conta PJ"
                        +"\n 2-Abrir Cont PF"
                        +"\n 3-Acessar Conta PJ"
                        +"\n 4-Acessar Conta PF"
                        +"\n 5-Sair"));
            if(acao==1){//abrir a conta 
                //criar um objeto
                clientePJ[contPJ] = new ContaPJ();//chamei o construtor
                //preencher os atributos do objeto
                clientePJ[contPJ].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa:"));
                clientePJ[contPJ].setnCnpj(JOptionPane.showInputDialog("Informe o CNPJ da Empresa:"));
                clientePJ[contPJ].setnConta(
                    2000+contPJ);
                clientePJ[contPJ].setSaldo(0);
                //acrescimo no contador
                JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPJ++;
            } else if(acao==3){ //acessar uma conta já criada
                //localizar a conta no vetor
                int i;//contador
                int nContaBuscada = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da Conta buscada"));
                for (i = 0; i < clientePJ.length; i++) {
                    if(nContaBuscada==clientePJ[i].getnConta()){
                        JOptionPane.showMessageDialog(null,"Conta Encontrada");
                         break; // Sai do loop while (acesso)
                            } else {
                                aberto=false;
                    }
  if(acao==2){//abrir a conta 
                //criar um objeto
                 clientePF[contPF] = new ContaPF();//chamei o construtor
                //preencher os atributos do objeto
                 clientePF[contPF].setNome(JOptionPane.showInputDialog("Informe o Nome da Empresa:"));
                clientePF[contPF].setnCpf(JOptionPane.showInputDialog("Informe o CNPJ da Empresa:"));
                clientePF[contPF].setnConta(
                    1000+contPF);
                clientePF[contPF].setSaldo(0);
                //acrescimo no contador
                JOptionPane.showMessageDialog(null,"Conta Criada com Sucesso");
                contPF++;
            } else if(acao==4){ //acessar uma conta já criada
                //localizar a conta no vetor
                int j;//contador
                int nContaBuscada  = Integer.parseInt(JOptionPane.showInputDialog("Informe o nº da Conta buscada"));
                for ( = 0; i < clientePF.length; j++) {
                    if(nContaBuscada==clientePF[j].getnConta()){
                        JOptionPane.showMessageDialog(null,"Conta Encontrada");
                        break;
                    }
                }
            }


                //menu de acesso da conta
                boolean acesso = true;
                while(acessoPJ){ //acessei a conta
                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                        +"\n 1-Consultar o Saldo"
                        +"\n 2-Realizar um Saque"
                        +"\n 3-Realizar um Deposito"
                        +"\n 4-Realizar um Extrato"
                        +"\n 5-Sair do app"));
                     if (acao == 1) { // saldo
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePJ[i].getSaldo());
                            } else if (acao2 == 2) { // Saque
                                clientePJ[i].Saque();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePJ[i].getSaldo());
                            } else if (acao2 == 3) { // deposito
                                clientePJ[i].deposito();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePJ[i].getSaldo());
                            } else if (acao2 == 4) { // emprestimo
                                clientePJ[i].extrato();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePJ[i].getSaldo());
                            } else if (acao2 == 5) { // Sair da conta
                                JOptionPane.showMessageDialog(null,
                                        "Sessão encerrada.");
                                acesso = false; // Define acesso como falso para sair do loop
                                break; // Sai do loop while (acesso)
                            } else {
                                acesso=false;
                            }
                        }
                        if (i == contPJ) {
                            JOptionPane.showMessageDialog(null, "Conta PJ não encontrada");
                        } boolean acesso = true;
                while(acessoPF){ //acessei a conta
                    int acao2 = Integer.parseInt(JOptionPane.showInputDialog("Informe a operação Desejada:"
                        +"\n 1-Consultar o Saldo"
                        +"\n 2-Realizar um Saque"
                        +"\n 3-Realizar um Deposito"
                        +"\n 4-Realizar um Extrato"
                        +"\n 5-Sair do app"));
                    }
                      if (acao == 1) { // saldo
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePF[i].getSaldo());
                            } else if (acao2 == 2) { // Saque
                                clientePF[i].Saque();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePF[i].getSaldo());
                            } else if (acao2 == 3) { // deposito
                                clientePF[i].deposito();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePF[i].getSaldo());
                            } else if (acao2 == 4) { // emprestimo
                                clientePF[i].extrato();
                                JOptionPane.showMessageDialog(null,
                                        "Seu Saldo é de R$ " + clientePF[i].getSaldo());
                            } else if (acao2 == 5) { // Sair da conta
                                JOptionPane.showMessageDialog(null,
                                        "Sessão encerrada.");
                                acesso = false; // Define acesso como falso para sair do loop
                                break; // Sai do loop while (acesso)
                            } else {
                                acesso=false;
                            }
                        }
                        if (i == contPF) {
                            JOptionPane.showMessageDialog(null, "Conta PF não encontrada");
                        }
                    }
                }
            }
