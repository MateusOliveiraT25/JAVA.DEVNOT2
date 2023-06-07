package PooExercicio3;

import java.util.Scanner;

public class App {
  public static void main(String[] args) {
    //criar objeto
    Elevador  elevador1 = new Elevador(10, 10);
    Scanner sc = new Scanner(System.in);
    //inicializa
    elevador1.inicializa();
    boolean ligado = true;
    while(ligado){
        System.out.println("Informe a ação desejada"
        +"\n1-Entrar"
        +"\n2-Sair"
        +"\n3-Subir"
        +"\n4-Descer"
        +"\n5-Desligar");
        int acao = sc.nextInt();
        switch (acao){
            case 1:
            System.out.println("Capacidade Atual: "
                    + elevador1.entrar());
            break;
        case 2:
            System.out.println("Capacidade Atual: "
                    + elevador1.sair());
            break;
        case 3:
            System.out.println("Informe a Qtd de Andares para Subir");
            System.out.println("Andar Atual:"
            + elevador1.subir(sc.nextInt()));
    break;
case 4:
    System.out.println("Informe a Qtd de Andares para Descer");
    System.out.println("Andar Atual:"
            + elevador1.descer(sc.nextInt()));

            break;
            case 5:
            ligado=false;

        default:
        System.out.println("Informe um nº valido");
            break;
        }
    }

  }  
}
