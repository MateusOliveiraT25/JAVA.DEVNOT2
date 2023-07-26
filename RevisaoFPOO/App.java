package  RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;
public class App {
  public static void main(String[] args) {
  Cachorro cadastroCh[] = new Cachorro[10];
  Gato cadastroGt[] = new Gato[10];
  Outros cadastroOt[] = new Outros[10];
  
  boolean aberto = true;
  int contCH=0;
  int contGT=0;
  int contOT=0;

 while (aberto) {
           int acao= Integer.parseInt(JOptionPane.showInputDialog("Cadastrar:"
                        +"\n 1-Cachorro"
                        +"\n 2-Gato"
                        +"\n 3-Outros"
                        +"\n 4-Sair"));

if(acao==1){//abrir a conta 
                //criar um objeto
                cadastroCh[contCH] = new Cachorro();//chamei o construtor
                //preencher os atributos do objeto
                cadastroCh[contCH].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
                cadastroCh[contCH].setPeso(JOptionPane.showInputDialog("Informe o peso:"));
                cadastroCh[contCH].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
                cadastroCh[contCH].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
                cadastroCh[contCH].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
                break; // Sai do loop while (acesso)
              } else {
                  aberto=false;
              }

 if(acao==2){//abrir a conta 
                //criar um objeto
                cadastroGt[contGT] = new Gato();//chamei o construtor
                //preencher os atributos do objeto
                cadastroCh[contGT].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
                cadastroCh[contGT].setPeso(JOptionPane.showInputDialog("Informe o peso:"));
                cadastroCh[contGT].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
                cadastroCh[contGT].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
                cadastroCh[contGT].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
  break; // Sai do loop while (acesso)
              } else {
                  aberto=false;
if(acao==3){//abrir a conta 
                //criar um objeto
                cadastroGt[contOT] = new Gato();//chamei o construtor
                //preencher os atributos do objeto
                cadastroOt[contOT].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
                cadastroOt[contOT].setPeso(JOptionPane.showInputDialog("Informe o peso:"));
                cadastroOt[contOT].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
                cadastroOt[contOT].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
                cadastroOt[contOT].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
  break; // Sai do loop while (acesso)
              } else {
                  aberto=false;



}

}

}

  }}