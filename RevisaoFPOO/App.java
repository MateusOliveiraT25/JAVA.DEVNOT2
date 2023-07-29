package RevisaoFPOO;

import javax.swing.JOptionPane;

import RevisaoFPOO.Cadastro.Cachorro;
import RevisaoFPOO.Cadastro.Gato;
import RevisaoFPOO.Cadastro.Outros;

public class App {
  public static void main(String[] args) {
    Cachorro cadastroCh[] = new Cachorro[10];
    Gato cadastroGt[] = new Gato[10];
    Outros cadastroOt[] = new Outros[10];
    int contCH = 0;
    int contGT = 0;
    int contOT = 0;
    boolean aberto = true;
    while (aberto) {
      int acao1 = Integer.parseInt(JOptionPane.showInputDialog("Selecione:"
          + "\n 1-Cadastro"
          + "\n 2-Consulta"
          + "\n 3-Sair"));

      if (acao1 == 1) {
                       // criar um objeto
        int acao2 = Integer.parseInt(JOptionPane.showInputDialog("1-Gato\n 2-Cachorro\n 3-Outro Animal"));
        if (acao2 == 2) {
          cadastroCh[contCH] = new Cachorro();// chamei o construtor
          // preencher os atributos do objeto
          cadastroCh[contCH].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
          cadastroCh[contCH].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
          cadastroCh[contCH].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
          cadastroCh[contCH].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
          cadastroCh[contCH].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
          contCH++;}
         else if (acao2 == 1) {
          // criar um objeto
          cadastroGt[contGT] = new Gato();// chamei o construtor
          // preencher os atributos do objeto
          cadastroCh[contGT].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
          cadastroCh[contGT].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
          cadastroCh[contGT].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
          cadastroCh[contGT].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
          cadastroCh[contGT].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
          contGT++;}
        
        // Sai do loop while (acesso)

        else if (acao2 == 3) {
          // criar um objeto
          cadastroOt[contOT] = new Outros();// chamei o construtor
          // preencher os atributos do objeto
          cadastroOt[contOT].setNome(JOptionPane.showInputDialog("Informe o Nome do Animal:"));
          cadastroOt[contOT].setPeso(Double.parseDouble(JOptionPane.showInputDialog("Informe o Peso do PET")));
          cadastroOt[contOT].setEspecie(JOptionPane.showInputDialog("Informe o especie:"));
          cadastroOt[contOT].setRaca(JOptionPane.showInputDialog("Informe o raça:"));
          cadastroOt[contOT].setProprietario(JOptionPane.showInputDialog("Informe o seu Nome:"));
          contOT++;}
          break; // Sai do loop while (acesso)
        }  {
           aberto = false;

        }
         
        
      }
      
    
         }
        }
      
    
  
  


  