package EstudoArrayList;

import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ExemploArrayList {
    // atributo
    // Declarando o ArrayList do tipo String
    ArrayList<String> Carros = new ArrayList<>();

    // metodos
    public void teste() {
        Carros.add(JOptionPane.showInputDialog("Informe o Nome do carro"));
        // Adicionar valores ao ArrayList
        Carros.add("Uno");
        Carros.add("Chevette");
        Carros.add("Celta");
        Carros.add("Monza");
        Carros.add("Gol");
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
        ArrayList<Integer> numero = new ArrayList<>();
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro")));
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro")));
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro")));
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro")));
        numero.add(Integer.parseInt(JOptionPane.showInputDialog("Digite um Nº Inteiro")));
         System.out.println(numero);
        }
}