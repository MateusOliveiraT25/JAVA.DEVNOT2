package ExercicioOperadores;

import java.util.Scanner;

import javax.print.attribute.standard.Media;

public class NotaAlunos {
    Scanner sc = new Scanner(System.in);
    public void notaFrequencia() {
        System.out.println("Informe a nota 1 do aluno");
        int nota1 =sc.nextInt();
        System.out.println("Informe a nota 2 do aluno");
        int nota2 =sc.nextInt();
       double mediaAluno=(nota1+nota2)/2;
       System.out.println("A media do Aluno foi" 
       + mediaAluno);
       System.out.println("Informe a frequencia do aluno");
       boolean mediaAprovado = mediaAluno >= 50;
       System.out.println("O aluno esta Aprovado por nota?" 
       + mediaAprovado);
       System.out.println("Informe a frenquencia do  Aluno:");
       int frequenciaAluno = sc.nextInt();
       boolean frenquenciaAprovado = frequenciaAluno >= 75;
       System.out.println("O aluno esta Aprovado por frequencia?" 
       + frenquenciaAprovado);
       boolean aprovacaoFinal = (mediaAprovado==true)
       &&(frenquenciaAprovado==true);
       System.out.println("O aluno esta aprovado no curso?"
        +aprovacaoFinal);

    }
        
    }

