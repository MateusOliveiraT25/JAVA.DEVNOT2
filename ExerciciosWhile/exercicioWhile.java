package ExerciciosWhile;
import java.util.Scanner;

public class exercicioWhile {
    Scanner sc = new Scanner(System.in);
    //lendo um vetor de string com laço while
    //criar um vetor de 10 letras
    public void exercicio1() { String letras[]=new String[]{"a","b","c","d","e","f","g","h","i","j"};
    int i =0;
    int cont = 0;//contador paras consoantes
    while(i<letras.length){
       if(letras[i]=="a"||letras[i]=="e"||letras[i]=="i"||letras[i]=="o"||letras[i]=="u"){

       }else{
        cont++;
        System.out.println(letras[i]+" é consoante");
       }
       i++;

    
   
    }System.out.println("O total de consoantes é "+cont);}

 public void exercicio1a() { String letras[]=new String[]{"a","b","c","d","e","f","g","h","i","j"};
int i =0;
int cont = 0;//contador paras consoantes
while(i<letras.length){
    switch(letras[i]){
        case"a":
        case"e":
        case"i":
        case"o":
        case"u":
        break;
        default:cont++;
        System.out.println(letras[i]+" é consoante");

    } i++;
    System.out.println("O total de consoantes é "+cont);}
}

public void exercicio2() {
    int vetores[] =new int[]{1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
    int i =0;
    int contPar=0;
    int contImpar=0;
    while(i<vetores.length){
       if(vetores[i]%2==0){
        contPar++;
       }else {
        contImpar++;
       }i++;
    }int vetoresPar[]=new int[contPar];
    int vetoresImpar[]=new int[contImpar];
    i=0;
    contPar=0;
    contImpar=0;
    while(i<vetores.length){
        if(vetores[i]%2==0){
           vetoresPar[contPar]=vetores[i];
           contPar++;
           }else {
            vetoresImpar[contImpar]=vetores[i];
            contImpar++;
    }i++;

}i=0;
while(i<vetores.length){
    System.out.println("Vetor["+i+"]="+vetores[i]);
    i++;
}
i=0;
while(i<vetores.length){
    System.out.println("VetorPar["+i+"]="+vetoresPar[i]);
    i++;
}
i=0;
while(i<vetores.length){
    System.out.println("VetorImpar["+i+"]="+vetoresImpar[i]);
    i++;};
}
}
