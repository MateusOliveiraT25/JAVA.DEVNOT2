package AtividadeFormativa;

import java.util.Random;
import java.util.Scanner;

public class Atividade {

    Scanner sc = new Scanner(System.in);
    Random rd = new Random();

    public void exercicio1() {
        int linha=0;
        int coluna=0;
        System.out.println("Informe a quantidade de linhas da matriz");
        linha=sc.nextInt();
        System.out.println("Informa a quantidade de Colunas");
        coluna=sc.nextInt();
      
      
        int matriz [][] =new int[linha][coluna];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                matriz[i][j]=rd.nextInt(10);
                
            }
        }
        for (int i = 0; i < matriz[0].length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                System.out.println("matriz["+i+"] ["+j+"]=" 
                +matriz[i][j]);
                

                
            }
        }
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz.length; j++) {
                if (i>j) {
                    matriz [i][j]=1;
                    
                }
                else if (i==j){
                    matriz [i][j]=0;
                }
                else {
                    matriz [i][j]=2;

                }
             
              
               
                
            }
        }
       for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz.length; j++) {
            System.out.println("matriz["+i+"] ["+j+"]=" 
                +matriz[i][j]);
        }
       }

        
    }

    public void exercicio2() {
        int numeroAleatorio = rd.nextInt(1000);
        int numeroDigitado;
        int cont = 1;
        System.out.println("Digite um numero");
        numeroDigitado = sc.nextInt();
        while (numeroDigitado != numeroAleatorio) {
            System.out.println("Erro!! Tente Novamente");
            int numero = sc.nextInt();
            System.out.println("");
            if (numero == numeroAleatorio) {
                System.out.println("Acertou!!");
                System.out.println("");
                System.out.println("Vamos de novo!!");
                numero = sc.nextInt();
            }
            if (numero < numeroAleatorio) {
                System.out.println("Um pouco mais");
                System.out.println("");
            } else {
                System.out.println("Um pouco menos");
                System.out.println("");

            }
        }
        cont++;
        System.out.println("Numeros de ten" + cont);

    }

    public void exercicio3() {
        
        double[] vetorT = new double[rd.nextInt(900)+100];
        int vetor[]= new int [vetorT];
        for(int i=0;i < vetor.length;i++){
            vetor[i]=rd.nextInt(100+1);
        }
        int contImparNoPar =0;
        int contParNoImpar =0;

        for(int i = 0;i<vetor.length;i++){
            if(vetor[i]%2==0){
                System.out.println(vetor[i]);
                if(i%2==0){
                    contParNoImpar;}
            }
        
        } for(int i = 0;i<vetor.length;i++){
            if(vetor[i]%2==0){
                System.out.println(vetor[i]);
                if(i%2==0){
                    contImparNoPar; 
                }}}
            
    
            }}