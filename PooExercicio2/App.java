package PooExercicio2;


import javax.swing.JOptionPane;
import java.util.Random;
public class App {

    public static void main(String[] args) {
        Random rd = new Random();
        //vetor de objetos
        Agenda pessoas[] = new Agenda[10];
        //prencher o meu vetor/array
        for(int i = 0;i < pessoas.length;i++){
            pessoas[i]= new Agenda();
            //preencher os atributos
            pessoas[i].setNome(JOptionPane.showInputDialog("Nome: "));
            pessoas[i].setAltura(rd.nextDouble(1.5,2.1));
            pessoas[i].setIdade(rd.nextInt(18,99));}
          
              //Buscador
            String nomeDigitado = JOptionPane.showInputDialog("Nome: ");
            int cont =0;
            boolean teste=true;
            while(teste){
                if(!nomeDigitado.equals(pessoas[cont].getNome())){
                    teste = false;
                    

                }

            }
           System.out.println("Nome"+ pessoas[cont].getNome()
           +"Idade" +pessoas[cont].getIdade()
           +"Altura" +pessoas[cont].getAltura());

                
            

        }
    }

