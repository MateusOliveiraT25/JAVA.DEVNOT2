<<<<<<< HEAD
package InteracaoFor;
import java.util.Scanner;
public class ExemploFor {
    
    Scanner sc= new Scanner(System.in);
    public void exemplo1() {
        for(int i=0;i<10;i++){
            System.out.println("o nº da iteração é "+i);
            
        }
        
    }
    public void exemplo2() {
        int vetor[]=new int [10];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor["+i+"]=");
            vetor[i]=sc.nextInt();
            
        }
        for (int i = 9; i >=0; i--) {
            System.out.println("vetor["+i+"]="+vetor[i]);

            
        }
        
    }
    public void exemplo3() {
        double carrinhoCompra[]=new double[]{19.90,35.70,56.80,97.50};
        //finalizar a compra
        double valorFinal=0;
        for (int i = 0; i < carrinhoCompra.length; i++) {
            valorFinal+= carrinhoCompra[i];
            //imprimir valor parcial
            System.out.println("Valor Parcial Compra: R$  " 
                         +valorFinal);
            
        }
        //mostrar o valor final da compra
        System.out.println(" o valor da Compra é R$ "
                       +valorFinal);
        
    }
    public void exemplo4() {
        //ler 4 notas e mostrar as 4 notas e a média
        double vetorNotas[]= new double[4];
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Digite a Nota"+(i+1)+":");
            vetorNotas[i]=sc.nextDouble();
            
        }
        //imprimir as 4 notas e calcular a média
        double mediaNotas=0;
        for (int i = 0; i < vetorNotas.length; i++) {
         mediaNotas+=vetorNotas[i];
         System.out.println("A "+(i+1)+"ª Nota é"
                    +vetorNotas[i]);

            
        }
        mediaNotas/=vetorNotas.length;
        System.out.printf("A média do aluno é %.2f"
          ,mediaNotas);

        
    }
    public void exemplo5() {
        //ler 4 notas de 10 alunos
        //vetor guardar as médias
        double vetorMedia[]=new double[3];
        //preencher o vetor de médias
        for (int i = 0; i < vetorMedia.length; i++) {
            double notas=0;
            for(double j=0;j<4;j++){
                System.out.print("Nota "+(j+1)+ "Aluno "+(i+1)+":");
                notas+=sc.nextDouble();
            }
            notas/=4; //calcula a média
            vetorMedia[i]=notas;//coloca média no vetor

            
        }
        //imprimir notas >=7 do vetor média
        for (int i = 0; i < vetorMedia.length; i++) {
            if (vetorMedia[i]>=7) {
                System.out.println("A Média do Aluno"
                           +(i+1)+" é "+vetorMedia[i]);
                
            }

            
        }

        
    }
    public void exemplo6() {
        int vetor[]=new int[]{10,11,12,13,14};
        double resultadoFinal=0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor["+i+"]=");
            System.out.println("vetor["+i+"]="+vetor[i]);
        resultadoFinal+=vetor[i];
        
    
        System.out.println("Resultado soma"+
               +resultadoFinal );
          

          
            
        
        
    }
    for (int i = 0; i <vetor.length; i++) {
        
       
         


        
    }
    
resultadoFinal*=vetor[i];
    System.out.println("Resultado multiplicação"
    +resultadoFinal);

    
        
=======
package InteracaoFor;
import java.util.Scanner;
public class ExemploFor {
    
    Scanner sc= new Scanner(System.in);
    public void exemplo1() {
        for(int i=0;i<10;i++){
            System.out.println("o nº da iteração é "+i);
            
        }
        
    }
    public void exemplo2() {
        int vetor[]=new int [10];
        for (int i = 0; i < vetor.length; i++) {
            System.out.print("vetor["+i+"]=");
            vetor[i]=sc.nextInt();
            
        }
        for (int i = 9; i >=0; i--) {
            System.out.println("vetor["+i+"]="+vetor[i]);

            
        }
        
    }
    public void exemplo3() {
        double carrinhoCompra[]=new double[]{19.90,35.70,56.80,97.50};
        //finalizar a compra
        double valorFinal=0;
        for (int i = 0; i < carrinhoCompra.length; i++) {
            valorFinal+= carrinhoCompra[i];
            //imprimir valor parcial
            System.out.println("Valor Parcial Compra: R$  " 
                         +valorFinal);
            
        }
        //mostrar o valor final da compra
        System.out.println(" o valor da Compra é R$ "
                       +valorFinal);
        
    }
    public void exemplo4() {
        //ler 4 notas e mostrar as 4 notas e a média
        double vetorNotas[]= new double[4];
        for (int i = 0; i < vetorNotas.length; i++) {
            System.out.println("Digite a Nota"+(i+1)+":");
            vetorNotas[i]=sc.nextDouble();
            
        }
        //imprimir as 4 notas e calcular a média
        double mediaNotas=0;
        for (int i = 0; i < vetorNotas.length; i++) {
         mediaNotas+=vetorNotas[i];
         System.out.println("A "+(i+1)+"ª Nota é"
                    +vetorNotas[i]);

            
        }
        mediaNotas/=vetorNotas.length;
        System.out.printf("A média do aluno é %.2f"
          ,mediaNotas);

        
    }
    public void exemplo5() {
        //ler 4 notas de 10 alunos
        //vetor guardar as médias
        double vetorMedia[]=new double[3];
        //preencher o vetor de médias
        for (int i = 0; i < vetorMedia.length; i++) {
            double notas=0;
            for(double j=0;j<4;j++){
                System.out.print("Nota "+(j+1)+ "Aluno "+(i+1)+":");
                notas+=sc.nextDouble();
            }
            notas/=4; //calcula a média
            vetorMedia[i]=notas;//coloca média no vetor

            
        }
        //imprimir notas >=7 do vetor média
        for (int i = 0; i < vetorMedia.length; i++) {
            if (vetorMedia[i]>=7) {
                System.out.println("A Média do Aluno"
                           +(i+1)+" é "+vetorMedia[i]);
                
            }

            
        }

        
    }
    public void exemplo6() {
        int vetor[]=new int[]{10,11,12,13,14};
        double resultadoFinal=0;
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor["+i+"]=");
            System.out.println("vetor["+i+"]="+vetor[i]);
        resultadoFinal+=vetor[i];
        
    
        System.out.println("Resultado soma"+
               +resultadoFinal );
          

          
            
        
        
    }
    for (int i = 0; i <vetor.length; i++) {
        
       
         


        
    }
    
resultadoFinal*=vetor[i];
    System.out.println("Resultado multiplicação"
    +resultadoFinal);

    
        
>>>>>>> 8d0eb1b165c4cbc3820676c872ed9ede24288f60
}}