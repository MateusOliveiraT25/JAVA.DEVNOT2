package EstudoArrayList;

import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    // atributo
    // Declarando o ArrayList do tipo String
    ArrayList<String> Carros = new ArrayList<>();
    ArrayList<Integer> numero = new ArrayList<>();
    // metodos
    public void teste() {
        Carros.add(JOptionPane.showInputDialog("Informe o Nome do carro"));
        // Adicionar valores ao ArrayList
        Carros.add("Uno");
        Carros.add("Chevette");
        Carros.add("Celta");
        Carros.add("Monza");
        Carros.add("Gol");
        //ordenando a lista
        Collections.sort(Carros);
        // reversa a lista
         Collections.reverse(Carros);
        // Imprimir toda alista
        System.out.println(Carros);
        // pegando o valor correspodente a 5 posição(index 4)
        System.out.println(Carros.get(4));
        // pecorrer a lista com for
        for (int i = 0; i < Carros.size(); i++) {
            System.out.println(Carros.get(i));
        }
        // percorrendo a lista com o FOR-EACH
        for (String i : Carros) {
            System.out.println(i);
        }

        // Apagar a lista
        Carros.clear();
        System.out.println(Carros);
    }

    public void exercicio() {
      for (int i = 0; i < 5; i++) {
        
      
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite 5 numeros inteiro")));
      }Collections.sort(numero);
      Collections.reverse(numero);
        for (int i : numero) {
            System.out.println(i);
        }
         
        }
}