package IteracaoFor;

import java.util.Scanner;

public class Exercicios {
    Scanner sc= new Scanner(System.in);
    public void exercicio4() {
        //ler um vetor de carcteres e contar as consoantes
   // char letras[]= new char[]{'a','b','c','d','e','f','g','h','i','j',};   
       String letra2[]=new String[]{"a","b","c","d","e","f","g","h","i","j"};
       int cont= 0;
       for (int i = 0; i < letra2.length; i++) {
        if (letra2[i]!="a"&& letra2[i]!="e" && letra2[i]!="i" && letra2[i]!="u" && letra2[i]!="o" ) {
            System.out.println(letra2[i] + "é consoante");
            cont++;
        }
        
        System.out.println("O nº de consoantes é "+ cont);
        
    }
    

    
}
public void exercicio4Ex() {
    System.out.println("Digite uma palavra");
   String palavra= sc.next();
   palavra= palavra.toLowerCase();
   int cont= 0;
   for (int i = 0; i < palavra.length(); i++) {
    char c= palavra.charAt(i);
    if (c!='a'&& c!='e' && c!='i' && c!='u' && c!='o' ) {
        System.out.println(palavra[i] + "é consoante");
        cont++;
        
    }
    System.out.println("O nº de consoantes é "+ cont);
    
   }
   


}
//ler 20 números e separar em Pares e Impares
public void exercicio5() {
    int numeros[]= new int [20];
    int contPar=0;
    int ContImpar=0;
    //preencher o vetor de numeros
    for (int i = 0; i < numeros.length; i++) {
        System.out.println("Informe o nº["+i+"]");
        numeros[i]=sc.nextInt();
        if (numeros[i]%2==0) {
            contPar++;
            
        }
        else{
            ContImpar++;
        }
       

        
    }
     //apos a contagem dos pares e impares criar os respectivos vetores
     int nPar[]=new int [contPar];
     int nImpar[]=new int [ContImpar];
     //distribuir os nº do vetor nº para os vetores
     contPar=0;
     ContImpar=0;
     for (int i = 0; i < nImpar.length; i++) {
        if (numeros[i]%2==0) {
            nPar[contPar]=numeros[i];
            contPar++;
            
        }
        else {
            nImpar[ContImpar]= numeros[i];
            ContImpar++;
        }
         
     }}

     public void exercicio7() {
        //criar vetor
        int vetor[]=new int[]{1,2,3,5,7};
        //percorrer o vetor e realizar as operações(+ e *)
        int soma = 0;//acumular a soma dos elementos do vetor
        int mult = 1;//acumular a multiplicação dos elementos do vetor
        for (int i = 0; i < vetor.length; i++) {
            soma+=vetor[i]; //acumula a soma
            mult*=vetor[i]; //acumula a multiplicação
        }
        System.out.println("O valor da Soma do vetor é "+soma);
        System.out.println("O valor da Multiplicação do vetor é "+mult);
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor["+i+"]="+vetor[i]);
        }
    }
public void exercicio8() {    // ler idade e altura de 5 pessoas
    String nome[] = new String[5];
    int idade[] = new int[5];
    double altura[] = new double[5];
    
for(int i=0;i<altura.length;i++){
    System.out.print("Informe o Nome :");
    nome[i]=sc.next();
    System.out.print("Informe a Idade :");
    idade[i]=sc.nextInt(i);
    System.out.print("Informe a altura: ");
    altura[i]=sc.nextDouble();
    System.out.println("======================");
}
//imprimir na ordem inversa
for (int i = 4; i >=0; i--) {
    System.out.println("Nome: "+nome[i]);
    System.out.println("Idade: "+idade[i]);
    System.out.println("Altura: "+altura[i]);
    System.out.println("+++++++++++++++++++++++");
}

}public void exercicio9() { 

    int vetor[]=new int[]{1,2,3,4,5,6,7,8,9,10};
    int soma=0;
    for (int i = 0; i < vetor.length; i++) {
        soma+=vetor[i]*vetor[i];
    } System.out.println("a Soma dos Quadrados é "+soma);

}}public void exercicio1ex() { 





    
}