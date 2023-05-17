package Matriz;

import java.util.Random;
import java.util.Scanner;

public class MatrizExercicios {
    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exemplo1() {

        int matriz[][] = new int[10][9];
        for (int i = 0; i < 10; i++) {// 1º dimensão //linha
            for (int j = 0; j < 9; j++) {// 2º dimensão //coluna
                // System.out.print("matriz["+i+"]["+j+"]=");
                matriz[i][j] = rd.nextInt(10);
            }
        }

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("matriz[" + i + "][" + j + "]="
                        + matriz[i][j]);
            }
        }
        // imprimir a matriz em formato linha x coluna
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.print(matriz[i][j] + " ");
            }
            System.out.println("|");
        }
        // somar todos os elementos da 4 linha
        int somaLinha = 0;
        for (int i = 0; i < 9; i++) {
            somaLinha += matriz[7][i];
        }
        System.out.println("++++++++++++++++");
        System.out.println(" A soma da Linha 7 é " + somaLinha);

        // somas todos os elementos da 4ª coluna
        int somaColuna = 0;
        for (int i = 0; i < 10; i++) {
            somaColuna += matriz[i][7];
        }
        System.out.println("++++++++++++++++");
        System.out.println(" A soma da Coluna 7 é " + somaColuna);
    }

public void exercicio1() {
    int matriz[][] = new int [5][5];
    for(int i = 0; i<matriz.length; i++){
        for(int j = 0; i<matriz.length; j++){
            if(i==j){
                matriz[i][j] = 1;
            }else{
                matriz[i][j] = 0;
            }}}
            
            for (int i = 0; i < matriz.length; i++) {
                System.out.print("| ");
                for (int j = 0; j < matriz.length; j++) {
                    System.out.print(matriz[i][j]+" ");
                }
                System.out.println("|");
            }}
            

            public void exercicio2() {
                    int matriz[][]=new int[4][4];

                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            matriz[i][j]= rd.nextInt(10);
                        }
                    }
                    for (int i = 0; i < matriz.length; i++) {
                        System.out.print("| ");
                        for (int j = 0; j < matriz.length; j++) {
                            System.out.print(matriz[i][j]+" ");
                        }
                        System.out.println("|");
                    }System.out.print("xxxxxxxxx ");
                    for (int i = 0; i < matriz.length; i++) {
                        System.out.print("| ");
                
                        for (int j = 0; j < matriz.length; j++) {
                            System.out.print(matriz[j][i]+" ");
                        }
                        System.out.println("|");
                    }
                    System.out.println("+++++++++++++++++++++");

                    int soma=0;
                    for (int i = 0; i < matriz.length; i++) {
                        for (int j = 0; j < matriz.length; j++) {
                            //soamr os item somente da diagonal principal
                            if (i==j) {
                                soma+=matriz[i][j];
                            }
                        }
                    }
                    System.out.println("A Soma da diagonal é "+soma);
                
            
                }}
