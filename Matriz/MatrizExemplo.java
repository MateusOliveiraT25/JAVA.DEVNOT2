package Matriz;

import java.util.Random;
import java.util.Scanner;

public class MatrizExemplo {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exemplo1() {
        //gerar preencher, imprimir e manipular matrizes
        //criar uma matriz 10x9
        int matriz[][] = new int[10][9];//bidimensional 10x9
        //preencher minha matriz
        for (int i = 0; i < 10; i++) {//1º dimensão //linha
            for (int j = 0; j < 9; j++) {//2º dimensão //coluna
                //System.out.print("matriz["+i+"]["+j+"]=");
                matriz[i][j]=rd.nextInt(10);          
            }
        }
        //imprimir elemento por elemento da minha matriz
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("matriz["+i+"]["+j+"]="
                        +matriz[i][j]);
            }
        }
        //imprimir a matriz em formato linha x coluna
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j]+" ");
            }
            System.out.println("|");
        }
        // somar todos os elementos da 4 linha
        int somaLinha = 0;
        for (int i = 0; i < 9; i++) {
            somaLinha += matriz[3][i];
        }
        System.out.println("++++++++++++++++");
        System.out.println(" A soma da Linha 4 é "+somaLinha);

        //somas todos os elementos da 4ª coluna
        int somaColuna = 0;
        for (int i = 0; i < 10; i++) {
            somaColuna += matriz[i][3];
        }
        System.out.println("++++++++++++++++");
        System.out.println(" A soma da Coluna 4 é "+somaColuna);
    }
}
