import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Random;

import javax.swing.JOptionPane;

/**
 * exemploArryList
 */
public class ExemploArrayList {
//atributo
//Declarando a ArrayList do Tipo String
 ArrayList<String> carros = new ArrayList<>();
 //métodos
 public void teste(){
    //Adicionar o valor ao ArrayList
    carros.add("Uno");
    carros.add("Chevette");
    carros.add("Fusca");
    carros.add("Celta");
    carros.add("Brasilia");
    //ordernando a lista 
    Collections.sort(carros);
   //imprimir toda a lista
    System.out.println(carros);
    //pegando o valor correspondente a 5 posição(index 4) 
    System.out.println(carros.get(4));
   //percorrendo a lista com FOR
    for (int i = 0; i < carros.size(); i++) {
        System.out.println(carros.get(i));


    
   }
   //Collections.reverse(invertendo as listas)
   Collections.reverse(carros);
   //percorrendo a lista com FOR-EACH
   for (String i : carros) {
    System.out.println(i);
    
   }
    //apagar a lista
    carros.clear();
    System.out.println(carros);


 }
 Random rd = new Random(1000);
 public void exercicio() {
    //criar um arraylist (Interger) + 5 valores
    ArrayList<Integer> valor = new ArrayList<>(5);
    int n1=rd.nextInt(100);
     int n2=rd.nextInt(100);
      int n3=rd.nextInt(100);
       int n4=rd.nextInt(100);
        int n5=rd.nextInt(100);
    valor.add(n1);
    valor.add(n2);
    valor.add(n3);
    valor.add(n4);
    valor.add(n5);
    Collections.sort(valor);
    System.out.println(valor);



    

    
}
ArrayList<Integer> num= new ArrayList<>(5);
public void execicio0() {
   //criar um arraylist (integer )+ 5 valores
   //preencher 5 n° int
   
   for (int i = 0; i < 5; i++) {
      num.add(Integer.parseInt(JOptionPane.showInputDialog("Informe 5 N° Inteiros")));
      
      
      
   }
   for (int i  : num) {
      System.out.println(i);

      
   }
   
}
 
}
