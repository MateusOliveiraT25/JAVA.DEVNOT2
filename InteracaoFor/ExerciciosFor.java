package InteracaoFor;
import java.util.Scanner;
public class ExerciciosFor {
    Scanner sc= new Scanner(System.in);
    public void exercicio1() {
        // criar vetor de 5 posiçoes
        int vetor[]=new int[5];
        //preencher o vetor"for"
        for(int i =0; i < vetor.length;i++){
            //solicitar o usuario escrever o nº
            System.out.println("Informe o valor do vetor["+i+"]=");
            //ler o valor digitado 
            vetor[i]=sc.nextInt();}
        }
        public void exercicio2() {
            int vetor[]=new int [10];
            for (int i = 0; i < vetor.length; i++) {
                System.out.print("vetor["+i+"]=");
                vetor[i]=sc.nextInt();
            }
            for (int i = 9; i >=0; i--) {
                System.out.println("vetor["+i+"]="+vetor[i]);
            }
        }
        public void exercicio3() {
            //ler 4 notas e mostrar as 4 notas e a média
            double vetorNotas[]= new double[4];
            for (int i = 0; i < vetorNotas.length; i++) {
                System.out.print("Digite a Nota"+(i+1)+":");
                vetorNotas[i]=sc.nextDouble();
            }
            //imprimir as 4 notas e calcular a média
            double mediaNotas=0;
            for (int i = 0; i < vetorNotas.length; i++) {
             mediaNotas+=vetorNotas[i];
             System.out.println("A "+(i+1)+"ª Nota é "
                        +vetorNotas[i]);
            }
            mediaNotas/=vetorNotas.length;
            System.out.println("A média do aluno é "
              +mediaNotas);}
              public void exercicio4() {
                char letras[] = new char[]{'a','b','c','d','e','f','g','h','i','j'};
                String letras2[] = new String[]{"a","b","c","d","e","f","g","h","i","j"};
                //percorrer o vetor para procurar letras vogais ou consoantes
                //contar o nº de consoantes
                int cont=0;
                for (int i = 0; i < letras2.length; i++) {
                    if(letras2[i]!="a" && letras2[i]!="e"&& letras2[i]!="i" 
                    && letras2[i]!="o" && letras2[i]!="u"
                    );
                    System.out.println(letras2[i]+" é consoante");
                    cont++;}}

                    //Exercicio4 extra ler as consoantes de palavra digitada

                    public void exercicio4ex() {
                        System.out.println("Digite uma Palavra");
                        String palavra = sc.next();
                        palavra = palavra.toLowerCase();
                        //percorrer o vetor para procurar letras vogais ou consoantes
                         //percorrer o Sring para procurar letras vogais ou consoantes
                        //contar o nº de consoantes
                        int cont=0;
                        for (int i = 0; i < palavra.length(); i++) {
                            char c = palavra.charAt(i);
                            if(c!='a' && c!='e'&& c!='i' 
                            && c!='o' && c!='u');
                      
                            System.out.println(c +" é consoante");
                            cont++;
                            System.out.println("O numero de consoante é " + cont);}
                
               }
        
        public void exercicio5() {
           //ler 5 numeros separar em pares e impares
           int numeros[] = new int [20];
           int contPar;
           int contImpar;
           //prencher o vetor de nº
           for(int i =0; i < numeros.length;i++){
            System.out.println("Informe o nº["+i+"]=");
            numeros[i]=sc.nextInt();
            if(numeros[i]%2==0){
                contPar++;
            }else {
                contImpar++;
            }
           int nPar[]=new int [contPar];
           int nImpar[]=new int [contImpar];
           contPar =0;
           contImpar =0;
           for (int i =0; i < numeros.length;i++){
            if(numeros[i]%2==0){
                nPar [contPar]=numeros[i];
                contPar++;
            }else{
                    nImpar [contImpar]=numeros[i];
                    contImpar++;
            }
        }
        }
        public void exercicio6() {
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
    
        }
        public void exercicio7() {
            int vetor[]=new int[5];
            for(int i =0; i < vetor.length;i++){


    }

}}