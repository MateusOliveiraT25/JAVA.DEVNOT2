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
            pessoas[i+18].setIdade(rd.nextInt(18,99));}
          
              //Buscador
            String nomeDigitado = JOptionPane.showInputDialog("Digite um nome para biscar na agenda: ");
            int cont =0;
            boolean procurar=true;
            while(procurar){
                if(nomeDigitado.equals(pessoas[cont].getNome())){
                    procurar = false;
                    pessoas[cont].imprimir();
                                    }
                cont++;

            }}
          
                
            

        
        
        }