package InteracaoWhile;
import java.util.Scanner;
import java.util.Random;

public class ExemploWhile {
    Scanner sc = new Scanner(System.in);
   
    public void exemplo1() {
        int iteracao = 0;
        while (iteracao<10) {
            System.out.println("O numero da iteracao é " + iteracao);
            iteracao += 1;}}

            public void exemplo2() {
                Random rd = new  Random();
            int numeroAleatorio = rd.nextInt(100);
            boolean tenteNovamente= true;
            while (tenteNovamente) {
                System.out.println("Tente Adivinhar o numero");
                int numero = sc.nextInt();
                if(numero==numeroAleatorio){
                    System.out.println("Acertou Miseravel!");
                    tenteNovamente=false;}
                    else{
                        System.out.println("Errou !! Tente novamente");
                    }

                }} public void exemplo3() {
               int vetor[] = new int[5];
               int i = 0;
               while(i<5){
                System.out.println("Digite o valor para o vetor["+i+"] ");
                vetor[i]=sc.nextInt();
                i++;
               } i=0;
               while(i<5){
               
                System.out.println("O valor do vetor["+i+"]"+vetor[i]);
                i++;
               }
            
        
               
                }

            }

            