package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Agenda.Agenda;
import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;

public class App {
        //cria o cadastro(armaze   nar no vetor)
      public static void main(String[] args) {
    Cachorro cachorro[] = new Cachorro[10];
    Gato gatos[] = new Gato[10];
    Outros outros[] = new Outros[10];
     Agenda agenda[] = new Agenda[100];
    int contCH = 0;
    int contGT = 0;
    int contOT = 0;
    int contAg = 0;
        
        //criar a minha aplicação
        JOptionPane.showMessageDialog(null, "Bem-Vindo ao Consultório\n Veterinario");
        boolean aberto = true;
        while (aberto) {
            int acao1 = Integer.parseInt(JOptionPane.showInputDialog("1-Cadastro\n 2-Consulta\n 3-Sair"));
            if(acao1==1){//cadastro
                int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
                if(acao2==1){//cadastro dos gato
                    //criar um objeto
                    gatos[contGT] = new Gato();//utilizei o construtor
                    //setar os valores do cadastro
                    gatos[contGT].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    gatos[contGT].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    gatos[contGT].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    gatos[contGT].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    //contador +1
                   contGT++;
                }else if(acao2==2){//cadastro do cachorro
                    //criar um objeto
                    cachorro[contCH] = new Cachorro();//utilizei o construtor
                    //setar os valores do cadastro
                    cachorro[contCH].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    cachorro[contCH].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    cachorro[contCH].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    cachorro[contCH].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    //contador +1
                    contCH++;
                }else if(acao2==3){//Cadastro de outros Tipos de PET
                    //criar um objeto
                    outros[contOT] = new Outros();//utilizei o construtor
                    //setar os valores do cadastro
                    outros[contOT].setNome(JOptionPane.showInputDialog("Informe o Nome do PET"));
                    outros[contOT].setRaca(JOptionPane.showInputDialog("Informe a Raça do PET"));
                    outros[contOT].setProprietario(JOptionPane.showInputDialog("Informe o Nome do Proprietario"));
                    outros[contOT].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
                    //contador +1
                    contOT++;
                }
            }else if(acao1==2){//agendar consulta
               // 1º verificação - cadastro do nome
               boolean cadastroOk = false;
               String nomeAgenda = JOptionPane.showInputDialog("Informe o nome do PET");
                 for(int i = 0; i < contGT; i++){
                  if(gatos[i].getNome().equals(nomeAgenda)){
                    JOptionPane.showMessageDialog(null, "Pet encontrado");
                    cadastroOk =true;
                    break;
                  }
                 }
               for(int i = 0; i < contCH; i++){
                  if(cachorro[i].getNome().equals(nomeAgenda)){
                    JOptionPane.showMessageDialog(null, "Pet encontrado");
                      cadastroOk =true;
                    break;
                  }
                 }
                  for(int i = 0; i < contOT; i++){
                  if(outros[i].getNome().equals(nomeAgenda)){
                    JOptionPane.showMessageDialog(null, "Pet encontrado");
                      cadastroOk =true;
                    break;
                  }
                 }
                 //2º Terminar o Cadastro 
                if(cadastroOk){
                  boolean agendar = true;
                  while(agendar){
                    String dataAgenda =JOptionPane.showInputDialog("Informe a data do Agendamento");
                     String horaAgenda =JOptionPane.showInputDialog("Informe a data do Agendamento");
                     if(contAg==0){
                      agenda[contAg] = new Agenda();
                      agenda[contAg].setData(dataAgenda);
                      agenda[contAg].setData(dataAgenda);

                    }else{
                      for (int i = 0; i < contAg; i++) {
                          if(agenda[i].getDataHora().equals(dataAgenda+horaAgenda)){
                              //não pode agendar
                              break;
                            }else{
                              agenda[contAg] = new Agenda();
                              agenda[contAg].setData(dataAgenda);
                              agenda[contAg].setHora(horaAgenda);
                              agendar = false;
                          }
                      }
            }
        }

        
      }
}
}}} 


